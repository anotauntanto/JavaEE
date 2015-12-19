/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.ListaCiudades_Actions;
import CiudadesApp.Modelo.Actions.ListaEvento_Actions;
import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.ViewBeans.ListaCiudadesBean;
import CiudadesApp.ViewBeans.ListaEventosBean;
import CiudadesApp.ViewBeans.ListadoEventosBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author inftel06
 */

@WebServlet(name = "ListadoEventos", urlPatterns = {"/ListadoEventos"})
public class ListadoEventos extends HttpServlet {
    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    @EJB
    private CiudadFacade eventoFacade;
    ListaEvento_Actions eventos_Actions;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //List<Ciudad> listaCiudades =ciudadFacade.findAll();
            
            //ListaCiudades_Actions ciudades_Actions=new ListaCiudades_Actions(em,utx);
       
            Integer id = Integer.parseInt(request.getParameter("indice"));
            
            List<Evento> listaEventos= eventos_Actions.getListaEventosRange(id, 4);

            int total=eventos_Actions.getTotalEventos();
           
            ListadoEventosBean eventosBean= new ListadoEventosBean(total,listaEventos,id);
            //System.out.println("Total "+total);
            
            request.setAttribute("eventosBean",eventosBean);

            RequestDispatcher rd;
            rd=request.getRequestDispatcher("jsp/ListaEventos.jsp");
            rd.forward(request,response);   
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

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

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        eventos_Actions = new ListaEvento_Actions(em, utx);
    }
}
