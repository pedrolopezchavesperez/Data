/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import aplicacion.Organizar;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaActividades extends AbstractTableModel{
    private ArrayList<Organizar> actividades;
    
    public ModeloTablaActividades(){
        this.actividades=new ArrayList<Organizar>();
    }

    public int getColumnCount (){
        return 4;
    }

    public int getRowCount(){
        if (actividades == null)
            return 0;
        return actividades.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Actividad"; break;
            case 1: nombre= "Instalacion"; break;
            case 2: nombre="Horario"; break;
            case 3: nombre="Monitor/es"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.String.class; break;
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
            case 0: resultado= actividades.get(row).getNombre(); break;
            case 1: resultado= actividades.get(row).getNombreInstalacion(); break;
            case 2: resultado= actividades.get(row).getHorario();break;
            case 3: resultado= actividades.get(row).getMonitor(); break;
        }
        return resultado;
    }

    public void setFilas(ArrayList<Organizar> actividades){
        this.actividades=actividades;
        fireTableDataChanged();
    }

    public Organizar obtenerActividad(int i){
        return this.actividades.get(i);
    }
}
