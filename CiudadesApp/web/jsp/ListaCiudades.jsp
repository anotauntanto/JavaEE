<%-- 
    Document   : ListaCiudades
    Created on : 16-dic-2015, 10:23:40
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
        <style>
            fieldset {
                border:none;
            }
        </style>


    </head>

    <body>

        <div class="container">
            <div class="grid_3">
                <section class="box widget locations">
                    <div class="avatar">
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/scrtpxls_location.png" />
                    </div>
                    <div class="details">
                        <h2>Foro de ciudades</h2>
                        <p>JAMP</p>

                    </div>
                </section>
                <section class="box widget calendar">
                    <header class="header">
                        <h2>Próximos Eventos</h2>
                        <p><span class="icon-arrow-left"></span>January<span class="icon-arrow-right"></span></p>
                    </header>
                    <article class="days">
                        <ul>
                            Primer evento
                        </ul>
                    </article>
                </section>
            </div>
            <div class="grid_8">
                <nav class="box nav">
                    <ul>
                        <c:choose> 

                            <c:when test = "${sessionScope.usuario != null}">
                                <li>
                                    <span class="title">Sesión iniciada como: ${sessionScope.usuario} </span>
                                </li>

                                <li>
                                    <a href="">
                                        <span class="icon-bubble"></span>
                                        <br />
                                        <span class="title">Añadir nuevo hilo</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="">
                                        <span class="icon-bubble"></span>
                                        <br />
                                        <span class="title">Añadir nuevo evento</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="${pageContext.request.contextPath}/Logout">
                                        <span class="icon-cog"></span>
                                        <br />
                                        <span class="title">Cerrar sesión</span>
                                    </a>
                                </li>

                            </c:when>

                            <c:otherwise>    
                                <li>

                                    <a href="${pageContext.request.contextPath}/Login">
                                        <span class="icon-cog"></span>
                                        <br />
                                        <span class="title">Iniciar sesión</span>
                                    </a>
                                </li>
                            </c:otherwise> 

                        </c:choose>


                    </ul>
                </nav>


                <!-- BLOQUE DE POST -->
                <div class="col_4of4">
                    <p style="text-align: center;font-size: 20pt;color: #ff934d" >Listado de Ciudades</p>
                    <article class="box post">
                        <fieldset >
                            <div class="image" >
                                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/scrtpxls_post.png" width="250" height="250" align="right"/>
                            </div>
                            <div class="details">
                                <h2>Amsterdan</h2>
                                <p>Amsterdam is the capital city of and the most populous within the Kingdom of the Netherlands. Amsterdam's name derives from Amstelredamme. Amsterdam is located in the western... Netherlands</p>
                            </div>
                        </fieldset>    
                    </article>

                </div>
       
            </div>
        </div>





    </body>
</html>
