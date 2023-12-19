/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author braismiguez
 */
public class Instalacion {
    private String nombre;
    private float metros;
    private int aforo;
    
    
    public Instalacion (String nombre, float metros, int aforo){
        this.nombre  = nombre;
        this.metros  = metros;
        this.aforo = aforo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getMetros() {
        return metros;
    }

    public int getAforo() {
        return aforo;
    }
    
    
}
