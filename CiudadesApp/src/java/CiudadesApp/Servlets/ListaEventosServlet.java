/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Servlets;

import CiudadesApp.Modelo.Actions.Ciudad_Actions;
import CiudadesApp.Modelo.Actions.ListaEvento_Actions;
import CiudadesApp.Modelo.Actions.ListarHilos_Actions;
import CiudadesApp.Modelo.Entidad.Ciudad;
import CiudadesApp.Modelo.Entidad.ComentarioEvento;
import CiudadesApp.Modelo.Entidad.ComentarioPregunta;
import CiudadesApp.Modelo.Entidad.Evento;
import CiudadesApp.Modelo.Entidad.Pregunta;
import CiudadesApp.Modelo.Parameter.ListarHilos_Parameter;
import CiudadesApp.ViewBeans.CiudadBean;
import CiudadesApp.ViewBeans.ListaEventosBean;
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
@WebServlet(name = "ListaEventosServlet", urlPatterns = {"/ListaEventosServlet"})
public class ListaEventosServlet extends HttpServlet {

    @PersistenceContext(unitName = "ForodeCiudadesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    Ciudad_Actions ciudadActions;
    ListarHilos_Actions listarHilosActions;
    ListaEvento_Actions listarEventosActions;

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
        ListarHilos_Parameter listarEventosParameter = new ListarHilos_Parameter(request);
        
        Ciudad ciudad = listarHilosActions.getCiudad(listarEventosParameter);

        String fecha = ciudadActions.getFecha();
        float temperatura = ciudadActions.getTemperatura(ciudad);
        List<Pregunta> listaPregunta = new ArrayList<Pregunta>();
        List<Evento> listaEventos = new ArrayList<Evento>();
        List<ComentarioEvento> listaComentarios = new ArrayList<>();

        /*if (tipo.equals("preguntas")){
         listaPregunta= ciudadActions.getListaPreguntas(ciudad);
         Pregunta pregunta=em.find(Pregunta.class, idHilo);
         listaComentarios = (List<ComentarioPregunta>) pregunta.getComentarioPreguntaCollection();
           
         //}
         /*else{ */
        Evento evento = em.find(Evento.class, listarEventosParameter.getIdHilo());

        listaEventos = ciudadActions.getListaProximosEventos(ciudad, 5);
        
        //listaComentarios = (List<ComentarioEvento>) evento.getComentarioEventoCollection();
    //}
        listaComentarios =ciudadActions.getListaComentariosEvento(evento);
      //listaEventos = ciudadActions.getListaProximosEventos(ciudad,5);
       //List<ComentarioPregunta> listaComentarios = (List<ComentarioPregunta>) pregunta.getComentarioPreguntaCollection();
        CiudadBean ciudadBean = new CiudadBean(listaEventos, ciudad, temperatura, fecha);
        ListaEventosBean listaEventosBean=new ListaEventosBean(evento.getDescripcion(),listaComentarios,
                ciudad, evento);
        request.setAttribute("listaComentariosBean", listaEventosBean);
        //request.setAttribute("listaComentarios", listaComentarios);
        request.setAttribute("ciudadBean", ciudadBean);
        request.getSession().setAttribute("eventoActual", evento);
        request.setAttribute("tipoHilo", "Eventos");
        int numAsistentes = listarEventosActions.getNumeroAsistentes(evento);
        request.setAttribute("numeroAsistentes",numAsistentes);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("jsp/ListadoEventos.jsp");
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
        listarHilosActions = new ListarHilos_Actions();
        listarEventosActions = new ListaEvento_Actions(em,utx);

    }
}
