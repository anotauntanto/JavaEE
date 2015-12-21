/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.Asistir_Actions;
import CiudadesApp.Modelo.Actions.GuardarTexto_Actions;
import CiudadesApp.Modelo.Actions.ManageSessions_Actions;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.Hilo_Parameter;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author inftel06
 */
@WebServlet(name = "AsistirServlet", urlPatterns = {"/AsistirServlet"})
public class AsistirServlet extends HttpServlet {
    ManageSessions_Actions manageSessions_actions;
    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    Asistir_Actions asistir_actions;

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
        ManageSession_Parameter manageSession_Parameter = new ManageSession_Parameter(request);
        boolean session = manageSessions_actions.checkSession(manageSession_Parameter);
        Hilo_Parameter hiloParameter = new Hilo_Parameter(request);

        if (!session) { //si no hay sesión

            rd.redirect(request, response, "/Boot");

        } else { //si hay alguna sesión 
 
            Usuario usuario = manageSessions_actions.getUser(manageSession_Parameter);        
            asistir_actions.insertAsistir(hiloParameter, usuario);
            rd.redirect(request, response, "ListaEventosServlet?idCiudad="+hiloParameter.getIdCiudad()+"&idHilo="+hiloParameter.getIdHilo());
 
        }
        
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
        manageSessions_actions = new ManageSessions_Actions();
        asistir_actions = new Asistir_Actions(em,utx);
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
