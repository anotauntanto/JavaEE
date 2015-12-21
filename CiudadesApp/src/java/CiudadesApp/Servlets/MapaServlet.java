/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maps.java.Geocoding;

/**
 *
 * @author inftel08
 */
@WebServlet(name = "MapaServlet", urlPatterns = {"/MapaServlet"})
public class MapaServlet extends HttpServlet {

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
        
        //Recuperacion de los parametros de la sesion
        ManageSession_Parameter manageSession_Parameter = new ManageSession_Parameter(request);
        
        
        //Recuperacion de los objetos de la sesion
        Ciudad ciudad = (Ciudad) manageSession_Parameter.getSession().getAttribute("ciudadActual");
        Evento evento = (Evento) manageSession_Parameter.getSession().getAttribute("eventoActual");
        
        //Obtener las coordenadas
        Geocoding ObjGeocod = new Geocoding();
        Point2D.Double resultadoCD = ObjGeocod.getCoordinates(ciudad.getNombreCiudad() + ", " + evento.getDireccion());
        
        //Atributos para la vista
        request.setAttribute("coordenadas", resultadoCD);
        
        //Redireccion
        rd.redirect(request, response, "WEB-INF/Paneles/PanelMapa.jsp");

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

}
