<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="CiudadesApp.I18N.file" />
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Inicio sesión / registro</title>

        <link href="${pageContext.request.contextPath}/css/style2.css" rel="stylesheet" type="text/css"/>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <script src="${pageContext.request.contextPath}/js/comprobarContrasena.js" type="text/javascript"></script>

    </head>

    <body>

        <form class="position">
            <label><fmt:message key="Idioma"/></label>
            <select id="language" name="language" onchange="submit();">

                <option value="es_ES" <c:if test="${language=='es_ES'}">selected</c:if>>
                    <fmt:message key="Espanol" />
                </option>
                <option value="en_GB" <c:if test="${language=='en_GB'}">selected</c:if>>
                    <fmt:message key="Ingles" />
                </option>
            </select>
        </form>
        <!-- Mixins-->
        <!-- Pen Title-->
        <div class="pen-title"></div>
        <div class="rerun"></div>

        <div class="container">
            <div class="card"></div>
            <div class="card">

                <h1 class="title"><fmt:message key="Iniciar"/></h1>

                <form method="post" action="${pageContext.request.contextPath}/Login">

                    <div class="input-container">
                        <input type="text" id="usuario" required="required" name = "usuario"/>
                        <label for="usuario"><fmt:message key="Usuario"/></label>

                        <div class="bar"></div>

                    </div>

                    <div class="input-container">
                        <input type="password" id="pass" required="required" name="pass"/>
                        <label for="pass"><fmt:message key="Clave"/></label>
                        <div class="bar"></div>
                    </div>
                    <div class="button-container">
                        <button><span><fmt:message key="Enviar"/></span></button>
                    </div>

                </form>    
            </div>

            <div class="card alt">
                <div class="toggle"></div>
                <div class="title"><fmt:message key="Registro"/>
                    <div class="close"></div>
                </div>

                <form method="post" action="${pageContext.request.contextPath}/Signin">

                    <div class="input-container">
                        <input type="text" id="usuario" name="usuario" required="required"/>
                        <label for="usuario"><fmt:message key="Usuario"/></label>
                        <div class="bar"></div>

                        <c:choose>
                            <c:when test="${error == 'Nombre de usuario en uso'}">
                                <span id="mensaje_1" class="mensajeError">Nombre de usuario en uso</span>
                            </c:when>
                        </c:choose> 
                    </div>

                    <div class="input-container">
                        <input type="password" id="pass1" name="pass1" required="required" onkeyup="comprobarSeguridad();"/>
                        <label for="pass1"><fmt:message key="Clave"/></label>
                        <span id="mensaje2" class="mensaje"></span>
                        <div class="bar"></div>
                    </div>

                    <div class="input-container">
                        <input type="password" id="pass2" required="required" name="pass2" onkeyup="comprobarCoinciden();"/>
                        <label for="pass2"><fmt:message key="Clave2"/></label>
                        <span id="mensaje3" class ="mensaje"></span>
                        <div class="bar"></div>
                    </div>
                    <div class="button-container">
                        <button><span><fmt:message key="Registrar"/></span></button>
                    </div>
                </form>
            </div>
        </div>

        <div class="pen-title"></div>
        <div class="rerun"></div>

        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="${pageContext.request.contextPath}/js/index.js" type="text/javascript"></script>

    </body>
</html>
