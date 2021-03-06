/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.ManageSessions_Actions;
import CiudadesApp.Modelo.EJBFacade.UsuarioFacade;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
import CiudadesApp.ViewBeans.ListaUsuariosBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@WebServlet(name = "ListaUsuarios", urlPatterns = {"/ListaUsuarios"})
public class ListaUsuarios extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;
    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

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

        request.setCharacterEncoding("UTF-8");

        Redirect rd = new Redirect();

        ManageSession_Parameter manageSession_Parameter = new ManageSession_Parameter(request);
        boolean session = manageSessions_actions.checkSession(manageSession_Parameter);

        if (!session) { //si no hay sesión
            rd.redirect(request, response, "/Boot");

        } else { //si hay alguna sesión 

            if (manageSessions_actions.getUser(manageSession_Parameter).getIdUsuario() == 1) { // es administrador
                List<Usuario> listaUsuario = usuarioFacade.findAll();
                //ListaUsuariosBean listaUsuarioBean = new ListaUsuariosBean(listaUsuario,0,0,0);

                //atributos para visualización
                request.setAttribute("listaUsuariosBean", listaUsuario);

                //redirección
                rd.redirect(request, response, "WEB-INF/Paginas/ListaUsuarios.jsp");
            } else {
                
                rd.redirect(request, response, "/Boot");

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
        manageSessions_actions = new ManageSessions_Actions();
    }
}
