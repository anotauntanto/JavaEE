/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

/**
 *
 * @author inftel06
 */
public class VerCiudad_Actions {

    CiudadFacade ciudadFacade = lookupCiudadFacadeBean();
    UserTransaction utx;
    EntityManager em;
    Ciudad ciudad;

    public VerCiudad_Actions(EntityManager em, UserTransaction utx) {

        this.em = em;
        this.utx = utx;

    }

    
    public Ciudad getCiudad(int idCiudad){
        
        if (idCiudad==0){
            int newIdCiudad=0;
            
            Query q = em.createQuery("select max(c.idCiudad) from Ciudad c",Ciudad.class);
            
            newIdCiudad=(int) q.getSingleResult();
            
            return  ciudadFacade.find(newIdCiudad);
                     

        if (idCiudad == 0) {
            int newIdCiudad = 0;

            Query q = em.createQuery("select max(c.idCiudad) from Ciudad c", Ciudad.class);

            newIdCiudad = (int) q.getSingleResult();

            return ciudadFacade.find(newIdCiudad);

        } else {
            return ciudadFacade.find(idCiudad);
        }

    }

    public List<Pregunta> getListaPreguntas(Ciudad ciudad) {
        return (List<Pregunta>) ciudad.getPreguntaCollection();
    }

    public List<Evento> getListaProximosEventos(Ciudad ciudad, int numeroEventos) {
        //List<Evento> listaEvento = (List<Evento>) ciudad.getEventoCollection();
        Query q = em.createQuery("SELECT e FROM Evento e WHERE e.idCiudad.idCiudad=?1 ORDER BY e.fecha", Evento.class).setParameter(1, ciudad.getIdCiudad());
        List<Evento> listaEvento = q.getResultList();
        Date midate = new Date();

       //midate.toString(); //dow mon dd hh:mm:ss zzz yyyy
        List<Evento> tempEvento = new ArrayList<Evento>();

        Iterator<Evento> EventoIterator = tempEvento.iterator();

        /*for (Evento evento: listaEvento){
         if (evento.getFecha().after(midate)){
         tempEvento.add(evento);
         }
 
         }*/
        if (numeroEventos != 0) {
            int i = 0;
            while (EventoIterator.hasNext() && i < numeroEventos) {
                if (EventoIterator.next().getFecha().after(midate)) {
                    tempEvento.add(EventoIterator.next());
                    i++;
                }
            }
        }
        else{
            return listaEvento;
        }

        return tempEvento;
    }

    public String getFecha() {
        Date midate = new Date();
        String[] verfecha = midate.toString().split(" ");
        String mifecha = verfecha[2] + "/" + verfecha[1] + "/" + verfecha[5];
        return mifecha;
    }

    public float getTemperatura(Ciudad ciudad) {
        OpenWeatherMap owm = new OpenWeatherMap("");
        owm.setUnits(OpenWeatherMap.Units.METRIC);
        owm.setApiKey("d05638724c60088ab81382441f4e8586");
        owm.setLang(OpenWeatherMap.Language.SPANISH);
        CurrentWeather cwd = null;
        try {
            cwd = owm.currentWeatherByCityName(ciudad.getNombreCiudad());
        } catch (IOException ex) {
            Logger.getLogger(VerCiudad_Actions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(VerCiudad_Actions.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cwd.getMainInstance().getTemperature();
    }

    private CiudadFacade lookupCiudadFacadeBean() {
        try {
            Context c = new InitialContext();
            return (CiudadFacade) c.lookup("java:global/ForodeCiudades/CiudadFacade!CiudadesApp.Modelo.EJBFacade.CiudadFacade");
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
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

}
