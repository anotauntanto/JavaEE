<%-- 
    Document   : PanelDerecho
    Created on : 17-dic-2015, 12:51:31
    Author     : inftel08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<section class="box widget weather">
    <header class="header">
        <div class="temp">${ciudadBean.temperatura}&#176; </div>
        <span class="icon-partlycloudy"></span>
    </header>
    <article>
        <h2>${ciudadBean.fecha}</h2>
    </article>
</section>

<section class="box widget find">
    <!-- <input type="submit" value="Guardar">
    <input type="text" name="find" placeholder="Introduce tu busqueda" />
    
    <a href="ListadoCiudadesBuscar" class="btn btn-primary btn-large btn-block">Search</a>
    </input>-->
    <form action="${pageContext.request.contextPath}/ListadoCiudadesBuscar" method="post" acceptcharset="UTF-8" >
    <input type="text" name="find" placeholder="Introduce tu busqueda" />
    <input type="submit" value="Buscar" class="btn btn-primary btn-large btn-block">
    </form>
    
</section>
