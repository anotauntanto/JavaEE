/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Parameter.MostrarImagen_Parameter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author inftel08
 */
public class MostrarImagen_Actions {

    EntityManager em;
    UserTransaction utx;

    public MostrarImagen_Actions(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    public byte[] getImagen(MostrarImagen_Parameter mostrarImagen_Parameter) {

        Ciudad c = em.find(Ciudad.class, mostrarImagen_Parameter.getId());
        byte[] bFile = (byte[]) c.getFoto();
        return bFile;
    }

    public void persist(Object object) {
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
