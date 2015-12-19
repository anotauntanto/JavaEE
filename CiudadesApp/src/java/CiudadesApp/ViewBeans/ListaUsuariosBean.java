/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.ViewBeans;

import CiudadesApp.Modelo.Entidad.Usuario;
import java.util.List;

/**
 *
 * @author inftel06
 */
public class ListaUsuariosBean {
    private List<Usuario> listaUsuario;
    private int num_preguntas;
    private int num_eventos;
    private int num_comentarios;

    public ListaUsuariosBean(List<Usuario> listaUsuario, int num_preguntas, int num_eventos, int num_comentarios) {
        this.listaUsuario = listaUsuario;
        this.num_preguntas = num_preguntas;
        this.num_eventos = num_eventos;
        this.num_comentarios = num_comentarios;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }


    public int getNum_preguntas() {
        return num_preguntas;
    }

    public void setNum_preguntas(int num_preguntas) {
        this.num_preguntas = num_preguntas;
    }

    public int getNum_eventos() {
        return num_eventos;
    }

    public void setNum_eventos(int num_eventos) {
        this.num_eventos = num_eventos;
    }

    public int getNum_comentarios() {
        return num_comentarios;
    }

    public void setNum_comentarios(int num_comentarios) {
        this.num_comentarios = num_comentarios;
    }
    
    
}
