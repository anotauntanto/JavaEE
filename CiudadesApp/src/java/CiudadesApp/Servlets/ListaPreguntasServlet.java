/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.Ciudad_Actions;
import CiudadesApp.Modelo.Actions.ListarHilos_Actions;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.ComentarioEvento;
import CiudadesApp.Modelo.Entidad.ComentarioPregunta;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import CiudadesApp.Modelo.Parameter.ListarHilos_Parameter;
import CiudadesApp.ViewBeans.CiudadBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
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
@WebServlet(name = "ListaPreguntasServlet", urlPatterns = {"/ListaPreguntasServlet"})
public class ListaPreguntasServlet extends HttpServlet {

    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    Ciudad_Actions ciudadActions;
    ListarHilos_Actions listarPreguntasActions;

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

        //no es necesario comprobar que el usuario está registrado para que pueda visualizar
        System.out.println ("Holaa " + request.getSession().getAttribute("ciudadActual"));
        
        ListarHilos_Parameter listarPreguntasParameter = new ListarHilos_Parameter(request);
        Ciudad ciudad = listarPreguntasActions.getCiudad(listarPreguntasParameter);

        String fecha = ciudadActions.getFecha();
        float temperatura = ciudadActions.getTemperatura(ciudad);
        
        List<Pregunta> listaPregunta = new ArrayList<Pregunta>();
        List<Evento> listaEventos = new ArrayList<Evento>();
        List<?> listaComentarios = new ArrayList<>();

        //if (tipo.equals("preguntas")){
        listaPregunta = ciudadActions.getListaPreguntas(ciudad);
        Pregunta pregunta = em.find(Pregunta.class, listarPreguntasParameter.getIdHilo());
        listaComentarios = (List<ComentarioPregunta>) pregunta.getComentarioPreguntaCollection();

       //}
       /*else{ 
         Evento evento=em.find(Evento.class, idHilo);
         listaEventos = ciudadActions.getListaProximosEventos(ciudad,5);
         listaComentarios = (List<ComentarioEvento>) evento.getComentarioEventoCollection();
         }*/
        listaEventos = ciudadActions.getListaProximosEventos(ciudad, 5);

       //List<ComentarioPregunta> listaComentarios = (List<ComentarioPregunta>) pregunta.getComentarioPreguntaCollection();
        CiudadBean ciudadBean = new CiudadBean(listaPregunta, listaEventos, ciudad, temperatura, fecha);
        request.setAttribute("ciudadBean", ciudadBean);
        request.setAttribute("listaComentarios", listaComentarios);
        request.setAttribute("pregunta", pregunta);
        request.getSession().setAttribute("preguntaActual", pregunta);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("jsp/ListadoHilosCiudad.jsp");
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

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        ciudadActions = new Ciudad_Actions(em, utx);
        listarPreguntasActions = new ListarHilos_Actions();

    }
}
