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
    private String texto_Inicio;
    private Evento evento;
    private List<ComentarioEvento> listaComentarios;
    private Ciudad ciudad;
    /*private float temperatura;
    private String fecha;*/

    public ListaEventosBean(String texto_Inicio, List<ComentarioEvento> listaComentarios, Ciudad ciudad, Evento evento) {
        this.texto_Inicio = texto_Inicio;
        this.listaComentarios = listaComentarios;
        this.ciudad = ciudad;
        this.evento = evento;
    }
//ListaComentariosBean
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<ComentarioEvento> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<ComentarioEvento> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public String getTexto_Inicio() {
        return texto_Inicio;
    }

    public void setTexto_Inicio(String texto_Inicio) {
        this.texto_Inicio = texto_Inicio;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

}
