/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.GuardarTexto_Actions;
import CiudadesApp.Modelo.Actions.ManageSessions_Actions;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.GuardarTexto_Parameter;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author inftel08
 */
@WebServlet(name = "GuardarComentarioEvento", urlPatterns = {"/GuardarComentarioEvento"})
public class GuardarComentarioEvento extends HttpServlet {

    ManageSessions_Actions manageSessions_actions;
    GuardarTexto_Actions guardarComentarioEvento_actions;

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
        GuardarTexto_Parameter guardarComentario_parameter = new GuardarTexto_Parameter(request);

        if (!session) { //si no hay sesión

            rd.redirect(request, response, "Boot");

        } else { //si hay alguna sesión 

            Ciudad ciudad = (Ciudad) manageSessions_actions.getObject("ciudadActual", manageSession_Parameter);
            Evento evento = (Evento) manageSessions_actions.getObject("eventoActual", manageSession_Parameter);
            Usuario usuario = manageSessions_actions.getUser(manageSession_Parameter);

            guardarComentarioEvento_actions.insertCommentEvent(guardarComentario_parameter, usuario, evento);
            rd.redirect(request, response, "ListaEventosServlet?idCiudad=" + ciudad.getIdCiudad() + "&idHilo=" + evento.getIdEvento());

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
        guardarComentarioEvento_actions = new GuardarTexto_Actions();
    }

}
