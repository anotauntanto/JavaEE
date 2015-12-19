<%-- 
    Document   : PanelIzquierdo
    Created on : 17-dic-2015, 12:48:53
    Author     : inftel08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="box widget calendar">
    <header class="header">
        <h2>Próximos Eventos</h2>
        <p>${ciudadBean.ciudad.nombreCiudad}</p>
    </header>
    <article class="days">
        <c:forEach var="evento" items="${ciudadBean.listaEventos}"> 
            <br>
            <a href="${pageContext.request.contextPath}/ListaEventosServet?idCiudad=${ciudadBean.ciudad.idCiudad}&indice=0&idHilo=${evento.idEvento}">
                ${evento.nombreEvento}
            </a>    
            <br>
            Fecha:${evento.fecha}
            <br>
            ----
        </c:forEach>
    </article>
</section>