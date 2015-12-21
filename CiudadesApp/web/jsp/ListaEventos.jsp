<%-- 
    Document   : ListaEventos
    Created on : 19-dic-2015, 15:13:16
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

            </div>

            <div class="grid_8">

                <jsp:include page="Cabecera.jsp"/>

                <article class="box post">
                    <fieldset class="hilos">
                        <div class="col_1of4">
                            <c:choose>
                                <c:when test="${eventosBean.indice == 0}">
                                    ￼   <a href="" class="btn btn-large btn-block">Anterior</a>
                                </c:when>
                                <c:otherwise>
                                    ￼<a href="${pageContext.request.contextPath}/ListadoEventos?indice=${eventosBean.indice-5}" class="btn btn-large btn-block">Anterior</a>
                                </c:otherwise>
                            </c:choose>
                        </div> 
                        <div class="col_2of4">

                            <a class="ciudad">Listado de Eventos</a>
                        </div> 

                        <div class="col_1of4" align="right">
                            <c:choose>
                                <c:when test="${eventosBean.indice < eventosBean.total-5 }">
                                    ￼   <a href="${pageContext.request.contextPath}/ListadoEventos?indice=${eventosBean.indice+5}" class="btn  btn-large btn-block">Siguiente</a>
                                </c:when>
                                <c:otherwise>
                                    ￼<a href="" class="btn btn-large btn-block">Siguiente</a>
                                </c:otherwise>
                            </c:choose>             
                        </div>
                    </fieldset>
                </article>
                <!-- Para cada Ciudad -->
                <c:forEach var="evento" items="${eventosBean.listaEvento}"> 

                    <article class="box post">
                        <fieldset class="hilos">
                            <div class="details">
                                <h2> ${evento.nombreEvento}<br>                                    
                                    Fecha: ${evento.fecha}</h2> <br>
                                Ciudad: <a href="${pageContext.request.contextPath}/CiudadServlet?idCiudad=${evento.idCiudad.idCiudad}" class="inicio"> ${evento.idCiudad.nombreCiudad} </a> 
                                <br>
                                Dirección: ${evento.direccion}
                                <p class="letraciudad">${evento.descripcion}</p>
                            </div>
                        </fieldset>    
                    </article>

                </c:forEach>

            </div>
        </div>
    </body>
    
</html>
