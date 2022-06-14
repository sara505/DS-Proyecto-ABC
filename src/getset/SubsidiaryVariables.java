/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getset;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Sara Eraso
 */
public class SubsidiaryVariables {
    
    private String nombre_sede;
    private int id_sede;
    private  String fechaFundacion_sede;
    private String direccion_sede;
    
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    
    public String getNombre_sede() {
        return nombre_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public String getFechaFundacion_sede() {
        return fechaFundacion_sede;
    }

    public void setFechaFundacion_sede(String fechaFundacion_sede) {
        
        //fechaFundacion_sede = Date.parse(LafechaFundacion_sede);
        this.fechaFundacion_sede = fechaFundacion_sede;
    }

    public String getDireccion_sede() {
        return direccion_sede;
    }

    public void setDireccion_sede(String direccion_sede) {
        this.direccion_sede = direccion_sede;
    }

    @Override
    public String toString() {
        return "Sede{" + "nombre_sede=" + nombre_sede + ", id_sede=" + id_sede + ", fechaFundacion_sede=" + fechaFundacion_sede + ", direccion_sede=" + direccion_sede + '}';
    }
    

    
}
