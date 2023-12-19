/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.util.*;

/**
 *
 * @author braismiguez
 */
public class Organizar {
    private String nombre;
    private String horario;
    private String nombreInstalacion;
    private ArrayList <String> monitores;
    private int plazasRestantes;
    
    public Organizar (String nombre, String horario, String nombreInstalacion, ArrayList <String> monitores, int plazasRestantes){
        this.nombre = nombre;
        this.horario = horario;
        this.nombreInstalacion = nombreInstalacion;
        this.monitores = monitores;
        this.plazasRestantes = plazasRestantes;
    }

    public String getNombre() {
        return nombre;
    }


    public String getHorario() {
        return horario;
    }

    public String getNombreInstalacion() {
        return nombreInstalacion;
    }

    public ArrayList <String> getMonitor (){
        return monitores; 
    }
    
    public int getPlazasRestantes(){
        return plazasRestantes;
    }
    
    public void anhadirMonitor (String monitor){
        if (!monitores.contains (monitor))
            monitores.add (monitor);
    }
    
}
