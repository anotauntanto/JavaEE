/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Actions;

import CiudadesApp.Modelo.EJBFacade.UsuarioEventoFacade;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Entidad.UsuarioEvento;
import CiudadesApp.Modelo.Parameter.Hilo_Parameter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Asistir_Actions {

    UsuarioEventoFacade usuarioEventoFacade = lookupUsuarioEventoFacadeBean();
    UserTransaction utx;
    EntityManager em;

    public Asistir_Actions(EntityManager em, UserTransaction utx) {
         this.em = em;
        this.utx = utx;
    }

    public void insertAsistir(Hilo_Parameter hiloParameter, Usuario usuario) {
        if (!exitsUsuarioEvento(hiloParameter,usuario)){
            UsuarioEvento ue = new UsuarioEvento();
            Evento e = new Evento();
            Usuario u = new Usuario();
            e.setIdEvento(hiloParameter.getIdHilo());
            ue.setIdEvento(e);
            u.setIdUsuario(usuario.getIdUsuario());
            ue.setIdUsuario(u);

            usuarioEventoFacade.create(ue);
        }

    }

    public boolean exitsUsuarioEvento(Hilo_Parameter hiloParameter, Usuario usuario) {
        
        Query q = em.createQuery("SELECT ue FROM UsuarioEvento ue WHERE ue.idEvento.idEvento = ?1 AND ue.idUsuario.idUsuario = ?2",UsuarioEvento.class);
        System.out.println("Prueba2: "+hiloParameter.getIdHilo()+" USER: "+usuario.getIdUsuario());
        q.setParameter(1, hiloParameter.getIdHilo());
        q.setParameter(2, usuario.getIdUsuario());

        //(int) q.getSingleResult();
        if (q.getResultList().isEmpty()) {
            
            return false;
        }
        
        return true;
    }

    private UsuarioEventoFacade lookupUsuarioEventoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioEventoFacade) c.lookup("java:global/ForodeCiudades/UsuarioEventoFacade!CiudadesApp.Modelo.EJBFacade.UsuarioEventoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
}
