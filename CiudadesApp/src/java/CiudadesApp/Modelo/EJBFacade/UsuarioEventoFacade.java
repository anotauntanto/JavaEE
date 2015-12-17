/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.EJBFacade;

import CiudadesApp.Modelo.Entidad.UsuarioEvento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inftel07
 */
@Stateless
public class UsuarioEventoFacade extends AbstractFacade<UsuarioEvento> {
    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioEventoFacade() {
        super(UsuarioEvento.class);
    }
    
}
