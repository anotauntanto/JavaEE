/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Parameter;

import CiudadesApp.Modelo.Util.MD5Signature;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author inftel08
 */
public class LoginSignin_Parameter {

    String username;
    String pass;
    HttpSession session;

    public LoginSignin_Parameter(HttpServletRequest request, boolean login) {

        username = request.getParameter("usuario");
        if (login) {
            pass = request.getParameter("pass");
        } else {

            String temp;
            temp = request.getParameter("pass1");
            pass = MD5Signature.generateMD5Signature(temp);
        }

        this.session = request.getSession();

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

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

}
