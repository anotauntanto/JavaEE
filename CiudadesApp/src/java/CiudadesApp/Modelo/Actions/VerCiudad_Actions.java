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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

/**
 *
 * @author inftel06
 */
public class VerCiudad_Actions {
    CiudadFacade ciudadFacade = lookupCiudadFacadeBean();
    
    public Ciudad getCiudad(int idCiudad){
        return ciudadFacade.find(idCiudad);
    }
    
    public List<Pregunta> getListaPreguntas(Ciudad ciudad){
        return (List<Pregunta>) ciudad.getPreguntaCollection();
    }
    
    public List<Evento> getListaProximosEventos(Ciudad ciudad){
       List<Evento> listaEvento = (List<Evento>) ciudad.getEventoCollection();
       Date midate=new Date();
       
       //midate.toString(); //dow mon dd hh:mm:ss zzz yyyy
       
       List<Evento> tempEvento = new ArrayList<Evento>();
       
       

       for (Evento evento: listaEvento){
           if (evento.getFecha().after(midate)){
               tempEvento.add(evento);
           }
 
       }
       return tempEvento;
    }
    
    public String getFecha(){
       Date midate=new Date();
       String[] verfecha=midate.toString().split(" ");
       String mifecha=verfecha[2]+"/"+verfecha[1]+"/"+verfecha[5];
       return mifecha;
    }
    
    public float getTemperatura(Ciudad ciudad){
        OpenWeatherMap owm = new OpenWeatherMap("");
        owm.setUnits(OpenWeatherMap.Units.METRIC);
        owm.setApiKey("d05638724c60088ab81382441f4e8586");
        owm.setLang(OpenWeatherMap.Language.SPANISH);
        CurrentWeather cwd=null;
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
    
}
