/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.Parameter.GuardarCiudades_Parameter;
import CiudadesApp.Modelo.Entidad.Ciudad;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author inftel08
 */
public class GuardarCiudad_Actions {
    CiudadFacade ciudadFacade = lookupCiudadFacadeBean();
    
    public GuardarCiudad_Actions() {
   
    }

    
    public void insertCity(GuardarCiudades_Parameter guardarCiudades_Parameter) {
        
       Ciudad c = new Ciudad();
       c.setDescripcion(guardarCiudades_Parameter.getDescripcion());
       c.setNombreCiudad(guardarCiudades_Parameter.getNombreCiudad());
       c.setFoto(guardarCiudades_Parameter.getFoto());

       ciudadFacade.create(c);
        
    }
    
   
    private CiudadFacade lookupCiudadFacadeBean() {
        try {
            Context c = new InitialContext();
            return (CiudadFacade) c.lookup("java:global/ForodeCiudades/CiudadFacade!CiudadesApp.Modelo.EJBFacade.CiudadFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
