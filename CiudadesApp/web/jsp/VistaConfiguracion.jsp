<%-- 
    Document   : VistaConfiguracion
    Created on : 16-dic-2015, 11:09:17
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

            fieldset.no_border {
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

                <p style="text-align: center;font-size: 20pt;color: #ff934d" >Configuración</p>
                <nav class="box nav">

                    <fieldset class="no_border">
                        <ul>
                            <li>
                                <a href="${pageContext.request.contextPath}/Configuracion?metodo=ciudad" class="btn btn-primary btn-large btn-block">Añadir Ciudad</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/Configuracion?metodo=evento" class="btn btn-primary btn-large btn-block">Añadir Evento</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/Configuracion?metodo=pregunta" class="btn btn-primary btn-large btn-block">Añadir Pregunta</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/Configuracion?metodo=listaUsuario" class="btn btn-primary btn-large btn-block">Lista Usuarios</a>
                            </li>
                        </ul>
                    </fieldset>

                </nav>

                <div>
                    <article class="box post">
                        <section style="text-align: center">
                            <fieldset class="no_border">
                                <c:choose> 

                                    <c:when test = "${metodo == 'ciudad'}">    
                                        
                                        <form action="${pageContext.request.contextPath}/GuardarCiudad" method="post" enctype="multipart/form-data" name="formulario_ciudad">
                                            <label style="text-align: center;font-size: 20pt;color: #ff934d"> Añadir Ciudad </label>
                                            <br>
                                            <br>
                                            <label for="nombreCiudad" >Nombre Ciudad :</label><br>
                                            <input type="text" name="nombreCiudad" id="nombreCiudad" required="" size="20"/><br><br>

                                            <label for="Descripcion">Descripción :</label>
                                            <br>
                                            <textarea id="descripcion" name="descripcion" placeholder="Escriba descripción" cols="50" rows="20" style="font-size: 0.8em"></textarea>

                                            <br><br>

                                            <label for="foto" >Subir foto :</label>
                                            <input type="file" name="fileName" accept="image/*"><br>


                                            <br><br>

                                            <input type="submit" value="Guardar">

                                            <br>
                                            <br>


                                        </form>
                                    </c:when>
                                    <c:when test = "${metodo == 'evento'}">      
                                        <form action="" method="post" enctype="multipart/form-data" name="formulario_evento">
                                            <label style="text-align: center;font-size: 20pt;color: #ff934d"> Añadir Evento </label>
                                            <br>
                                            <br>
                                            <label for="nombreEvento" >Nombre Evento :</label><br>
                                            <input type="text" name="nombreEvento" id="nombreEvento" required="" size="20"/><br><br>

                                            <label for="Descripcion">Descripción :</label>
                                            <br>
                                            <textarea id="descripcion" name="descripcion" placeholder="Escriba descripción" cols="50" rows="20" style="font-size: 0.8em"></textarea>

                                            <br><br>

                                            <label for="direccion" >Dirección:</label><br>
                                            <input type="text" name="direccion" id="direccion" required="" size="20"/><br><br>
                                            <label for="ciudad" >Ciudad:</label><br>
                                            <input type="text" name="ciudad" id="ciudad" required="" size="20"/><br><br>
                                            <label for="fecha" >Fecha:</label><br>
                                            <input type="text" name="fecha" id="fecha" required="" placeholder="dd/mm/yy" size="20"/><br><br>



                                            <input type="submit" value="Guardar">

                                            <br>
                                            <br>


                                        </form>
                                    </c:when>
                                    <c:when test = "${metodo == 'pregunta'}">      
                                        <form action="" method="post" enctype="multipart/form-data" name="formulario_pregunta">
                                            <label style="text-align: center;font-size: 20pt;color: #ff934d"> Añadir Pregunta </label>
                                            <br>
                                            <br>

                                            <label for="pregunta">Pregunta :</label>
                                            <br>
                                            <textarea id="pregunta" name="pregunta" placeholder="Escriba pregunta" cols="50" rows="5" style="font-size: 0.8em"></textarea>

                                            <br><br>

                                            <label for="ciudad" >Ciudad:</label><br>
                                            <input type="text" name="ciudad" id="ciudad" required="" size="20"/><br><br>

                                            <input type="submit" value="Guardar">

                                            <br>
                                            <br>

                                        </form>
                                    </c:when>
                                    <c:when test = "${metodo == 'listaUsuario'}">      

                                        <p style="text-align: center;font-size: 20pt;color: #ff934d" >Lista de Usuarios</p>
                                        <fieldset class="hilos">
                                            Hilo1 de Berlin
                                        </fieldset>
                                        <br>
                                        <fieldset class="hilos">
                                            Hilo2 de Berlin
                                        </fieldset>
                                        <br>


                                    </c:when>
                                    <c:otherwise>

                                    </c:otherwise>
                                </c:choose>    
                            </fieldset>
                        </section>


                    </article>
                </div>



            </div>
        </div>





    </body>
</html>

