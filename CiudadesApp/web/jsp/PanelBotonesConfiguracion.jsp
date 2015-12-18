<%-- 
    Document   : PanelBotonesConfiguracion
    Created on : 17-dic-2015, 13:08:16
    Author     : inftel08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<p style="text-align: center;font-size: 20pt;color: #ff934d" >Configuración</p>
<nav class="box nav">

    <fieldset class="no_border">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/Configuracion?metodo=ciudad" class="btn btn-primary btn-large btn-block">Añadir Ciudad</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/Configuracion?metodo=listaUsuario" class="btn btn-primary btn-large btn-block">Lista Usuarios</a>
            </li>
        </ul>
    </fieldset>

</nav>