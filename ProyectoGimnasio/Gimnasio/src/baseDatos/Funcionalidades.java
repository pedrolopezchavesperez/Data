package baseDatos;

import aplicacion.Actividad;
import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import aplicacion.Aviso;

/**
 *
 * @author alumnogreibd
 */
public class Funcionalidades extends AbstractDAO {

    public Funcionalidades(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public aplicacion.Usuario IniciarSesion(String dni, String contrasenha, aplicacion.TipoUsuario t) {
        ResultSet resul;
        Connection con;
        aplicacion.Usuario us = null;
        PreparedStatement stmUsuario = null;
        aplicacion.TipoUsuario tipo = t;

        con = super.getConexion();
        try {

            if (tipo == aplicacion.TipoUsuario.Cliente) {
                stmUsuario = con.prepareStatement("Select dni, contrasenha from Cliente where cliente.dni = ? and cliente.contrasenha = ?");
            } else {
                stmUsuario = con.prepareStatement("Select dni, contrasenha from Monitor where monitor.dni = ? and monitor.contrasenha = ?");
            }

            stmUsuario.setString(1, dni);
            stmUsuario.setString(2, contrasenha);

            resul = stmUsuario.executeQuery();
            if (resul.next()) {
                us = new aplicacion.Usuario(resul.getString("dni"), resul.getString("contrasenha"), tipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return us;
    }

    public Object sesion(aplicacion.Usuario us) {
        ResultSet rs = null;
        PreparedStatement stm = null;
        aplicacion.Cliente cliente = null;
        aplicacion.Monitor monitor = null;
        Connection con = super.getConexion();

        try {
            if (us.getTipo() == aplicacion.TipoUsuario.Cliente) {
                stm = con.prepareStatement("select * from cliente where dni = ?");
            } else {
                stm = con.prepareStatement("select * from monitor where dni = ?");
            }
            stm.setString(1, us.getDni());
            rs = stm.executeQuery();

            if (rs.next()) {
                if (us.getTipo() == aplicacion.TipoUsuario.Cliente) {
                    cliente = new aplicacion.Cliente(rs.getInt("numAbonado"), rs.getString("dni"), rs.getString("contrasenha"), rs.getString("nombre"),
                            rs.getString("ap1"), rs.getString("ap2"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("cuenta"));
                } else {
                    monitor = new aplicacion.Monitor(rs.getString("dni"), rs.getString("contrasenha"), rs.getString("nombre"), rs.getString("ap1"),
                            rs.getString("ap2"), rs.getString("fechaInicio"), rs.getString("telefono"), rs.getString("especialidad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        if (us.getTipo() == aplicacion.TipoUsuario.Cliente) {
            return cliente;
        } else {
            return monitor;
        }

    }

    public ArrayList<aplicacion.Instalacion> obtenerInstalaciones() {
        ArrayList<aplicacion.Instalacion> lista = new ArrayList<>();
        PreparedStatement stmInstalaciones = null;
        Connection con = super.getConexion();
        ResultSet resul;

        try {
            stmInstalaciones = con.prepareStatement("Select * from Instalacion");
            resul = stmInstalaciones.executeQuery();

            while (resul.next()) {
                lista.add(new aplicacion.Instalacion(resul.getString("nombre"), resul.getFloat("metros"), resul.getInt("aforo")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                stmInstalaciones.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    public ArrayList<aplicacion.Organizar> obtenerActividades(String instalacion) {
        ArrayList<aplicacion.Organizar> lista = new ArrayList<>();
        ArrayList<String> horarios = new ArrayList<>();
        ArrayList<String> actividades = new ArrayList<>();
        ArrayList<String> instalaciones = new ArrayList<>();
        PreparedStatement stmActividades = null;
        Connection con = super.getConexion();
        ResultSet resul;

        try {
            if (instalacion.equals("Todas")) {
                stmActividades = con.prepareStatement("Select * from Organizar");
            } else {
                stmActividades = con.prepareStatement("Select * from Organizar where nombreInstalacion = ?");
                stmActividades.setString(1, instalacion);
            }

            resul = stmActividades.executeQuery();

            while (resul.next()) {
                boolean flag = false;
                for (int i = 0; i < horarios.size(); i++) {
                    if (horarios.get(i).equals(resul.getString("horario")) && actividades.get(i).equals(resul.getString("nombre")) && instalaciones.get(i).equals(resul.getString("nombreInstalacion"))) {
                        lista.get(i).anhadirMonitor(resul.getString("monitor"));
                        flag = true;
                    }
                }
                if (!flag) {
                    ArrayList<String> aux = new ArrayList();
                    aux.add(resul.getString("monitor"));
                    lista.add(new aplicacion.Organizar(resul.getString("nombre"), resul.getString("horario"), resul.getString("nombreInstalacion"), aux, resul.getInt("plazasRestantes")));
                    horarios.add(resul.getString("horario"));
                    actividades.add(resul.getString("nombre"));
                    instalaciones.add(resul.getString("nombreInstalacion"));

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (stmActividades != null) {
                    stmActividades.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    public ArrayList<aplicacion.Actividad> obtenerActividad(String instalacion) {//para eliminar actividad, datos de tabla actividad
        ArrayList<aplicacion.Actividad> lista = new ArrayList<>();
        PreparedStatement stmActividades = null;
        Connection con = super.getConexion();
        ResultSet resul;

        try {
            if (instalacion.equals("Todas")) {
                stmActividades = con.prepareStatement("Select * from actividad");
            } else {
                stmActividades = con.prepareStatement("Select * from actividad where nombreinstalacion = ?");
                stmActividades.setString(1, instalacion);
            }

            resul = stmActividades.executeQuery();

            while (resul.next()) {
                lista.add(new aplicacion.Actividad(resul.getString("nombre"), resul.getInt("plazas"), resul.getString("campo"), resul.getString("nombreinstalacion")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                stmActividades.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }
    
    

    public boolean anhadirMaterial(aplicacion.Material material) {
        aplicacion.Material resultado = null;//variable donde devolveremos los datos
        Connection con;//conexion para cuando este implementado
        PreparedStatement stmMaterial = null;
        ResultSet rsMaterial;
        con = super.getConexion();
        boolean ret = true;
        //consulta
        try {
            stmMaterial = con.prepareStatement("insert into Material (nombre,materia,procedencia,dimension)"
                    + "values (?,?,?,?)");
            //cambiar los getters por los que se creen
            stmMaterial.setString(1, material.getNombre());
            stmMaterial.setString(2, material.getMateria());
            stmMaterial.setString(3, material.getProcedencia());
            stmMaterial.setString(4, material.getDimension());
            stmMaterial.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ret = false;
        } finally {
            try {
                stmMaterial.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
                ret = false;
            }
        }
        System.out.println(ret);
        return ret;
    }

    public boolean registrarCliente(aplicacion.Cliente cliente) {
        PreparedStatement stmCliente = null;
        PreparedStatement stmAbonado = null;
        ResultSet rsAbonado;
        Integer numAbonado = 0;
        Connection con = this.getConexion();

        try {
            stmAbonado = con.prepareStatement("select max(numAbonado) from Cliente");
            rsAbonado = stmAbonado.executeQuery();
            if (rsAbonado.next()) {
                numAbonado = rsAbonado.getInt(1) + 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            stmCliente = con.prepareStatement("insert into cliente (numAbonado, dni, contrasenha, nombre, ap1, ap2, direccion, telefono, cuenta) "
                    + "values (?,?,?,?,?,?,?,?,?)");
            stmCliente.setInt(1, numAbonado);
            stmCliente.setString(2, cliente.getDni());
            stmCliente.setString(3, cliente.getContrasenha());
            stmCliente.setString(4, cliente.getNombre());
            stmCliente.setString(5, cliente.getAp1());
            stmCliente.setString(6, cliente.getAp2());
            stmCliente.setString(7, cliente.getDireccion());
            stmCliente.setString(8, cliente.getTelefono());
            stmCliente.setString(9, cliente.getCuenta());
            stmCliente.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmCliente.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }
    
public boolean apuntarseActividad(aplicacion.Cliente cliente, aplicacion.Organizar actividad) {
        Connection con;
        PreparedStatement stm = null;
        PreparedStatement stm2 = null;
        con = super.getConexion();
        ResultSet x = null;
        int y = 0;

        try {
            con.setAutoCommit(false);
            for (int i = 0; i < actividad.getMonitor().size(); i++) {
                System.out.println(actividad.getMonitor().get(i));
                stm = con.prepareStatement("insert into participar (horario, nombreActividad, nombreInstalacion, cliente, monitor) "
                        + "values (?, ?, ?, ?, ?)");
                stm.setTimestamp(1, java.sql.Timestamp.valueOf(actividad.getHorario()));
                stm.setString(2, actividad.getNombre());
                stm.setString(3, actividad.getNombreInstalacion());
                stm.setString(4, cliente.getDni());
                stm.setString(5, actividad.getMonitor().get(i));
                stm.executeUpdate();
                
                stm = con.prepareStatement ("select plazasRestantes from organizar where nombre = ? and nombreInstalacion = ? and horario = ? and monitor = ?");
                stm.setString(1, actividad.getNombre());
                stm.setString (2, actividad.getNombreInstalacion());
                stm.setTimestamp (3, java.sql.Timestamp.valueOf (actividad.getHorario()));
                stm.setString (4, actividad.getMonitor().get(i)); 
                x = stm.executeQuery();
                
                if (x.next())
                    y = x.getInt (1);
                
                
                if (y > 0){
                    stm2 = con.prepareStatement("update organizar set plazasRestantes = plazasRestantes - 1 where nombre = ? and nombreInstalacion = ? and horario = ? and monitor =?");
                    stm2.setString(1, actividad.getNombre());
                    stm2.setString (2, actividad.getNombreInstalacion());
                    stm2.setTimestamp (3, java.sql.Timestamp.valueOf (actividad.getHorario()));
                    stm2.setString (4, actividad.getMonitor().get(i));
                    stm2.executeUpdate();
                }
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }

            return false;
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }   
 
public boolean desapuntarseActividad(aplicacion.Cliente cliente, aplicacion.Organizar actividad) {
        Connection con;
        PreparedStatement stmCount = null;
        PreparedStatement stmUpdate = null;
        PreparedStatement stmDelete = null;

        ResultSet resul;
        int fin = 0;
        boolean flag = false;

        con = super.getConexion();

        try {
            con.setAutoCommit(false);

            // Se comprueba si el cliente está apuntado a la actividad
            stmCount = con.prepareStatement("select plazasrestantes from organizar where nombre = ? and nombreinstalacion = ? and horario = ?");
            stmCount.setString(1, actividad.getNombre());
            stmCount.setString(2, actividad.getNombreInstalacion());
            stmCount.setTimestamp (3, java.sql.Timestamp.valueOf(actividad.getHorario()));
            resul = stmCount.executeQuery();
            if (resul.next()) {
                fin = resul.getInt("plazasRestantes");
            }
            
            // Se actualizan las plazas restantes de la actividad
            stmUpdate = con.prepareStatement("update organizar set plazasRestantes = plazasRestantes + ? where nombre = ? and nombreinstalacion = ?");
            stmUpdate.setInt (1, 1);
            stmUpdate.setString(2, actividad.getNombre());
            stmUpdate.setString(3, actividad.getNombreInstalacion());
            stmUpdate.executeUpdate();

            // Si participa en la actividad, se elimina la tupla correspondiente a la participación
            stmDelete = con.prepareStatement("delete from participar where cliente = ? and nombreactividad = ?");
            stmDelete.setString(1, cliente.getDni());
            stmDelete.setString(2, actividad.getNombre());
            stmDelete.executeUpdate();

            con.commit();

            if (fin >= 0) {
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep.getMessage());
                }
            }
            flag = false;

        } finally {
            try {
                stmCount.close();
                stmUpdate.close();
                stmDelete.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return flag;
    }

    public boolean anhadirActividad(Actividad actividad, aplicacion.Monitor monitor) {
        Connection con;
        PreparedStatement stmActividad = null;
        con = super.getConexion();
        try {
            stmActividad = con.prepareStatement("insert into actividad (nombre, plazas, campo, nombreinstalacion)"
                    + "values (?,?,?,?)");
            stmActividad.setString(1, actividad.getNombre());
            stmActividad.setInt(2, actividad.getPlazas());
            stmActividad.setString(3, monitor.getEspecialidad());
            stmActividad.setString(4, actividad.getNombreInstalacion());
            stmActividad.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmActividad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }

//////////////////////////////////////////////////////////////////
    public ArrayList<aplicacion.Monitor> obtenerMonitores() {
        ArrayList<aplicacion.Monitor> lista = new ArrayList<>();
        PreparedStatement stmMonitores = null;
        Connection con = super.getConexion();
        ResultSet resul;

        try {
            stmMonitores = con.prepareStatement("Select * from Monitor");
            resul = stmMonitores.executeQuery();

            while (resul.next()) {
                lista.add(new aplicacion.Monitor(resul.getString("DNI"), resul.getString("contrasenha"), resul.getString("nombre"), resul.getString("ap1"), resul.getString("ap2"), resul.getString("fechaInicio"), resul.getString("telefono"), resul.getString("especialidad")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    public ArrayList<aplicacion.Cliente> obtenerClientes() {
        ArrayList<aplicacion.Cliente> lista = new ArrayList<>();
        PreparedStatement stmClientes = null;
        Connection con = super.getConexion();
        ResultSet resul;

        try {
            stmClientes = con.prepareStatement("Select * from Cliente");
            resul = stmClientes.executeQuery();
            while (resul.next()) {
                lista.add(new aplicacion.Cliente(resul.getString("DNI"), resul.getString("contrasenha"), resul.getString("nombre"), resul.getString("ap1"), resul.getString("ap2"), resul.getString("direccion"), resul.getString("telefono"), resul.getString("cuenta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    public boolean desorganizarActividad(Actividad actividad) {
        Connection con;
        PreparedStatement stmEliminar = null;
        con = super.getConexion();
        try {
            con.setAutoCommit(false);
            stmEliminar = con.prepareStatement("delete from organizar where nombre = ? AND nombreinstalacion = ?");
            stmEliminar.setString(1, actividad.getNombre());
            stmEliminar.setString(2, actividad.getNombreInstalacion());
            stmEliminar.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep.getMessage());
                }
            }
            return false;
        } finally {
            try {
                stmEliminar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;

    }

    public boolean cambiarSala(aplicacion.Organizar actividad, String newSala) {
        Connection con;
        PreparedStatement stmActividad = null;
        int aforo, plazas, plazasRestantes;
        ResultSet res = null, res2 = null;
        con = super.getConexion();
        boolean flag = true;

        try {
            con.setAutoCommit(false);
            stmActividad = con.prepareStatement("select plazas from actividad where nombre=?");
            stmActividad.setString(1, actividad.getNombre()); //Asi obtemos o maximo de plazas para a actividad
            res = stmActividad.executeQuery();
            res.next();
            plazas = res.getInt(1);

            stmActividad = con.prepareStatement("select plazasRestantes from organizar where nombre=?");
            stmActividad.setString(1, actividad.getNombre()); //Asi obtemos o total de plazas restantes para as organizacions desa actividad
            res = stmActividad.executeQuery();
            //res.next();

            // obtienes el aforo de la sala nueva
            stmActividad = con.prepareStatement("select aforo from instalacion where nombre=?");
            stmActividad.setString(1, newSala);
            res2 = stmActividad.executeQuery();
            if (res2.next());
                aforo = res2.getInt("aforo");
                
            while (res.next()) {
                plazasRestantes = res.getInt(1);
                if ((plazas - plazasRestantes) > aforo) { // si las plazas ocupadas superan el aforo de la nueva sala no se podra cambiar de sala
                    flag = false;
                }
            }

            if (flag) {
                stmActividad = con.prepareStatement("update actividad set nombreInstalacion=? where nombre=?");
                stmActividad.setString(1, newSala);
                stmActividad.setString(2, actividad.getNombre());
                stmActividad.executeUpdate();
            } else {
                throw new SQLException("El aforo de la nueva sala es menor");
            }

            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
            try {
                System.err.print("Transaction is being rolled back");
                con.rollback();
            } catch (SQLException excep) {
                System.out.println(excep.getMessage());
            }
        } finally {
            try {
                if (stmActividad != null) {
                    stmActividad.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }

        }
        return flag;
    }

    public boolean organizarActividad(aplicacion.Organizar actividad) {
        Connection con;
        PreparedStatement stmOrganizar = null;
        con = super.getConexion();
        try {
            stmOrganizar = con.prepareStatement("insert into organizar (horario, nombre, nombreinstalacion, monitor)"
                    + "values (?,?,?,?)");
            stmOrganizar.setTimestamp(1, java.sql.Timestamp.valueOf(actividad.getHorario()));
            stmOrganizar.setString(2, actividad.getNombre());
            stmOrganizar.setString(3, actividad.getNombreInstalacion());
            stmOrganizar.setString(4, actividad.getMonitor().get(0));
            stmOrganizar.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {//para error en Timestamp
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmOrganizar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }

    public boolean aumentarPlazas(aplicacion.Actividad actividad, int aumento) {
        Connection con;
        PreparedStatement stmAumentar = null, stmAforo = null, stmOrganizar = null;
        con = super.getConexion();
        ResultSet res;
        int aforo;
        boolean flag = true;
        try {
            con.setAutoCommit(false);
            //obtengo el aforo de la instalación
            stmAforo = con.prepareStatement("select aforo from instalacion where nombre = ?");
            stmAforo.setString(1, actividad.getNombreInstalacion());
            res = stmAforo.executeQuery();
            res.next();
            aforo = res.getInt(1);
            //compruebo si es suficiente para las plazas nuevas
            if ((actividad.getPlazas() + aumento) <= aforo) {
                //modifico las plazas de la actividad
                stmAumentar = con.prepareStatement("update actividad set plazas = ? where nombre = ?");//No soy capaz de usar IF
                stmAumentar.setInt(1, actividad.getPlazas() + aumento);
                stmAumentar.setString(2, actividad.getNombre());
                stmAumentar.executeUpdate();
                
                stmAumentar = con.prepareStatement ("update organizar set plazasRestantes = plazasRestantes + ? where nombre = ?");
                stmAumentar.setInt (1, aumento);
                stmAumentar.setString (2, actividad.getNombre ());
                stmAumentar.executeUpdate ();
                
            } else {
                stmAumentar = con.prepareStatement("");
                flag = false;
                throw new SQLException("No hay aforo");
            }
            con.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep.getMessage());
                }
            }
            flag = false;
        } finally {
            try {
                stmAumentar.close();
                stmAforo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return flag;
    }

    public boolean reducirPlazas(aplicacion.Actividad actividad, int reduccion) {
        Connection con;
        PreparedStatement stmReducirActividad = null, stmOrganizar = null, stmPlazas = null, stmReducirOrganizar = null;
        con = super.getConexion();
        ResultSet res, resPlazas;
        int plazasRestantes, plazasAntes;
        boolean flag = true;

        DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            con.setAutoCommit(false);

            // obtengo la fecha actual y la comparo con las actividades existentes
            String fechaActual = fecha.format(LocalDateTime.now());

            stmPlazas = con.prepareStatement("select plazas from actividad where nombre = ?");
            stmPlazas.setString(1, actividad.getNombre());
            resPlazas = stmPlazas.executeQuery();
            resPlazas.next();
            plazasAntes = resPlazas.getInt(1);

            stmOrganizar = con.prepareStatement("select plazasRestantes from organizar where horario > ? and nombre = ?");
            stmOrganizar.setTimestamp(1, java.sql.Timestamp.valueOf(fechaActual));
            stmOrganizar.setString(2, actividad.getNombre());
            res = stmOrganizar.executeQuery();

            while (res.next()) {
                plazasRestantes = res.getInt(1);
                if (plazasRestantes < reduccion) {
                    flag = false;
                }
            }

            if (flag) {
                stmReducirActividad = con.prepareStatement("update actividad set plazas = ? where nombre = ?");
                stmReducirActividad.setInt(1, plazasAntes - reduccion);
                stmReducirActividad.setString(2, actividad.getNombre());
                stmReducirActividad.executeUpdate();
                
                stmReducirOrganizar = con.prepareStatement ("update organizar set plazasRestantes = plazasRestantes - ? where nombre = ?");
                stmReducirOrganizar.setInt (1, reduccion);
                stmReducirOrganizar.setString (2, actividad.getNombre());
                stmReducirOrganizar.executeUpdate();
            } else {
                throw new SQLException("Hay gente apuntada que se quedaria fuera");
            }

            con.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep.getMessage());
                }
            }
            flag = false;
        } finally {
            try {
                if (stmReducirActividad != null) {
                    stmReducirActividad.close();
                }
                if (stmOrganizar != null) {
                    stmOrganizar.close();
                }
                if (stmPlazas != null) {
                    stmPlazas.close();
                }
                if (stmOrganizar != null){
                    stmOrganizar.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return flag;
    }

    void incluirMonitor(aplicacion.Organizar actividad, aplicacion.Monitor monitor) {
        Connection con = super.getConexion();
        PreparedStatement stmOrganizar = null, stmParticipar = null, stmParticipantes = null, stmClientes = null, stmEspecialidad = null, stmAux = null;
        ResultSet part, cliente, esp;
        int participantes = 0;
        String dniCliente, especialidad;
        boolean flag = true;

        try {
            con.setAutoCommit(false);

            stmEspecialidad = con.prepareStatement("select campo from actividad where nombre = ?");
            stmEspecialidad.setString(1, actividad.getNombre());
            esp = stmEspecialidad.executeQuery();

            esp.next();
            especialidad = esp.getString("campo");

            if (especialidad.equals(monitor.getEspecialidad())) {
                //Obtener numero de clientes en esa actividad en concreto
                stmParticipantes = con.prepareStatement("select count (distinct(cliente)) as cuenta from participar where horario = ? and nombreActividad = ? and nombreInstalacion = ?");
                stmParticipantes.setTimestamp(1, java.sql.Timestamp.valueOf(actividad.getHorario()));
                stmParticipantes.setString(2, actividad.getNombre());
                stmParticipantes.setString(3, actividad.getNombreInstalacion());

                part = stmParticipantes.executeQuery();

                if (part.next()) {
                    participantes = part.getInt("cuenta");
                }

                stmOrganizar = con.prepareStatement("insert into Organizar (horario, nombre, nombreInstalacion, monitor, plazasRestantes) "
                        + "values (?, ?, ?, ?, ?)");

                stmOrganizar.setTimestamp(1, java.sql.Timestamp.valueOf(actividad.getHorario()));
                stmOrganizar.setString(2, actividad.getNombre());
                stmOrganizar.setString(3, actividad.getNombreInstalacion());
                stmOrganizar.setString(4, monitor.getDni());
                stmOrganizar.setInt(5, actividad.getPlazasRestantes());
                stmOrganizar.executeUpdate();

                for (int i = 0; i < participantes; i++) {
                    stmClientes = con.prepareStatement("select distinct(cliente) from participar where horario = ? and nombreActividad = ? and nombreInstalacion = ?");
                    stmClientes.setTimestamp(1, java.sql.Timestamp.valueOf(actividad.getHorario()));
                    stmClientes.setString(2, actividad.getNombre());
                    stmClientes.setString(3, actividad.getNombreInstalacion());
                    cliente = stmClientes.executeQuery();
                    
                    stmAux = con.prepareStatement ("update organizar set plazasRestantes = plazasRestantes + 1 where horario = ? and nombre = ? and nombreInstalacion = ? and monitor = ?");
                    stmAux.setTimestamp(1, java.sql.Timestamp.valueOf(actividad.getHorario()));
                    stmAux.setString(2, actividad.getNombre());
                    stmAux.setString(3, actividad.getNombreInstalacion());
                    stmAux.setString(4, monitor.getDni());
                    stmAux.executeUpdate();
                    
                    if (cliente.next()) {
                        dniCliente = cliente.getString("cliente");
                        stmParticipar = con.prepareStatement("insert into Participar (horario, nombreActividad, nombreInstalacion, cliente, monitor) "
                                + "values (?, ?, ?, ?, ?)");
                        stmParticipar.setTimestamp(1, java.sql.Timestamp.valueOf(actividad.getHorario()));
                        stmParticipar.setString(2, actividad.getNombre());
                        stmParticipar.setString(3, actividad.getNombreInstalacion());
                        stmParticipar.setString(4, dniCliente);
                        stmParticipar.setString(5, monitor.getDni());

                        stmParticipar.executeUpdate();
                    }
                    
                    stmAux = con.prepareStatement ("update organizar set plazasRestantes = plazasRestantes - 1 where horario = ? and nombre = ? and nombreInstalacion = ? and monitor = ?");
                    stmAux.setTimestamp(1, java.sql.Timestamp.valueOf(actividad.getHorario()));
                    stmAux.setString(2, actividad.getNombre());
                    stmAux.setString(3, actividad.getNombreInstalacion());
                    stmAux.setString(4, monitor.getDni());
                    stmAux.executeUpdate();
                }

            } else {
                flag = false;
                throw new SQLException("No es de tu especialidad");
            }
            con.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (con != null) {
                try {
                    System.out.println("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep.getMessage());
                }
            }
            flag = false;
        } finally {
            try {

                if (stmOrganizar != null)
                    stmOrganizar.close();
                if (stmParticipar != null)
                    stmParticipar.close();
                if (stmParticipantes !=null)
                    stmParticipantes.close();
                if (stmClientes != null)
                    stmClientes.close();
                if (stmEspecialidad != null)
                    stmEspecialidad.close();
                if (stmAux != null)
                    stmAux.close ();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        if (flag) {
            actividad.anhadirMonitor(monitor.getDni());
        }
    }

    boolean cambiarEspecialidad(aplicacion.Monitor monitor, String especialidad) {
        Connection con;
        PreparedStatement stmCambiarEspecialidad = null;
        con = super.getConexion();
        try {
            con.setAutoCommit(false);

            stmCambiarEspecialidad = con.prepareStatement("UPDATE Monitor set especialidad=? where dni=?");
            stmCambiarEspecialidad.setString(1, especialidad);
            stmCambiarEspecialidad.setString(2, monitor.getDni());
            stmCambiarEspecialidad.executeUpdate();

            stmCambiarEspecialidad = con.prepareStatement("DELETE from Organizar where monitor=?");
            stmCambiarEspecialidad.setString(1, monitor.getDni());
            stmCambiarEspecialidad.executeUpdate();

            con.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (con != null) {
                try {
                    System.out.println("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep.getMessage());
                    return false;
                }
            }
        } finally {
            try {
                stmCambiarEspecialidad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
                return false;
            }
        }
        return true;
    }

    public boolean comprobarAvisos(aplicacion.Usuario c){
        Connection con = super.getConexion();
        PreparedStatement stm = null;
        ResultSet result = null;
        
        try{
            stm = con.prepareStatement("select count(*) from Avisos where cliente=?");
            stm.setString(1, c.getDni());
            result = stm.executeQuery();
            result.next();
            if(result.getInt(1)==0){
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            try{
                stm.close();
            }catch(SQLException error){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }
    public ArrayList<aplicacion.Aviso> obtenerAvisos(aplicacion.Usuario us){
        Connection con = super.getConexion();
        PreparedStatement stm = null;
        ResultSet result = null;
        ArrayList<Aviso> avisos = new ArrayList<>();
        
        try{
            stm = con.prepareStatement("select * from Avisos where cliente=?");
            stm.setString(1,us.getDni());
            result = stm.executeQuery();
            while(result.next()){
                avisos.add(new Aviso(result.getString("aviso"), result.getString("cliente")));
            }

            
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }finally{
            try{
                stm.close();
            }catch(SQLException error){
                System.out.println("Imposible cerrar cursores");
            }
        }
        
        return avisos;
    }
}
