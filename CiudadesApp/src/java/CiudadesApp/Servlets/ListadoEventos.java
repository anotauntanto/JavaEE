/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.ListaCiudades_Actions;
import CiudadesApp.Modelo.Actions.ListarHilos_Actions;
import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Parameter.ListadoCiudades_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
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
    ListarHilos_Actions eventos_Actions;

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
        request.setCharacterEncoding("UTF-8");
        Redirect rd = new Redirect();
        
        //Recuperar parametros del request
        ListadoCiudades_Parameter listadoEventos_Parameter = new ListadoCiudades_Parameter(request);
        
        //Recuperacion de otros parametros
        List<Evento> listaEventos = eventos_Actions.getListaEventosRange(listadoEventos_Parameter.getIndice(), 4);
        int total = eventos_Actions.getTotalEventos();
        
        //generacion de los beans
        ListadoEventosBean eventosBean = new ListadoEventosBean(total, listaEventos, listadoEventos_Parameter.getIndice());

        //Atributos de las vistas
        request.setAttribute("eventosBean", eventosBean);
 
        //Redireccion
        rd.redirect(request, response, "WEB-INF/Paginas/ListaEventos.jsp");

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

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        eventos_Actions = new ListarHilos_Actions(utx, em);
    }
}
