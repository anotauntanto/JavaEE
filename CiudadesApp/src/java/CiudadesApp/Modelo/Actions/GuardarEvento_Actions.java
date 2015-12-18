/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.EJBFacade.EventoFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.GuardarEvento_Parameter;
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
public class GuardarEvento_Actions {
    
    EventoFacade eventoFacade = lookupEventoFacadeBean();
    

    public GuardarEvento_Actions() {
    
    }

    public void insertEvent(GuardarEvento_Parameter guardarEvento_parameter, Ciudad ciudad, Usuario usuario) {

        Evento e = new Evento();
        e.setDescripcion(guardarEvento_parameter.getDescripcion());
        e.setDireccion(guardarEvento_parameter.getDireccion());
        e.setFecha(guardarEvento_parameter.getFecha());
        e.setNombreEvento(guardarEvento_parameter.getNombre());
        
        e.setIdCiudad(ciudad);
        e.setIdUsuario(usuario);
        
        eventoFacade.create(e);

    }

    private EventoFacade lookupEventoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (EventoFacade) c.lookup("java:global/ForodeCiudades/EventoFacade!CiudadesApp.Modelo.EJBFacade.EventoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


}
