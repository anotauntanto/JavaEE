/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Clases;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author inftel08
 */
public class LoginSigin_Parameter {
    
    String username;
    String pass;

    public LoginSigin_Parameter(HttpServletRequest request) {
        username = request.getParameter("usuario");
        pass = request.getParameter("pass");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
