/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.ListaCiudades_Actions;
import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.ViewBeans.ListaCiudadesBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    private CiudadFacade ciudadFacade;

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
            
            ListaCiudades_Actions ciudades_Actions=new ListaCiudades_Actions();
       
            Integer id = Integer.parseInt(request.getParameter("indice"));
            ciudades_Actions.getTotalCiudades();
            
            List<Ciudad> listaCiudades =ciudades_Actions.getListaCiudadesRange(id, 2);
            ListaCiudadesBean ciudadesBean= new ListaCiudadesBean(ciudades_Actions.getTotalCiudades(),listaCiudades,id);
            
            request.setAttribute("ciudadesBean",ciudadesBean);

            RequestDispatcher rd;
            rd=request.getRequestDispatcher("jsp/ListaCiudades.jsp");
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

}
