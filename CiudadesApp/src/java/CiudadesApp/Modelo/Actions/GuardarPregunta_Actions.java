/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.EJBFacade.PreguntaFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Pregunta;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.GuardarPregunta_Parameter;
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
public class GuardarPregunta_Actions {
    PreguntaFacade preguntaFacade = lookupPreguntaFacadeBean();
    
    UserTransaction utx;
    EntityManager em;
    Pregunta p;
    

    public GuardarPregunta_Actions(UserTransaction utx, EntityManager em) {
        this.utx = utx;
        this.em = em;
        p = new Pregunta();
    }
    
    
    public void insertQuestion (GuardarPregunta_Parameter guardarPregunta_parameter) {
        
        Ciudad c =  new Ciudad();
        c.setNombreCiudad("Malaga");
        c.setDescripcion("esto es una descripcion");
        p.setIdCiudad(c);
        
        
        p.setTexto(guardarPregunta_parameter.getPregunta());
        
        Usuario u = new Usuario ();
        u.setIdUsuario(4);
        p.setIdUsuario(u);
        
        preguntaFacade.create(p);
        
            
    }

    private PreguntaFacade lookupPreguntaFacadeBean() {
        try {
            Context c = new InitialContext();
            return (PreguntaFacade) c.lookup("java:global/ForodeCiudades/PreguntaFacade!CiudadesApp.Modelo.EJBFacade.PreguntaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
            Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            em.joinTransaction();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    
}
