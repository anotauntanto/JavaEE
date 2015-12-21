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
        <jsp:include page="/WEB-INF/Paneles/Head.jsp"/>
    </head>

    <body>

        <div class="container">

            <div class="grid_3">
                <jsp:include page="/WEB-INF/Paneles/PanelIzquierdo.jsp"/>

            </div>

            <div class="grid_8">

                <jsp:include page="/WEB-INF/Paneles/Cabecera.jsp"/>

                <article class="box post">
                    <fieldset class="hilos">
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

                            <a class="ciudad">Listado de Ciudades</a>
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
                        <fieldset class="hilos">
                            <div class="image" >
                                <img src="${pageContext.request.contextPath}/mostrarImagen?Id=${ciudad.idCiudad}" width="200" height="200" align="right" class="bordeImagen"/>
                            </div>
                            <div class="details">
                                <a href="${pageContext.request.contextPath}/CiudadServlet?idCiudad=${ciudad.idCiudad}" class="inicio"> ${ciudad.nombreCiudad}</a><br>
                                <div class="letraciudad">${ciudad.descripcion}</div>
                            </div>
                        </fieldset>    
                    </article>

                </c:forEach>

            </div>
        </div>
    </body>

</html>


