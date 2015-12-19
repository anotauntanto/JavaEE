/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.Ciudad_Actions;
import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.EJBFacade.PreguntaFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import CiudadesApp.Modelo.Parameter.Ciudad_Parameter;
import CiudadesApp.Modelo.Util.Redirect;
import CiudadesApp.ViewBeans.CiudadBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

/**
 *
 * @author inftel06
 */
@WebServlet(name = "CiudadServlet", urlPatterns = {"/CiudadServlet"})
public class CiudadServlet extends HttpServlet {

    @EJB
    private PreguntaFacade preguntaFacade;
    @EJB
    private CiudadFacade ciudadFacade;
    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
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

        //Se muestra haya sesión o no
        request.setCharacterEncoding("UTF-8");
        Redirect rd = new Redirect();
        Ciudad_Parameter ciudadParameter = new Ciudad_Parameter(request);
        Ciudad ciudad = ciudadActions.getCiudad(ciudadParameter);
        System.out.println("Nombre 2 " + ciudad.getNombreCiudad());

        List<Pregunta> listaPregunta = ciudadActions.getListaPreguntas(ciudad);
        List<Evento> listaEventos = ciudadActions.getListaProximosEventos(ciudad, 4);
        String fecha = ciudadActions.getFecha();
        float temperatura = ciudadActions.getTemperatura(ciudad);

        CiudadBean ciudadBean = new CiudadBean(listaPregunta, listaEventos, ciudad, temperatura, fecha);
        ciudadActions.addCiudad(ciudadParameter, ciudad);
        request.setAttribute("ciudadBean", ciudadBean);
        rd.redirect(request, response, "jsp/Principal_ciudad.jsp");

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

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        ciudadActions = new Ciudad_Actions(em, utx);

    }

}
