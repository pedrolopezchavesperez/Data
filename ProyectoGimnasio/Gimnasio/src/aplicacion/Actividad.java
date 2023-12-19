/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author braismiguez
 */
public class Actividad {
    private String nombre;
    private int plazas;
    private String campo;
    private String nombreInstalacion;
    
    public Actividad (String nombre, int plazas, String campo, String nombreInstalacion){
        this.nombre = nombre;
        this.plazas = plazas;
        this.campo = campo;
        this.nombreInstalacion = nombreInstalacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPlazas() {
        return plazas;
    }

    public String getCampo() {
        return campo;
    }

    public String getNombreInstalacion() {
        return nombreInstalacion;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    
    
    
}
