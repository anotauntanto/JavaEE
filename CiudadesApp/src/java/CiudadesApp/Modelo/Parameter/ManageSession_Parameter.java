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
public class ManageSession_Parameter {
    
    HttpSession session;

    public ManageSession_Parameter(HttpServletRequest request) {
        
        session = request.getSession(true);
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
    
    
    
}
