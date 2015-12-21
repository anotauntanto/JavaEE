<%-- 
    Document   : ListadoHilosCiudad
    Created on : 18-dic-2015, 11:44:39
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
                    <p class="ciudad" >Preguntas sobre ${listaComentariosBean.ciudad.nombreCiudad}</p>

                    <article class="box post">
                        <fieldset class="hilos">
                            <div class="campo-clave">Usuario :</div> <div class="campo-valor">${listaComentariosBean.evento.idUsuario.nombreUsuario}</div>
                            <div class="campo-clave">Pregunta :</div> <div class="campo-valor">${listaComentariosBean.texto_Inicio}</div>
                        </fieldset>

                    </article>

                    <article class="box post">

                        <c:forEach var="comentario" items="${listaComentariosBean.listaComentarios}"> 
                            <fieldset class="hilos">
                                <div class="campo-clave">Usuario :</div> <div class="campo-valor">${comentario.idUsuario.nombreUsuario}<div>
                                        <div class="campo-clave">Respuesta :</div> <div class="campo-valor">${comentario.texto}</div>

                                        </fieldset>

                                    </c:forEach>

                                    </article>
                                </div>

                                <div class="inner_container">
                                    <div class="col_1of3">
                                        <jsp:include page="/WEB-INF/Paneles/PanelEventos.jsp"/>
                                        <jsp:include page="/WEB-INF/Paneles/PanelInsertarComentarioPregunta.jsp"/>
                                    </div>
                                </div>

                            </div>
                            </div>

                            </body>

                            </html>
