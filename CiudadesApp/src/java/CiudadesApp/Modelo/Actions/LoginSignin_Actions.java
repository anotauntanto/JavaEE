/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Parameter.LoginSignin_Parameter;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Util.MD5Signature;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.GenerationType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;

/**
 *
 * @author inftel08
 */
public class LoginSignin_Actions {

    UserTransaction utx;
    EntityManager em;
    Usuario u;
    String atributo = "usuario";

    public LoginSignin_Actions(EntityManager em, UserTransaction utx) {

        this.em = em;
        this.utx = utx;

    }

    public boolean checkUser(LoginSignin_Parameter parameter) {

        boolean existe = false;

        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = ?1", Usuario.class).setParameter(1, parameter.getUsername());
            u = (Usuario) q.getSingleResult();

            String huella = MD5Signature.generateMD5Signature(parameter.getPass());
            if (u.getContrasena().equals(huella)) {
                existe = true;
            }

        } catch (NoResultException e) {
            existe = false;
        }

        return existe;

    }
    
    public boolean checkUserName(LoginSignin_Parameter parameter) {

        boolean existe = false;

        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = ?1", Usuario.class).setParameter(1, parameter.getUsername());
            u = (Usuario) q.getSingleResult();
            existe=true;

        } catch (NoResultException e) {
            existe = false;
        }

        return existe;

    }

    public boolean checkSession(LoginSignin_Parameter parameter) {
        boolean res = false;
        
        if (parameter.getSession().getAttribute(atributo) == null) {
            res = true;

        }
        return res;
    }
    
    public void addUser (LoginSignin_Parameter parameter) {
        parameter.getSession().setAttribute("usuario", u);
        
    }
    
    public void addCiudad (LoginSignin_Parameter parameter, Ciudad ciudad) {
        parameter.getSession().setAttribute("ciudadActual", ciudad);
        
    }
    
    public void insertUser (LoginSignin_Parameter parameter) {
        
        u = new Usuario ();
        u.setNombreUsuario(parameter.getUsername());
        u.setContrasena(parameter.getPass());
        
        persist(u);
        
    }
    
    
    public void persist(Object object) {
        /* Add this to the deployment descriptor of this module (e.g. web.xml, ejb-jar.xml):
         * <persistence-context-ref>
         * <persistence-context-ref-name>persistence/LogicalName</persistence-context-ref-name>
         * <persistence-unit-name>ForodeCiudadesPU</persistence-unit-name>
         * </persistence-context-ref>
         * <resource-ref>
         * <res-ref-name>UserTransaction</res-ref-name>
         * <res-type>javax.transaction.UserTransaction</res-type>
         * <res-auth>Container</res-auth>
         * </resource-ref> */
        try {

            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

}
