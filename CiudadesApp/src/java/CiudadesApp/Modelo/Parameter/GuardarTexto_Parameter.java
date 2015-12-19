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
public class GuardarTexto_Parameter {

    String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String pregunta) {
        this.texto = pregunta;
    }

    public GuardarTexto_Parameter(HttpServletRequest request) {
        texto = (String) request.getParameter("texto");

    }

}
