/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.GuardarPregunta_Actions;
import CiudadesApp.Modelo.Actions.ManageSessions_Actions;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.GuardarCiudades_Parameter;
import CiudadesApp.Modelo.Parameter.GuardarPregunta_Parameter;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;
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
 * @author inftel08
 */
@WebServlet(name = "GuardarPregunta", urlPatterns = {"/GuardarPregunta"})
public class GuardarPregunta extends HttpServlet {
    
    ManageSessions_Actions manageSessions_actions;
    GuardarPregunta_Actions guardarPregunta_actions;
    
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
        
        ManageSession_Parameter manageSession_Parameter = new ManageSession_Parameter(request);
        boolean session = manageSessions_actions.checkSession(manageSession_Parameter);
        GuardarPregunta_Parameter guardarPregunta_parameter = new GuardarPregunta_Parameter(request);

        if (!session) { //si no hay sesión

            request.getRequestDispatcher("Boot").forward(request, response);

        } else { //si hay alguna sesión 

            Ciudad ciudad = (Ciudad) manageSessions_actions.getObject("ciudadActual", manageSession_Parameter);
            Usuario usuario = manageSessions_actions.getUser(manageSession_Parameter);
            guardarPregunta_actions.insertQuestion(guardarPregunta_parameter, ciudad, usuario);
            request.getRequestDispatcher("Boot").forward(request, response);
 
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
        guardarPregunta_actions = new GuardarPregunta_Actions();
    }

}
