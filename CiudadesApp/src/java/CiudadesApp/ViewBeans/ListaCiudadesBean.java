/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.ViewBeans;

import CiudadesApp.Modelo.Entidad.Ciudad;
import java.util.List;

/**
 *
 * @author inftel06
 */
public class ListaCiudadesBean {
    private int total;
    private List<Ciudad> listaCiudades;
    private int indice;

    public ListaCiudadesBean(int total, List<Ciudad> listaCiudades, int indice) {
        this.total = total;
        this.listaCiudades = listaCiudades;
        this.indice = indice;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
}
