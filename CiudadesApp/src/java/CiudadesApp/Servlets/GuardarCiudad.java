/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Parameter.GuardarCiudades_Parameter;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Actions.GuardarCiudad_Actions;
import CiudadesApp.Modelo.Actions.ManageSessions_Actions;
import CiudadesApp.Modelo.Entidad.Usuario;
import CiudadesApp.Modelo.Parameter.ManageSession_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author inftel08
 */
@WebServlet(name = "GuardarCiudad", urlPatterns = {"/GuardarCiudad"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,//$10$MB$$
        maxFileSize = 1024 * 1024 * 50,//$50$MB$
        maxRequestSize = 1024 * 1024 * 100)

public class GuardarCiudad extends HttpServlet {

    GuardarCiudad_Actions guardarCiudades_Actions;
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
        ManageSession_Parameter manageSession_Parameter = new ManageSession_Parameter(request);
        boolean session = manageSessions_actions.checkSession(manageSession_Parameter);

        if (!session) { //si no hay sesión
            rd.redirect(request, response, "Boot");

        } else { //si hay alguna sesión

            if (manageSessions_actions.getUser(manageSession_Parameter).getIdUsuario() == 1) { // es administrador
                GuardarCiudades_Parameter guardarCiudades_Parameter = new GuardarCiudades_Parameter(request);
                guardarCiudades_Actions.insertCity(guardarCiudades_Parameter);
                rd.redirect(request, response, "/Configuracion?metodo=ciudad");

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

        /*Part filePart = request.getPart("fileName"); // Retrieves <input type="file" name="file">
         String fileName = filePart.getSubmittedFileName();
         //System.out.println(fileName);
         InputStream fileContent = filePart.getInputStream();*/
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
        guardarCiudades_Actions = new GuardarCiudad_Actions();
        manageSessions_actions = new ManageSessions_Actions();

    }

}
