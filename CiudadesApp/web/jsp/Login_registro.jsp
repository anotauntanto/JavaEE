<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Inicio sesión / registro</title>

        <link href="../css/style2.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/reset.css">
        <link href="../css/estiloRegistro.css" rel="stylesheet" type="text/css"/>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <!--<script src="../js/comprobarContrasena.js" type="text/javascript"></script>-->
        
    </head>

    <body>

        <!-- Mixins-->
        <!-- Pen Title-->
        <div class="pen-title"></div>
        <div class="rerun"></div>

        <div class="container">
            <div class="card"></div>
            <div class="card">

                <h1 class="title">Iniciar sesión</h1>
                
                <form method="post" action="${pageContext.request.contextPath}/Login">

                    <div class="input-container">
                        <input type="text" id="usuario" required="required" name = "usuario"/>
                        <label for="usuario">Nombre de usuario</label>

                        <div class="bar"></div>

                        <c:choose>
                            <c:when test="${Error == 'Usuario incorrecto'}">
                                <span id="mensaje1" class="mensajeError">Nombre de usuario incorrecto</span>
                            </c:when>    
                        </c:choose> 

                    </div>

                    <div class="input-container">
                        <input type="password" id="pass" required="required" name="pass"/>
                        <label for="pass">Contraseña</label>
                        <div class="bar"></div>
                    </div>
                    <div class="button-container">
                        <button><span>Enviar</span></button>
                    </div>

                </form>    
            </div>

            <div class="card alt">
                <div class="toggle"></div>
                <div class="title">Registro
                    <div class="close"></div>
                </div>

                <form method="post" action="../${ant.project.name}RegistroServlet">

                    <div class="input-container">
                        <input type="text" id="usuario" name="usuario" required="required"/>
                        <label for="usuario">Nombre de usuario</label>
                        <div class="bar"></div>
                        
                        <c:choose>
                            <c:when test="${error == 'Nombre de usuario en uso'}">
                                <span id="mensaje_1" class="mensajeError">Nombre de usuario en uso</span>
                            </c:when>
                        </c:choose> 
                    </div>
                    
                    <div class="input-container">
                        <input type="password" id="pass1" name="pass1" required="required" onkeyup="comprobarSeguridad();"/>
                        <label for="pass1">Contraseña</label>
                        <span id="mensaje2" class="mensaje"></span>
                        <div class="bar"></div>
                    </div>
                    
                    <div class="input-container">
                        <input type="password" id="pass2" required="required" name="pass2" onkeyup="comprobarCoinciden();"/>
                        <label for="pass2">Repite contraseña</label>
                        <span id="mensaje3" class ="mensaje"></span>
                        <div class="bar"></div>
                    </div>
                    <div class="button-container">
                        <button><span>Registrar</span></button>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="pen-title"></div>
        <div class="rerun"></div>

        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="../js/index.js" type="text/javascript"></script>

    </body>
</html>
