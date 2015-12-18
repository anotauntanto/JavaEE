/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.Configuracion_Actions;
import CiudadesApp.Modelo.Actions.ManageSessions_Actions;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Parameter.Configuracion_Parameter;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;
import CiudadesApp.ViewBeans.CiudadBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author inftel08
 */
@WebServlet(name = "MostrarCampoPreguntas", urlPatterns = {"/MostrarCampoPreguntas"})
public class MostrarCampoPreguntas extends HttpServlet {

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

        ManageSession_Parameter manageSession_Parameter = new ManageSession_Parameter(request);
        boolean session = manageSessions_actions.checkSession(manageSession_Parameter);

        if (!session) { //si no hay sesión

            request.getRequestDispatcher("CiudadServlet?idCiudad=0").forward(request, response);

        } else { //si hay alguna sesión 

            Ciudad ciudad = (Ciudad) manageSessions_actions.getObject("ciudadActual", manageSession_Parameter);
            
            request.getRequestDispatcher("jsp/Principal").forward(request, response);

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
    }

}
