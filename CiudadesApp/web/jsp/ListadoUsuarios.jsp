<%@page contentType="text/html" pageEncoding="UTF-8"%>

<p style="text-align: center;font-size: 20pt;color: #ff934d" >Lista de Usuarios</p>

   <c:forEach var="usuario" items="${listaUsuariosBean}"> 
<fieldset class="hilos">
    Nombre: ${usuario.listaUsuario.nombreUsuario}<br>
    ----
    
</fieldset>
<br>
   </c:foreach>
<br>

