/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.ViewBeans;

import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.ComentarioPregunta;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import java.util.List;

/**
 *
 * @author inftel06
 */
public class ListaPreguntasBean {
    private String texto_Inicio;
    private Pregunta evento;
    private List<ComentarioPregunta> listaComentarios;
    private Ciudad ciudad;
    /*private float temperatura;
    private String fecha;*/

    public ListaPreguntasBean(String texto_Inicio, Pregunta evento, List<ComentarioPregunta> listaComentarios, Ciudad ciudad) {
        this.texto_Inicio = texto_Inicio;
        this.evento = evento;
        this.listaComentarios = listaComentarios;
        this.ciudad = ciudad;
        
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getTexto_Inicio() {
        return texto_Inicio;
    }

    public void setTexto_Inicio(String texto_Inicio) {
        this.texto_Inicio = texto_Inicio;
    }

    public Pregunta getEvento() {
        return evento;
    }

    public void setEvento(Pregunta evento) {
        this.evento = evento;
    }

    public List<ComentarioPregunta> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<ComentarioPregunta> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    
}
