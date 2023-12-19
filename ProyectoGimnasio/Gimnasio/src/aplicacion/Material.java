/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author braismiguez
 */
public class Material {
    private String nombre;
    private String materia;
    private String procedencia;
    private String dimension;
    
    public Material (String nombre, String materia, String procedencia, String dimension){
        this.nombre = nombre;
        this.materia = materia;
        this.procedencia = procedencia;
        this.dimension = dimension;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMateria() {
        return materia;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public String getDimension() {
        return dimension;
    }
    
    
}
