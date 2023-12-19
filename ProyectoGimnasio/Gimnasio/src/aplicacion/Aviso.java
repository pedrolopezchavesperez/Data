/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Aviso {
    private String aviso;
    private String DNI;
    
    public Aviso(String aviso, String DNI){
        if(aviso != null && DNI !=null){
            this.aviso=aviso;
            this.DNI= DNI;
        }
    }
    
    public String getAviso(){
        return this.aviso;
    }
    public String getDNI(){
        return this.DNI;
    }
    
}
