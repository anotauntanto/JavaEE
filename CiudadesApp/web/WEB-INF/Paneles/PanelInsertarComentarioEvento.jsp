<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:choose> 
    <c:when test = "${(sessionScope.usuario.nombreUsuario != null)}" >

        <section class="box widget find">
            <form action="${pageContext.request.contextPath}/GuardarComentarioEvento" method="post" name="formulario_mensaje">
                <label class="titulo"> Insertar comentario a un evento  </label>
                <br><br>

                <label for="nombre" class="etiqueta">Usuario: ${sessionScope.usuario.nombreUsuario}</label>
                <br><br>

                <textarea id="texto" name="texto" placeholder="Escriba su comentario" cols="26" rows="5" class="letraTextArea" required></textarea>
                <br><br>

                <button type="submit" value="Enviar" class="btn btn-primary btn-large btn-block">Enviar</button>

            </form>

        </section>

    </c:when>

</c:choose>