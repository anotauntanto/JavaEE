/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
@WebServlet(name = "ServletInicioSesion", urlPatterns = {"/ServletInicioSesion"})
public class LoginServlet extends HttpServlet {

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
            throws ServletException,  IOException{
        response.setContentType("text/html;charset=UTF-8");

        //TODO: comprobar si existe el usuario y si su contraseña es correcta.
        String nombre = request.getParameter("usuario").toString();
        String password = request.getParameter("pass1").toString();
        
        boolean existe=Persistencia.passwordCorrecta(nombre, password);
        
        if(request.getSession().getAttribute("usuario")==null){ //si no hay alguna sesión iniciada 
            if(existe){
                 //Si ambas condiciones se dan, entonces iniciar sesión y redirigir al catálogo, con un mensaje de
                 //bienvenida personalizado   
                 request.getSession().setAttribute("usuario", nombre);
                 request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
    
            } else {
                //Si alguna de las condiciones no se da, entonces redirigir de nuevo al login
                request.setAttribute("Error", "Usuario incorrecto");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else{
            request.setAttribute("error", "Sesión ya iniciada");
            request.getRequestDispatcher("/Redireccion.jsp").forward(request, response);
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

}
