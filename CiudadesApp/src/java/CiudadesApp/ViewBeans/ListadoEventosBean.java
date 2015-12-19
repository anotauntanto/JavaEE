/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.ViewBeans;

import CiudadesApp.Modelo.Entidad.Evento;
import java.util.List;

/**
 *
 * @author inftel06
 */
public class ListadoEventosBean {
    private int total;
    private List<Evento> listaEvento;
    private int indice;

    public ListadoEventosBean(int total, List<Evento> listaEvento, int indice) {
        this.total = total;
        this.listaEvento = listaEvento;
        this.indice = indice;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Evento> getListaEvento() {
        return listaEvento;
    }

    public void setListaEvento(List<Evento> listaEvento) {
        this.listaEvento = listaEvento;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

   
    
    
}
