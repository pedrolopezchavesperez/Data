/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.util.ArrayList;

/**
 *
 * @author alumnogreibd
 */
public class FachadaAplicacion {

    private baseDatos.FachadaBaseDatos fbd;
    private gui.FachadaGui fgui;
    private Usuario logged;
    private Cliente sesionCliente;
    private Monitor sesionMonitor;

    public FachadaAplicacion() {
        fbd = new baseDatos.FachadaBaseDatos(this);
        fgui = new gui.FachadaGui(this);
        logged = null;
    }

    public static void main(String args[]) {
        
        FachadaAplicacion fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario() {
        fgui.iniciarVista();
    }

    public boolean iniciarSesion(String dni, String contrasenha, TipoUsuario tipo) {
        logged = fbd.validarUsuario(dni, contrasenha, tipo);
        if (logged == null) {
            return false;
        }
        logging();
        return true;
    }

    public ArrayList<Instalacion> obtenerInstalaciones() {
        return fbd.obtenerInstalaciones();
    }

    public ArrayList<Organizar> obtenerActividades(String instalacion) {
        return fbd.obtenerActividades(instalacion);
    }
    
    public ArrayList<Actividad> obtenerActividad(String instalacion) {
        return fbd.obtenerActividad(instalacion);
    }
    
    public ArrayList<Cliente> obtenerClientes() {
        return fbd.obtenerClientes();
    }

    public boolean anhadirMaterial(Material material) {
        return fbd.anhadirMaterial(material);
    }

    public Usuario getLogged() {
        return logged;
    }

    public Cliente getSesionCliente() {
        return sesionCliente;
    }
    
    public Monitor getSesionMonitor() {
        return sesionMonitor;
    }

    public void logging() {
        if (logged.getTipo().equals(TipoUsuario.Cliente)) {
            sesionCliente = fbd.sesionCl(logged);
        } else {
            sesionMonitor = fbd.sesionMo(logged);
        }

    }

    public boolean registrar(Cliente cliente) {
        if (fbd.signUp(cliente)) {
            sesionCliente = cliente;
            return true;
        }
        return false;
    }

    public boolean apuntarseActividad(Cliente cliente, Organizar actividad) {
        return fbd.apuntarseActividad(cliente, actividad);
    }

    public boolean desapuntarseActividad(Cliente cliente, Organizar actividad) {
        return fbd.desapuntarseActividad(cliente, actividad);
    }

    public boolean anhadirActividad(Actividad actividad) {
        return fbd.anhadirActividad(actividad, sesionMonitor);
    }

    public boolean desorganizarActividad(Actividad actividad) {
        return fbd.desorganizarActividad(actividad);
    }

     public boolean cambiarSala(aplicacion.Organizar actividad, String newSala){
        return fbd.cambiarSala(actividad, newSala);
    }
     
    public boolean organizarActividad(aplicacion.Organizar actividad){
        return fbd.organizarActividad(actividad);
    }
    
    public boolean aumentarPlazas(aplicacion.Actividad act, int plazas){
        return fbd.aumentarPlazas(act, plazas);
    }
    
    public boolean reducirPlazas(aplicacion.Actividad act, int reduccion){
        return fbd.reducirPlazas(act, reduccion);
    }
    
    public void incluirMonitor (Organizar actividad){
        fbd.incluirMonitor (actividad, sesionMonitor);
    }
    
    public void cambiarEspecialidad (String especialidad){
        fbd.cambiarEspecialidad (sesionMonitor, especialidad);
    }
    public boolean comprobarAvisos(aplicacion.Usuario c){
        return fbd.comprobarAvisos(c);
    }
    public ArrayList<Aviso> obtenerAvisos(aplicacion.Usuario us){
        return fbd.obtenerAvisos(us);
    }
    
}
