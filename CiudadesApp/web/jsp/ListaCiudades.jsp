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
       


    </head>

    <body>

        <div class="container">

            <div class="grid_3">
                <jsp:include page="PanelIzquierdo.jsp"/>

            </div>

            <div class="grid_8">

                <jsp:include page="Cabecera.jsp"/>

                <article class="box post">
                    <fieldset >
                        <div class="col_1of4">
                            <c:choose>
                                <c:when test="${ciudadesBean.indice == 0}">
                                    ￼   <a href="" class="btn btn-large btn-block">Anterior</a>
                                </c:when>
                                <c:otherwise>
                                    ￼<a href="${pageContext.request.contextPath}/VerListaCiudades?indice=${ciudadesBean.indice-3}" class="btn btn-large btn-block">Anterior</a>
                                </c:otherwise>
                            </c:choose>
                        </div> 
                        <div class="col_2of4">

                            <a style="text-align: center;font-size: 20pt;color: #ff934d" >Listado de Ciudades</a>
                        </div> 

                        <div class="col_1of4" align="right">
                            <c:choose>
                                <c:when test="${ciudadesBean.indice < ciudadesBean.total-3 }">
                                    ￼   <a href="${pageContext.request.contextPath}/VerListaCiudades?indice=${ciudadesBean.indice+3}" class="btn  btn-large btn-block">Siguiente</a>
                                </c:when>
                                <c:otherwise>
                                    ￼<a href="" class="btn btn-large btn-block">Siguiente</a>
                                </c:otherwise>
                            </c:choose>             
                        </div>
                    </fieldset>
                </article>
                <!-- Para cada Ciudad -->
                <c:forEach var="ciudad" items="${ciudadesBean.listaCiudades}"> 

                    <article class="box post">
                        <fieldset >
                            <div class="image" >
                                <img src="${pageContext.request.contextPath}/mostrarImagen?Id=${ciudad.idCiudad}" width="200" height="200" align="right"/>
                            </div>
                            <div class="details">
                                <h2><a href="${pageContext.request.contextPath}/CiudadServlet?idCiudad=${ciudad.idCiudad}"> ${ciudad.nombreCiudad}</a></h2>
                                <p style="font-size:18pt"   >${ciudad.descripcion}</p>
                            </div>
                        </fieldset>    
                    </article>

                </c:forEach>

            </div>
        </div>
    </body>
    
</html>


