/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.Configuracion_Actions;
import CiudadesApp.Modelo.Actions.LoginSignin_Actions;
import CiudadesApp.Modelo.Actions.ManageSessions_Actions;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.Configuracion_Parameter;
import CiudadesApp.Modelo.Parameter.LoginSignin_Parameter;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author inftel06
 */
@WebServlet(name = "Configuracion", urlPatterns = {"/Configuracion"})

public class Configuracion extends HttpServlet {

    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    LoginSignin_Actions login_actions;
    ManageSessions_Actions manageSessions_actions;

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

        Redirect rd = new Redirect();
        ManageSession_Parameter manageSession_Parameter =  new ManageSession_Parameter (request);
        boolean session = manageSessions_actions.checkSession(manageSession_Parameter);

        if (!session) { //si no hay sesión
            rd.redirect(request, response, "Boot");

        } else { //si hay alguna sesión 

            if (manageSessions_actions.getUser(manageSession_Parameter).getIdUsuario() == 1) { // es administrador

                Configuracion_Parameter configuracion_Parameter = new Configuracion_Parameter(request);
                Configuracion_Actions configuracion_Actions = new Configuracion_Actions();
                String res = configuracion_Actions.process(configuracion_Parameter);

                request.setAttribute("jsp", res);
                rd.redirect(request, response, "jsp/VistaConfiguracion.jsp");


            } else {
                
                rd.redirect(request, response, "Boot");

            }

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
        login_actions = new LoginSignin_Actions(em, utx);
        manageSessions_actions = new ManageSessions_Actions();
    }

}
