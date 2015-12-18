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
    <input type="text" name="find" placeholder="Find your city place" />
    <label for="favorite" class="checkbox">
        <input type="checkbox" id="favorite" name="favorite" /> Add to favorites
    </label>
    <a href="#" class="btn btn-primary btn-large btn-block">Search</a>
</section>
