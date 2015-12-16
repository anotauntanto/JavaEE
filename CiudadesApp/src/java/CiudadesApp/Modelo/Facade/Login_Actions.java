/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Facade;

import CiudadesApp.Modelo.Clases.Login_Parameter;
import CiudadesApp.Modelo.Entidad.Usuario;
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
public class Login_Actions {

    UserTransaction utx;
    EntityManager em;
    Usuario u;

    public Login_Actions(EntityManager em, UserTransaction utx) {

        this.em = em;
        this.utx = utx;

    }

    public boolean checkUser(Login_Parameter loginParameter) {

        boolean existe = false;

        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = ?1", Usuario.class).setParameter(1, loginParameter.getUsername());
            u = (Usuario) q.getSingleResult();

            if (u.getContrasena().equals(loginParameter.getPass())) {
                existe = true;
            }
            
        } catch (NoResultException e) {
            existe = false;
        }

        return existe;

    }
    
    
    
    public Usuario getUser() {
        return u;
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
