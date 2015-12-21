<%-- 
    Document   : Cabecera
    Created on : 17-dic-2015, 12:21:50
    Author     : inftel08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>



<nav class="box nav">

    <c:choose> 

        <c:when test = "${sessionScope.usuario.nombreUsuario != null}">
            <br />
            <span class="username">Sesión iniciada como: ${sessionScope.usuario.nombreUsuario} </span>
            <br />
        </c:when>

    </c:choose>

    <ul>



        <li>
            <a href="${pageContext.request.contextPath}/Boot">
                <span class="icon-home"></span>
                <br />
                <span class="title">Inicio</span>
            </a>
        </li>



        <c:choose>

            <c:when test = "${sessionScope.usuario.idUsuario == 1}">

                <li>
                    <a href="${pageContext.request.contextPath}/Configuracion?metodo=ciudad">
                        <span class="icon-cog"></span>
                        <br />
                        <span class="title">Configuracion</span>
                    </a>
                </li>

            </c:when> 

        </c:choose>



        <li>
            <a href="${pageContext.request.contextPath}/VerListaCiudades?indice=0">
                <span class="icon-bubble"></span>
                <br />
                <span class="title">Listar ciudades</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/ListadoEventos?indice=0">
                <span class="icon-bubble"></span>
                <br />
                <span class="title">Listar eventos</span>
            </a>
        </li>

        <c:choose> 

            <c:when test = "${sessionScope.usuario.nombreUsuario != null}">

                <li>
                    <a href="${pageContext.request.contextPath}/Logout">
                        <span class="icon-arrow-left"></span>
                        <br />
                        <span class="title">Cerrar sesión</span>
                    </a>
                </li>

            </c:when>

            <c:otherwise>    
                <li>
                    <a href="${pageContext.request.contextPath}/Login">
                        <span class="icon-arrow-right"></span>
                        <br />
                        <span class="title">Iniciar sesión</span>
                    </a>
                </li>
            </c:otherwise> 

        </c:choose>

    </ul>
</nav>

