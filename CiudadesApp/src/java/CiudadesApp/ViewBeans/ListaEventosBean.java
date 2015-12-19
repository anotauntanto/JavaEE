/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.ViewBeans;

import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.ComentarioEvento;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import java.util.List;

/**
 *
 * @author inftel06
 */
public class ListaEventosBean {
    String texto_Inicio;
    private List<ComentarioEvento> listaPreguntas;
    private List<Evento> listaEventos;
    private Ciudad ciudad;
    private float temperatura;
    private String fecha;

    public ListaEventosBean(String texto_Inicio, List<ComentarioEvento> listaPreguntas, List<Evento> listaEventos, Ciudad ciudad, float temperatura, String fecha) {
        this.texto_Inicio = texto_Inicio;
        this.listaPreguntas = listaPreguntas;
        this.listaEventos = listaEventos;
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.fecha = fecha;
    }

    public String getTexto_Inicio() {
        return texto_Inicio;
    }

    public void setTexto_Inicio(String texto_Inicio) {
        this.texto_Inicio = texto_Inicio;
    }

    public List<ComentarioEvento> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<ComentarioEvento> listaPreguntas) {
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
