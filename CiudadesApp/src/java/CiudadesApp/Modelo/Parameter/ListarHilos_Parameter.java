/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Parameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author inftel08
 */
public class ListarHilos_Parameter {

    int idHilo;
    int idCiudad;
    HttpSession session;

    public ListarHilos_Parameter(HttpServletRequest request) {

        this.idHilo = Integer.parseInt(request.getParameter("idHilo"));
        this.idCiudad = Integer.parseInt(request.getParameter("idCiudad"));
        this.session = request.getSession();
    }

    public int getIdHilo() {
        return idHilo;
    }

    public void setIdHilo(int idHilo) {
        this.idHilo = idHilo;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public HttpSession getSession() {
        return session;
    }

    
}
