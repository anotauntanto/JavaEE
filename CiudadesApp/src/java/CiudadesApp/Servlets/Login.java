/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Parameter.LoginSignin_Parameter;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Actions.LoginSignin_Actions;
import CiudadesApp.Modelo.Util.Redirect;
import java.io.IOException;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    LoginSignin_Actions login_actions;

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
        LoginSignin_Parameter loginParameter = new LoginSignin_Parameter(request, true);
        boolean existeSesion = login_actions.checkSession(loginParameter);
        boolean existeUsuario = login_actions.checkUser(loginParameter);
        
        if(existeSesion){ //si no hay alguna sesión iniciada 

            if (existeUsuario) {
                //Si ambas condiciones se dan, entonces iniciar sesión y redirigir a la página principal 
                login_actions.addUser(loginParameter);
                rd.redirect(request, response, "CiudadServlet?idCiudad=0");

            } else {
                //Si alguna de las condiciones no se da, entonces redirigir de nuevo a la vista del login
                rd.redirect(request, response, "jsp/Login_registro.jsp");

            }

        } else { //si hay alguna sesión ya iniciada
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
        login_actions = new LoginSignin_Actions(em, utx);
    }

}
