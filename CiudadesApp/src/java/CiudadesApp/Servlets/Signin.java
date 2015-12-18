/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Parameter.Login_Parameter;
import CiudadesApp.Modelo.Parameter.Signin_Parameter;
import CiudadesApp.Modelo.Actions.Login_Actions;
import CiudadesApp.Modelo.Actions.Signin_Actions;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author inftel08
 */
public class Signin extends HttpServlet {
    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    Signin_Actions is;

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
        response.setContentType("text/html;charset=UTF-8");

        Signin_Parameter signinParameter = new Signin_Parameter(request);

        boolean existe = is.checkUser(signinParameter);
        
        if (request.getSession().getAttribute("usuario") == null) { //si no hay alguna sesión iniciada       
            
            if (existe) { //si el usuario existe redirigir añ registro mostrando mensaje de nombre de usuario en uso
                request.setAttribute("error", "Nombre de usuario en uso");
                request.getRequestDispatcher("jsp/Login_registro.jsp").forward(request, response);
                
            } else {
                is.insertUser(signinParameter);
                
                request.getSession().setAttribute("usuario", is.getUser());
                request.getRequestDispatcher("CiudadServlet?idCiudad=0").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Sesión ya iniciada");
            request.getRequestDispatcher("CiudadServlet?idCiudad=0").forward(request, response);
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
        is = new Signin_Actions (em, utx);
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
