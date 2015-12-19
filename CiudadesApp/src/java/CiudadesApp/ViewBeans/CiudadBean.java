/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.ViewBeans;

import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import java.util.List;

/**
 *
 * @author inftel06
 */
public class CiudadBean {
    private List<Pregunta> listaPreguntas;
    private List<Evento> listaEventos;
    private Ciudad ciudad;
    private float temperatura;
    private String fecha;

    public CiudadBean(List<Pregunta> listaPreguntas, List<Evento> listaEventos, Ciudad ciudad, float temperatura, String fecha) {
        this.listaPreguntas = listaPreguntas;
        this.listaEventos = listaEventos;
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.fecha=fecha;
    }

    public CiudadBean(List<Evento> listaEventos, Ciudad ciudad, float temperatura, String fecha) {
        this.listaEventos = listaEventos;
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.fecha = fecha;
    }

    public List<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
