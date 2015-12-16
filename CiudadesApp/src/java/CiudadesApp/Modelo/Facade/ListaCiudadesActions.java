/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Facade;

import CiudadesApp.Modelo.Entidad.Ciudad;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author inftel06
 */
public class ListaCiudadesActions {
    
     public List<Ciudad> listaClientesPorNombre(){
        
       Query miQuery=null;//em.createQuery("SELECT c FROM Ciudad c");
       
        return miQuery.getResultList();
    }
}
