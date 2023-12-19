/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author braismiguez
 */
public class Encargar {
    private String fechaPedido;
    private float precio;
    private int cantidad;
    private String nombreMaterial;
    private String monitor;
    
    public Encargar(String fechaPedido, float precio, int cantidad, String nombreMaterial, String monitor){
        this.fechaPedido = fechaPedido;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombreMaterial = nombreMaterial;
        this.monitor = monitor;
    }
}
