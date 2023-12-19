/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacion;

/**
 *
 * @author braismiguez
 */
public class Cliente {

    private int numAbonado;
    private String  DNI;
    private String contrasenha;
    private String nombre;
    private String ap1;
    private String ap2;
    private String fechaIngreso;
    private String direccion;
    private String telefono;
    private String cuenta;
    
    public Cliente(int numAbonado, String DNI, String contrasenha, String nombre, String ap1, String ap2, String direccion, String telefono, String cuenta){
        this.numAbonado = numAbonado;
        this.DNI = DNI;
        this.contrasenha = contrasenha;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }; 
        
    public Cliente(String DNI, String contrasenha, String nombre, String ap1, String ap2, String direccion, String telefono, String cuenta){
        this.DNI = DNI;
        this.contrasenha = contrasenha;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuenta = cuenta;
    };  

    public int getNumAbonado() {
        return numAbonado;
    }

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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCuenta() {
        return cuenta;
    }


    
}
