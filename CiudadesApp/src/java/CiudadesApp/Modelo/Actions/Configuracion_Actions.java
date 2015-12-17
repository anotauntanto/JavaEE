/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.Configuracion_Parameter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author inftel08
 */
public class Configuracion_Actions {

    public Configuracion_Actions() {


    }
    
    public String process (Configuracion_Parameter configuracion_Parameter ) {
        String resultado = null;
        
        switch (configuracion_Parameter.getMetodo()) {

            case "ciudad":
                
                resultado = "GuardarCiudad.jsp";
                break;
                
            case "evento": 
                
                resultado = "GuardarEvento.jsp";
                break;
                
            case "pregunta":
                
                resultado = "GuardarPregunta.jsp";
                break;
                
            case "listaUsuario":
                
                resultado = "ListadoUsuarios.jsp";
                break;
        }

        return resultado;
    }


}
