/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;

/**
 *
 * @author inftel08
 */
public class ManageSessions_Actions {

    Usuario u;

    public ManageSessions_Actions() {
    }

    public Usuario getUser(ManageSession_Parameter manageSession_Parameter) {

        return u;

    }

    public boolean checkSession(ManageSession_Parameter manageSession_Parameter) {

        boolean session = false;

        u = (Usuario) manageSession_Parameter.getSession().getAttribute("usuario");
        if (u != null) {
            session = true;
        }

        return session;

    }

    public Object getObject(String atributte, ManageSession_Parameter manageSession_Parameter) {
        
        Object o = manageSession_Parameter.getSession().getAttribute(atributte);
        return o;
         
     }
    
}
