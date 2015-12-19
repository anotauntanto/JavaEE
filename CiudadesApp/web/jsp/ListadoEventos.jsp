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
        <meta charset="UTF-8">
        <title>Foro ciudades</title>

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/normalize.css" rel="stylesheet" type="text/css"/>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/grid.css'>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat'>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/icomoon-scrtpxls.css'>

        <script src="${pageContext.request.contextPath}/js/prefixfree.min.js"></script>

    </head>

    <body>

        <div class="container">

            <div class="grid_3">
                <jsp:include page="PanelIzquierdo.jsp"/>
                <jsp:include page="PanelDerecho.jsp"/>

            </div>

            <div class="grid_9">

                <jsp:include page="Cabecera.jsp"/>

                <!-- BLOQUE DE POST -->
                <div class="col_2of3">
                    <p> Evento en: ${listaComentariosBean.ciudad.nombreCiudad}</p>

                    <article class="box post">
                        <fieldset class="hilos">
                            <div class="campo-clave">Creador del evento:</div> <div class="campo-valor"> ${listaComentariosBean.evento.idUsuario.nombreUsuario}</div>
                            <div class="campo-clave">Evento: </div> <div class="campo-valor">${listaComentariosBean.evento.nombreEvento} </div>
                            <div class="campo-clave">Fecha: </div> <div class="campo-valor"> ${listaComentariosBean.evento.fecha}</div>
                            <div class="campo-clave">Descripción: </div>  <div class="campo-valor"> ${listaComentariosBean.evento.descripcion}</div>
                            <c:choose> 
                                <c:when test = "${(sessionScope.usuario.nombreUsuario != null)}">
                                   
                                    <a href="${pageContext.request.contextPath}/AsistirServlet?idHilo=${listaComentariosBean.evento.idEvento}&idCiudad=${listaComentariosBean.ciudad.idCiudad}" class="btn btn-large" >
                                        Asistir</a>
                                       
                                </c:when>
                            </c:choose>
                            Asistentes: ${numeroAsistentes} 
                            <div class="campo-clave">Dirección: </div> <a href="${pageContext.request.contextPath}/MapaServlet" target="_blank" onClick="window.open(this.href, this.target, 'width=420,height=440'); return false;"> <div class="campo-valor">${listaComentariosBean.evento.direccion}</div> </a>

                        </fieldset>

                    </article>

                    <article class="box post">

                        <c:forEach var="comentario" items="${listaComentariosBean.listaComentarios}"> 
                            <fieldset class="hilos">
                                <div class="campo-clave">Usuario :</div> <div class="campo-valor"> ${comentario.idUsuario.nombreUsuario}</div>
                                <div class="campo-clave">Comentario :</div> <div class="campo-valor"> ${comentario.texto}</div>

                            </fieldset>
                            <br>
                        </c:forEach>

                    </article>
                </div>

                <div class="inner_container">
                    <div class="col_1of3">
                        <jsp:include page="PanelEventos.jsp"/>
                        <jsp:include page="PanelInsertarComentarioEvento.jsp"/>
                    </div>
                </div>

            </div>
        </div>

    </body>

</html>
