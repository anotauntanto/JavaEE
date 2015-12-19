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
public class ListadoCiudades_Parameter {
    private int indice;

    public ListadoCiudades_Parameter(HttpServletRequest request) {
        indice = Integer.parseInt(request.getParameter("indice"));
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
}
