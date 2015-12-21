/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Parameter;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author inftel08
 */
public class MostrarImagen_Parameter {
    private int id;

    public MostrarImagen_Parameter(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("Id"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
