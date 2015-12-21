
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="ciudad" >Listado de Usuarios</div>

<c:forEach var="usuario" items="${listaUsuariosBean}"> 
    <fieldset class="hilos">
        Nombre: ${usuario.nombreUsuario}<br>
        ----
    </fieldset>
</c:forEach>
<br>


