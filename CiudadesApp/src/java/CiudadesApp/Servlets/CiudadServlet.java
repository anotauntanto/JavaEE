/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.VerCiudad_Actions;
import CiudadesApp.Modelo.EJBFacade.CiudadFacade;
import CiudadesApp.Modelo.EJBFacade.PreguntaFacade;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
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
    VerCiudad_Actions ciudadActions;


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
       Integer id = Integer.parseInt(request.getParameter("idCiudad"));
        
        //System.out.println("Paso por aquiiiiii al iniciar sesion");
       
       Ciudad ciudad=ciudadActions.getCiudad(id);
       //System.out.println("LISTA ciudad1: "+ciudad.getNombreCiudad());
       
       //Ciudad ciudad2 = (Ciudad) request.getSession().getAttribute("ciudadActual");
       //System.out.println("LISTA ciudad2: "+ciudad2.getNombreCiudad());

       List<Pregunta> listaPregunta= ciudadActions.getListaPreguntas(ciudad);
       
       //System.out.println("LISTA PREGUNTAS: "+listaPregunta.size());
       
       List<Evento> listaEventos = ciudadActions.getListaProximosEventos(ciudad,4);
       String fecha=ciudadActions.getFecha();
       float temperatura=ciudadActions.getTemperatura(ciudad);
       
       request.getSession().setAttribute("ciudadActual",ciudad);
       
       
       CiudadBean ciudadBean=new CiudadBean(listaPregunta,listaEventos,ciudad,temperatura,fecha);
       
       request.setAttribute("ciudadBean",ciudadBean);
        
       RequestDispatcher rd;
      
       rd = request.getRequestDispatcher("jsp/Principal_ciudad.jsp");
       rd.forward(request, response);
       

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
        ciudadActions = new VerCiudad_Actions(em,utx);
        
    }

}
