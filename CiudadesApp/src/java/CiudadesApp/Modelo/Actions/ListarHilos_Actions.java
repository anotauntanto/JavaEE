/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Parameter.ListarHilos_Parameter;

/**
 *
 * @author inftel08
 */
public class ListarHilos_Actions {
    
    public Ciudad getCiudad (ListarHilos_Parameter listarPreguntasParameter) {
        
        Ciudad ciudad = (Ciudad) listarPreguntasParameter.getSession().getAttribute("ciudadActual");
        System.out.println(ciudad.getNombreCiudad());
        
       return ciudad;
        
    }
    
}
