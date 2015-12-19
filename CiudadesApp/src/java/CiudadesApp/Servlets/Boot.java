/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.Ciudad_Actions;
import CiudadesApp.Modelo.Parameter.LoginSignin_Parameter;
import CiudadesApp.Modelo.Actions.LoginSignin_Actions;
import CiudadesApp.Modelo.Entidad.Ciudad;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author inftel08
 */
@WebServlet(name = "Boot", urlPatterns = {"/Boot"})
public class Boot extends HttpServlet {

    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    LoginSignin_Actions is;
    Ciudad_Actions ciudadActions;

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
        LoginSignin_Parameter loginParameter = new LoginSignin_Parameter(request, true);
        boolean existe = is.checkUser(loginParameter);
        //Ciudad ciudad = ciudadActions.getCiudad(0);
        //is.addCiudad(loginParameter, ciudad);
        //System.out.println (request.getSession().getAttribute("ciudadActual"));
                
        if (existe) {
            is.addUser(loginParameter);
            rd.redirect(request, response, "CiudadServlet?idCiudad=0");
        } else {
            rd.redirect(request, response, "CiudadServlet?idCiudad=0");
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
        is = new LoginSignin_Actions(em, utx);
        ciudadActions = new Ciudad_Actions(em, utx);
    }
 
}
