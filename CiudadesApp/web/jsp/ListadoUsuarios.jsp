
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<p style="text-align: center;font-size: 20pt;color: #ff934d" >Listadooo de Usuarios</p>

<c:forEach var="usuario" items="${listaUsuariosBean}"> 
    <fieldset class="hilos">
        Nombre: ${usuario.nombreUsuario}<br>
        ----

    </fieldset>
    <br>
</c:forEach>
<br>


