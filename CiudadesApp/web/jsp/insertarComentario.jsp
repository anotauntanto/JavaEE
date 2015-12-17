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
                <!-- BLOQUE DE POST -->
                <div class="col_3of4">
                    <article class="box post">

                        <div class="box post" >
                            <section id=”Formulario” style="text-align: center" >
                                <!--  <p style="text-align: center;font-size: 20pt;color: #ff934d" >Subir Comentario</p>-->

                                <form action="" method="post" enctype="multipart/form-data" name="formulario_mensaje">
                                    <label style="text-align: center;font-size: 20pt;color: #ff934d"> Insertar Comentario </label>
                                    <br>
                                    <br>


                                    <label for="nombre">Nombre: Mi Nombre</label>

                                    <!--<input type=”text” name=”nombre” id=”nombre” required="" /><br>-->
                                    <br><br>

                                    <label for="mensaje">Mensaje: </label>
                                    <br>
                                    <textarea id="mensaje" name="mensaje" placeholder="Escriba su comentario" cols="39" rows="20" style="font-size: 0.8em"></textarea>
                                    <br><br>
                                    <!--<a href="#" class="btn btn-primary btn-block btn-large">Enviar Mensaje</a>-->
                                    <label for=”direccion” >Dirección:</label><br>
                                    <input type="text" name=”direccion” id="direccion" required="" size="35"/><br><br>

                                    <label for="fecha">Fecha:</label><br>
                                    <input type="text" name="fecha" id="fecha" required="" size="35"/><br><br>

                                    <label for="descripción">Descripción:</label><br>
                                    <input type="text" name=”nombre” id="descripción" required="" size="35"/><br><br><br>

                                    <input type="submit" value="Subir Comentario">

                                    <br>
                                    <br>


                                </form>
                            </section>
                        </div>
                    </article>
                </div>

                <jsp:include page="PanelDerecho.jsp"/>
            </div>
        </div>

    </body>
</html>

