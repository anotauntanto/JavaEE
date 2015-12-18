<%-- 
    Document   : PanelIzquierdo
    Created on : 17-dic-2015, 12:48:53
    Author     : inftel08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

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
            <p>${ciudadBean.ciudad.nombreCiudad}</p>
        </header>
        <article class="days">
            <c:forEach var="evento" items="${eventoBean}"> 

                ${evento.nombreEvento} 
                Fecha:${evento.fecha}

                ----
            </c:forEach>
        </article>
    </section>
</div>
