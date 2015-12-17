/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.Clases.GuardarCiudades_Parameter;
import CiudadesApp.Modelo.Entidad.Ciudad;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author inftel08
 */
public class GuardarCiudad_Actions {

    UserTransaction utx;
    EntityManager em;
    
    Ciudad c;

    public GuardarCiudad_Actions(UserTransaction utx, EntityManager em) {
        this.utx = utx;
        this.em = em;
        c = new Ciudad();
    }

    
    public void insertCity(GuardarCiudades_Parameter guardarCiudades_Parameter) {
        
       
       c.setDescripcion(guardarCiudades_Parameter.getDescripcion());
       c.setNombreCiudad(guardarCiudades_Parameter.getNombreCiudad());
       c.setFoto(guardarCiudades_Parameter.getFoto());
        
       persist(c);
        
    }
    
    
    public void persist(Object object) {
        /* Add this to the deployment descriptor of this module (e.g. web.xml, ejb-jar.xml):
         * <persistence-context-ref>
         * <persistence-context-ref-name>persistence/LogicalName</persistence-context-ref-name>
         * <persistence-unit-name>ForodeCiudadesPU</persistence-unit-name>
         * </persistence-context-ref>
         * <resource-ref>
         * <res-ref-name>UserTransaction</res-ref-name>
         * <res-type>javax.transaction.UserTransaction</res-type>
         * <res-auth>Container</res-auth>
         * </resource-ref> */
        try {

            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

}
