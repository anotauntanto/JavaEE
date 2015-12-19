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
import CiudadesApp.Modelo.Parameter.ListarHilos_Parameter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author inftel08
 */
public class ListarHilos_Actions {
    EventoFacade eventoFacade = lookupEventoFacadeBean();
    UserTransaction utx;
    EntityManager em;

    public ListarHilos_Actions(UserTransaction utx, EntityManager em) {
        this.utx = utx;
        this.em = em;
    }
    
    public int getTotalEventos() {
        return eventoFacade.count();
    }
    
    public List<Evento> getListaEventosRange(int id, int tamPag) {
        int[] num = {0, 0};
        num[0] = id;
        num[1] = id + tamPag;
        return eventoFacade.findRange(num);
    }
    
    public int getNumeroAsistentes(Evento evento){
        Query q = em.createQuery("SELECT ue FROM UsuarioEvento ue WHERE ue.idEvento.idEvento = ?1").setParameter(1, evento.getIdEvento());
        
        //(int) q.getSingleResult();
        return q.getResultList().size();
    }

    public Ciudad getCiudad(ListarHilos_Parameter listarPreguntasParameter) {

        Ciudad ciudad = (Ciudad) listarPreguntasParameter.getSession().getAttribute("ciudadActual");
        System.out.println(ciudad.getNombreCiudad());

        return ciudad;

    }

    public void addPregunta(ListarHilos_Parameter listarPreguntasParameter, Pregunta pregunta) {

        listarPreguntasParameter.getSession().setAttribute("preguntaActual", pregunta);

    }

    public void addEvento(ListarHilos_Parameter listarPreguntasParameter, Evento evento) {

        listarPreguntasParameter.getSession().setAttribute("eventoActual", evento);

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
