/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.ListaCiudades_Actions;
import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Parameter.ListadoCiudades_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
import CiudadesApp.ViewBeans.ListaCiudadesBean;
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
@WebServlet(name = "VerListaCiudades", urlPatterns = {"/VerListaCiudades"})
public class ListadoCiudades extends HttpServlet {

    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    @EJB
    private CiudadFacade ciudadFacade;
    ListaCiudades_Actions ciudades_Actions;

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

        //Recuperacion de parametros del request
        ListadoCiudades_Parameter listadoCiudades_Parameter = new ListadoCiudades_Parameter(request);

        //Recuperacion de otros datos
        List<Ciudad> listaCiudades = ciudades_Actions.getListaCiudadesRange(listadoCiudades_Parameter.getIndice(), 2);
        int total = ciudades_Actions.getTotalCiudades();

        //Generacion de los beans
        ListaCiudadesBean ciudadesBean = new ListaCiudadesBean(total, listaCiudades, listadoCiudades_Parameter.getIndice());

        //Atributos de presentacion
        request.setAttribute("ciudadesBean", ciudadesBean);

        //Redireccion
        rd.redirect(request, response, "WEB-INF/Paginas/ListaCiudades.jsp");

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
        ciudades_Actions = new ListaCiudades_Actions(em, utx);
    }
}
