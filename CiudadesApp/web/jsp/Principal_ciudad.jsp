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
                <jsp:include page="PanelEventos.jsp"/>

            </div>

            <div class="grid_8">

                <jsp:include page="Cabecera.jsp"/>

                <!-- BLOQUE DE POST -->
                <div class="col_3of4">
                    <article class="box post">
                        <div class="image">
                            <img src="${pageContext.request.contextPath}/mostrarImagen?Id=${ciudadBean.ciudad.idCiudad}" width = "400" height = "400" />
                        </div>
                        <div class="details">
                            <h2>${ciudadBean.ciudad.nombreCiudad}</h2>
                            <p>${ciudadBean.ciudad.descripcion}</p>
                        </div>

                    </article>

                    <article class="box post">
                        <p style="text-align: center;font-size: 20pt;color: #ff934d" >Hilos sobre ${ciudadBean.ciudad.nombreCiudad}</p>

                        <c:forEach var="pregunta" items="${ciudadBean.listaPreguntas}"> 
                            <fieldset class="hilos">
                                ${pregunta.texto}
                            </fieldset>
                            <br>
                        </c:forEach>

                    </article>
                </div>

                <div class="inner_container">
                    <div class="col_1of4">
                        <jsp:include page="PanelDerecho.jsp"/>
                        <jsp:include page="PanelInsertarHilos.jsp"/>
                    </div>
                </div>

            </div>
        </div>

    </body>

</html>