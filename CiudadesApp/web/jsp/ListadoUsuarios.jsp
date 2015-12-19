
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="ciudad" >Listado de Usuarios</div>

<c:forEach var="usuario" items="${listaUsuariosBean}"> 
    <fieldset class="hilos">
        Nombre: ${usuario.nombreUsuario}<br>
        ----

    </fieldset>
    <br>
</c:forEach>
<br>


