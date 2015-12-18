/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author inftel06
 */
public class ListaCiudades_Actions {

    CiudadFacade ciudadFacade = lookupCiudadFacadeBean();
    UserTransaction utx;
    EntityManager em;
    private int totalSearch;

   

    public ListaCiudades_Actions(EntityManager em, UserTransaction utx) {

        this.em = em;
        this.utx = utx;

    }

    public int getTotalCiudades() {
        return ciudadFacade.count();
    }

    public List<Ciudad> getListaCiudadesRange(int id, int tamPag) {
        int[] num = {0, 0};
        num[0] = id;
        num[1] = id + tamPag;
        return ciudadFacade.findRange(num);
    }

    public int getTotalSearch() {
        return totalSearch;
    }

    public void setTotalSearch(int totalSearch) {
        this.totalSearch = totalSearch;
    }
    
    public List<Ciudad> getListaCiudadesSearch(String cadena) {

        
        String descripcion="%"+cadena+"%";
        
       Query miQuery=em.createQuery("SELECT c FROM Ciudad c WHERE c.descripcion LIKE ?1").setParameter(1,descripcion);
       
       List<Ciudad> listaCiudadSearch=miQuery.getResultList();
       this.setTotalSearch(listaCiudadSearch.size());
       
       
       return listaCiudadSearch;
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
