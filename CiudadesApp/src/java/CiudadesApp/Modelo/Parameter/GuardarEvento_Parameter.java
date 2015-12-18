/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author inftel08
 */
public class GuardarEvento_Parameter {

    String descripcion;
    Date fecha;
    String nombre;
    String direccion;

    public GuardarEvento_Parameter(HttpServletRequest request) {

        try {
            String fecha = request.getParameter("fecha");
            String[] trozosFecha = fecha.split("/");
            String miFecha = trozosFecha[1] + "/" + trozosFecha[0] + "/" + trozosFecha[2];
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fecha = formato.parse(miFecha);    
            this.descripcion = request.getParameter("descripcion");
            this.nombre = request.getParameter("nombre");
            this.direccion = request.getParameter("direccion");
            
        } catch (ParseException ex) {
            Logger.getLogger(GuardarEvento_Parameter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
