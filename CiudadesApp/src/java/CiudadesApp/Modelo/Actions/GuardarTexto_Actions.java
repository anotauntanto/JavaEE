/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.EJBFacade.ComentarioEventoFacade;
import CiudadesApp.Modelo.EJBFacade.ComentarioPreguntaFacade;
import CiudadesApp.Modelo.EJBFacade.PreguntaFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.ComentarioEvento;
import CiudadesApp.Modelo.Entidad.ComentarioPregunta;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.GuardarTexto_Parameter;
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
public class GuardarTexto_Actions {
    ComentarioEventoFacade comentarioEventoFacade = lookupComentarioEventoFacadeBean();
    ComentarioPreguntaFacade comentarioPreguntaFacade = lookupComentarioPreguntaFacadeBean();
    PreguntaFacade preguntaFacade = lookupPreguntaFacadeBean();
    
   
    public GuardarTexto_Actions() {
  
    }
    
    
    public void insertQuestion (GuardarTexto_Parameter guardarPregunta_parameter, Ciudad ciudad, Usuario usuario) {
        
        Pregunta p = new Pregunta();
        p.setIdCiudad(ciudad);
        p.setTexto(guardarPregunta_parameter.getTexto());
        p.setIdUsuario(usuario);
        
        preguntaFacade.create(p);
        
            
    }
    
    public void insertCommentQuestion(GuardarTexto_Parameter guardarComentario_parameter, Usuario usuario, Pregunta pregunta) {
        
        ComentarioPregunta c = new ComentarioPregunta();
        c.setIdPregunta(pregunta);
        c.setIdUsuario(usuario);
        c.setTexto(guardarComentario_parameter.getTexto());
        comentarioPreguntaFacade.create(c);
   
            
    }
    
    public void insertCommentEvent(GuardarTexto_Parameter guardarComentario_parameter, Usuario usuario, Evento evento) {
        
        ComentarioEvento c = new ComentarioEvento();
        c.setIdEvento(evento);
        c.setIdUsuario(usuario);
        c.setTexto(guardarComentario_parameter.getTexto());
        comentarioEventoFacade.create(c);
   
            
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

    private ComentarioPreguntaFacade lookupComentarioPreguntaFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ComentarioPreguntaFacade) c.lookup("java:global/ForodeCiudades/ComentarioPreguntaFacade!CiudadesApp.Modelo.EJBFacade.ComentarioPreguntaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ComentarioEventoFacade lookupComentarioEventoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ComentarioEventoFacade) c.lookup("java:global/ForodeCiudades/ComentarioEventoFacade!CiudadesApp.Modelo.EJBFacade.ComentarioEventoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


    
}
