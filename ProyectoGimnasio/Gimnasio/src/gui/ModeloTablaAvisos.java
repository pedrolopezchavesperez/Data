/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import aplicacion.Aviso;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaAvisos extends AbstractTableModel{
    private ArrayList<Aviso> avisos;
    
    public ModeloTablaAvisos(){
        this.avisos=new ArrayList<>();
    }

    public int getColumnCount (){
        return 1;
    }

    public int getRowCount(){
        if (avisos == null)
            return 0;
        return avisos.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Aviso"; break;

            
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
  
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= avisos.get(row).getAviso(); break;
        }
        return resultado;
    }

    public void setFilas(ArrayList<Aviso> actividades){
        this.avisos=actividades;
        fireTableDataChanged();
    }
}
