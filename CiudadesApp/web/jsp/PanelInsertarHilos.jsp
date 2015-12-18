<%-- 
    Document   : PanelInsertar
    Created on : 18-dic-2015, 10:51:14
    Author     : inftel08
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<c:choose> 

    <c:when test = "${sessionScope.usuario.nombreUsuario != null}">


        <section class="box widget find">

            <label for="favorite" class="checkbox"> Inserciones </label>
            <a href="#" class="btn btn-primary btn-large btn-block">Insertar pregunta</a>
            <br>
            <a href="#" class="btn btn-primary btn-large btn-block">Insertar evento</a>

        </section>

    </c:when>

</c:choose>
