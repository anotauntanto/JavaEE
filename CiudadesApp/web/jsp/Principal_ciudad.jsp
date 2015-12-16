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
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/grid.css'>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat'>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/icomoon-scrtpxls.css'>

        <script src="${pageContext.request.contextPath}/js/prefixfree.min.js"></script>


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

                            <c:when test = "${sessionScope.usuario.nombreUsuario != null}">
                                <li>
                                    <span class="title">Sesión iniciada como: ${sessionScope.usuario.nombreUsuario} </span>
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
                <div class="col_3of4">
                    <article class="box post">
                        <div class="image">
                            <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/scrtpxls_post.png" />
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


                <!-- BLOQUE LATERAL DERECHO -->
                <div class="inner_container">
                    <div class="col_1of4">

                        <section class="box widget weather">
                            <header class="header">
                                <div class="temp">10&#176; <span class="icon-brightness-half"></span></div>
                                <span class="icon-partlycloudy"></span>
                            </header>
                            <article>
                                <h2>Saturday 16 January</h2>
                            </article>
                        </section>

                        <section class="box widget find">
                            <input type="text" name="find" placeholder="Find your city place" />
                            <label for="favorite" class="checkbox">
                                <input type="checkbox" id="favorite" name="favorite" /> Add to favorites
                            </label>
                            <a href="#" class="btn btn-primary btn-large btn-block">Search</a>
                        </section>


                    </div>


                </div>
            </div>
        </div>





    </body>
</html>
