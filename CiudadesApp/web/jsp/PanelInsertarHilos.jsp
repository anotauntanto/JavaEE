<%-- 
    Document   : PanelInsertar
    Created on : 18-dic-2015, 10:51:14
    Author     : inftel08
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
    $(function () {
        $("#datepicker").datepicker();
    });
</script>

<c:choose> 

    <c:when test = "${sessionScope.usuario.nombreUsuario != null}">


        <section class="box widget find">
            <form action="${pageContext.request.contextPath}/GuardarPregunta" method="post" name="formulario_pregunta">

                <label style="text-align: center;font-size: 17pt;color: #ff934d"> Añadir pregunta </label> <br><br>
                <textarea id="pregunta" name="pregunta" placeholder="Escriba pregunta" cols="23" rows="5" style="font-size: 0.8em"></textarea><br><br>           
                <input type="submit" value="Enviar" class="btn btn-primary btn-large btn-block">
                <br>
            </form>
        </section>

        <section class="box widget find">
            <form action="${pageContext.request.contextPath}/GuardarEvento" method="post" name="formulario_evento">

                <label style="text-align: center;font-size: 17pt;color: #ff934d"> Añadir evento </label> <br><br>
                <input type="text" name ="nombre" placeholder="Nombre del evento"><br>
                <input type="text" id="datepicker" name="fecha" placeholder="Fecha"><br>
                <input type="text" name="direccion" placeholder="Direccion"><br>
                <textarea id="pregunta" name="descripcion" placeholder="Descripción" cols="23" rows="5" style="font-size: 0.8em"></textarea><br><br> 

                <input type="submit" value="Enviar" class="btn btn-primary btn-large btn-block">
                <br>
            </form>
        </section>

    </c:when>

</c:choose>
