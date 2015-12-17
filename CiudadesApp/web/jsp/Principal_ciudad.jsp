<%-- 
    Document   : Inicio
    Created on : 15-dic-2015, 9:27:34
    Author     : inftel08
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
        <link href="${pageContext.request.contextPath}/css/grid.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/icomoon-scrtpxls.css" rel="stylesheet" type="text/css"/>

        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat'>


        <script src="${pageContext.request.contextPath}/js/prefixfree.min.js"></script>


    </head>

    <body>

        <div class="container">

            <jsp:include page="PanelIzquierdo.jsp"/>

            <div class="grid_8">

                <jsp:include page="Cabecera.jsp"/>

                <!-- BLOQUE DE POST -->
                <div class="col_3of4">
                    <article class="box post">
                        <div class="image">
                            <img src="http://localhost:8080/CiudadesApp/mostrarImagen?Id=3" width = "400" height = "400" />
                        </div>
                        <div class="details">
                            <h2>Amsterdan</h2>
                            <p>Amsterdam is the capital city of and the most populous within the Kingdom of the Netherlands. Amsterdam's name derives from Amstelredamme. Amsterdam is located in the western... Netherlands</p>
                        </div>

                    </article>

                    <article class="box post">
                        <p style="text-align: center;font-size: 20pt;color: #ff934d" >Hilos sobre Berlin</p>
                        <fieldset class="hilos">
                            Hilo1 de Berlin
                        </fieldset>
                        <br>
                        <fieldset class="hilos">
                            Hilo2 de Berlin
                        </fieldset>
                        <br>
                    </article>
                </div>
                <jsp:include page="PanelDerecho.jsp"/>
            </div>
        </div>

    </body>
</html>
