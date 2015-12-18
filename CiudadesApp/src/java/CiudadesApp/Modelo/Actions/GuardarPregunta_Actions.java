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
    
   
    public GuardarPregunta_Actions() {
  
    }
    
    
    public void insertQuestion (GuardarPregunta_Parameter guardarPregunta_parameter, Ciudad ciudad, Usuario usuario) {
        
        Pregunta p = new Pregunta();
        p.setIdCiudad(ciudad);
        p.setTexto(guardarPregunta_parameter.getPregunta());
        p.setIdUsuario(usuario);
        
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


    
}
