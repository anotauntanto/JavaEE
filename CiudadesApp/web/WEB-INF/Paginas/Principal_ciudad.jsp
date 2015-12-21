<%-- 
    Document   : VerCiudad
    Created on : 17-dic-2015, 17:38:12
    Author     : inftel06
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html >
    <head>
        <jsp:include page="/WEB-INF/Paneles/Head.jsp"/>
    </head>

    <body>

        <div class="container">

            <div class="grid_3">
                <jsp:include page="/WEB-INF/Paneles/PanelIzquierdo.jsp"/>
                <jsp:include page="/WEB-INF/Paneles/PanelDerecho.jsp"/>

            </div>

            <div class="grid_9">

                <jsp:include page="/WEB-INF/Paneles/Cabecera.jsp"/>

                <!-- BLOQUE DE POST -->
                <div class="col_2of3">
                    <article class="box post">
                        <div class="image">
                            <img src="${pageContext.request.contextPath}/mostrarImagen?Id=${ciudadBean.ciudad.idCiudad}"/>
                        </div>
                        <div class="details">
                            <h2>${ciudadBean.ciudad.nombreCiudad}</h2>
                            <p class="letraciudad">${ciudadBean.ciudad.descripcion}</p>
                        </div>

                    </article>

                    <article class="box post">
                        <div class="ciudad" >Preguntas sobre ${ciudadBean.ciudad.nombreCiudad}</div><br>

                        <c:forEach var="pregunta" items="${ciudadBean.listaPreguntas}"> 
                            <fieldset class="hilos">
                                <a href="${pageContext.request.contextPath}/ListaPreguntasServlet?idCiudad=${ciudadBean.ciudad.idCiudad}&idHilo=${pregunta.idPregunta}" class="enlace">
                                    ${pregunta.texto}
                                </a>
                            </fieldset>
                            <br>
                        </c:forEach>

                    </article>
                </div>

                <div class="inner_container">
                    <div class="col_1of3">

                        <jsp:include page="/WEB-INF/Paneles/PanelEventos.jsp"/>
                        <jsp:include page="/WEB-INF/Paneles/PanelInsertarHilos.jsp"/>

                    </div>
                </div>

            </div>
        </div>

    </body>

</html>
