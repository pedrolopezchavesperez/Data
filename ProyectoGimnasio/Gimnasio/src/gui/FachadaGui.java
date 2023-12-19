/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alumnogreibd
 */
public class FachadaGui {

    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    VAutentificacion va;
    VMaterial vm;
    VActividad vact;
    VElimActividad veact;
    VCamSala cam;
    VOrgActividad vorg;
    VAumentar vau;
    VReducir vred;
    VAnhadirMonitor vaddmonitor;
    VEspecialidad vespecialidad;
    

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        
        this.vp = new VPrincipal(fa, this);
    }

    public void iniciarVista() {
        vp.setVisible(true);
    }

    public void iniciarSesion() {
        va  = new VAutentificacion(vp, true, fa);
        va.setVisible(true);
    }

    public void iniciarMaterial() {
        vm = new VMaterial(fa);
        vm.setVisible(true);
    }

    public void iniciarActividad() {
        vact = new VActividad(fa);
        vact.setVisible(true);
    }

    public void desorganizarActividad() {
        veact = new VElimActividad(fa);
        veact.setVisible(true);
    }

    public void cambiarSala(aplicacion.Organizar actividad){
        cam = new VCamSala(fa, actividad);
        
    }
    
    public void organizarActividad(){
        vorg = new VOrgActividad(fa);
        vorg.setVisible(true);
    }
    
    public void aumentarPlazas(){
        vau = new VAumentar(fa);
        vau.setVisible(true);
    }
    
    public void reducirPlazas(){
        vred = new VReducir(fa);
        vred.setVisible(true);
    }
    
    public void anhadirMonitor (){
        vaddmonitor = new VAnhadirMonitor (fa, vp);
        vaddmonitor.setVisible(true);
    }
    
    public void cambiarEspecialidad (){
        vespecialidad = new VEspecialidad(fa);
        vespecialidad.setVisible(true);
    }
}
