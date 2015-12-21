/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.EJBFacade.UsuarioFacade;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.Configuracion_Parameter;
import CiudadesApp.ViewBeans.ListaUsuariosBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author inftel08
 */
public class Configuracion_Actions {
    UsuarioFacade usuarioFacade = lookupUsuarioFacadeBean();
    List<Usuario> listaUsuario;
    

    public Configuracion_Actions() {

    }

    public String process(Configuracion_Parameter configuracion_Parameter) {
        String resultado = null;

        switch (configuracion_Parameter.getMetodo()) {

            case "ciudad":

                resultado = "GuardarCiudad.jsp";
                break;

            case "listaUsuario":

                listaUsuario = usuarioFacade.findAll();
                //System.out.println("NUmero: " + listaUsuario.size());

                //ListaUsuariosBean listaUsuarioBean = new ListaUsuariosBean(listaUsuario, 0, 0, 0);
                resultado = "ListadoUsuarios.jsp";
                break;
        }

        return resultado;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    
    private UsuarioFacade lookupUsuarioFacadeBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioFacade) c.lookup("java:global/ForodeCiudades/UsuarioFacade!CiudadesApp.Modelo.EJBFacade.UsuarioFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
