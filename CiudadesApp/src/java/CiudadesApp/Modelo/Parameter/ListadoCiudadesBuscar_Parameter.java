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
public class ListadoCiudadesBuscar_Parameter {
    private String find;

    public ListadoCiudadesBuscar_Parameter(HttpServletRequest request) {
        find= request.getParameter("find");
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }
    
    
}
