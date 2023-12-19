package baseDatos;

import aplicacion.Actividad;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import aplicacion.Aviso;


public class FachadaBaseDatos {

    private java.sql.Connection conexion;
    private aplicacion.FachadaAplicacion fa;
    private Funcionalidades f;

    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {
        FileInputStream arqConfiguracion;
        Properties configuracion = new Properties();
        this.fa = fa;

        try {
            arqConfiguracion = new FileInputStream("gimnasio.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            f = new Funcionalidades(conexion, fa);

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (IOException | java.sql.SQLException i) {
            System.out.println(i.getMessage());
        }
    }

    public aplicacion.Usuario validarUsuario(String dni, String contrasenha, aplicacion.TipoUsuario tipo) {
        return f.IniciarSesion(dni, contrasenha, tipo);
    }

    public aplicacion.Cliente sesionCl(aplicacion.Usuario us) {
        return (aplicacion.Cliente) f.sesion(us);
    }

    public aplicacion.Monitor sesionMo(aplicacion.Usuario us) {
        return (aplicacion.Monitor) f.sesion(us);
    }

    public ArrayList<aplicacion.Instalacion> obtenerInstalaciones() {
        return f.obtenerInstalaciones();
    }

    public ArrayList<aplicacion.Organizar> obtenerActividades(String instalacion) {
        return f.obtenerActividades(instalacion);
    }
    
    public ArrayList<aplicacion.Actividad> obtenerActividad(String instalacion) {
        return f.obtenerActividad(instalacion);
    }
    
    public ArrayList<aplicacion.Cliente> obtenerClientes() {
        return f.obtenerClientes();
    }

    public boolean anhadirMaterial(aplicacion.Material material) {
        return f.anhadirMaterial(material);
    }

    public boolean signUp(aplicacion.Cliente cliente) {
        return f.registrarCliente(cliente);
    }

    public boolean apuntarseActividad(aplicacion.Cliente cliente, aplicacion.Organizar actividad) {
        return f.apuntarseActividad(cliente, actividad);
    }

    public boolean desapuntarseActividad(aplicacion.Cliente cliente, aplicacion.Organizar actividad) {
        return f.desapuntarseActividad(cliente, actividad);
    }

    public boolean anhadirActividad(aplicacion.Actividad actividad, aplicacion.Monitor monitor) {
        return f.anhadirActividad(actividad, monitor);
    }

    public boolean desorganizarActividad(aplicacion.Actividad actividad) {
        return f.desorganizarActividad(actividad);
    }

    public boolean cambiarSala(aplicacion.Organizar actividad, String newSala){
        return f.cambiarSala(actividad, newSala);
    }
   
    public boolean organizarActividad(aplicacion.Organizar actividad){
        return f.organizarActividad(actividad);
    }
    
    public boolean aumentarPlazas(aplicacion.Actividad act, int plazas){
        return f.aumentarPlazas(act, plazas);
    }
    
    public boolean reducirPlazas(aplicacion.Actividad act, int reduccion){
        return f.reducirPlazas(act, reduccion);
    }
    
    public void incluirMonitor (aplicacion.Organizar actividad, aplicacion.Monitor monitor){
        f.incluirMonitor(actividad, monitor);
    }
    
    public void cambiarEspecialidad(aplicacion.Monitor sesionMonitor, String especialidad) {
        f.cambiarEspecialidad(sesionMonitor, especialidad);
    }
    public boolean comprobarAvisos(aplicacion.Usuario c){
        return f.comprobarAvisos(c);
    }
    public ArrayList<Aviso> obtenerAvisos(aplicacion.Usuario us){
        return f.obtenerAvisos(us);
    } 
}
