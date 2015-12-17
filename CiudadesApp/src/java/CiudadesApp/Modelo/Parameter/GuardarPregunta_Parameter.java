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
public class GuardarPregunta_Parameter {

    String pregunta;
    String nombreCiudad;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getCiudad() {
        return nombreCiudad;
    }

    public void setCiudad(String ciudad) {
        this.nombreCiudad = ciudad;
    }

    public GuardarPregunta_Parameter(HttpServletRequest request) {
        nombreCiudad = (String) request.getParameter("ciudad");
        pregunta = (String) request.getParameter("pregunta");

    }

}
