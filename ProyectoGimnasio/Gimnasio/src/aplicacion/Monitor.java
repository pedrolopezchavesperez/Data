/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacion;
import java.util.*;

/**
 *
 * @author braismiguez
 */
public class Monitor {

    private String  DNI;
    private String contrasenha;
    private String nombre;
    private String ap1;
    private String ap2;
    private String fechaInicio;
    private String telefono;
    private String especialidad;
    
    public Monitor(String DNI, String contrasenha, String nombre, String ap1, String ap2, String fechaInicio, String telefono, String especialidad){
    
        this.DNI = DNI;
        this.contrasenha = contrasenha;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.fechaInicio = fechaInicio;
        this.telefono = telefono;
        this.especialidad = especialidad;
    };

    public String getDni() {
        return DNI;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAp1() {
        return ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    
    
    
}
