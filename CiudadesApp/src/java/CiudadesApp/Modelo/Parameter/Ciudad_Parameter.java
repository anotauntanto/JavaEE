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
public class Ciudad_Parameter {
    
    int idCiudad;
    HttpSession session;

    public Ciudad_Parameter(HttpServletRequest request) {
        this.idCiudad = Integer.parseInt(request.getParameter("idCiudad"));
        this.session = request.getSession();
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

    public void setSession(HttpSession session) {
        this.session = session;
    }
    
    
}
