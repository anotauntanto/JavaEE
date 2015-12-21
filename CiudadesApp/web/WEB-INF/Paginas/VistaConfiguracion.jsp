<%-- 
    Document   : VistaConfiguracion
    Created on : 16-dic-2015, 11:09:17
    Author     : inftel06
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html >
    <head>
        <jsp:include page="/WEB-INF/Paneles/Head.jsp"/>
    </head>

    <body>

        <div class="container">

             <div class="grid_3">
                <jsp:include page="/WEB-INF/Paneles/PanelIzquierdo.jsp"/>

            </div>

            <div class="grid_8">

                <jsp:include page="/WEB-INF/Paneles/Cabecera.jsp"/>
                <jsp:include page="/WEB-INF/Paneles/PanelBotonesConfiguracion.jsp"/>

                <div>
                    <article class="box post">
                        <section style="text-align: center">
                            <fieldset class="no_border">

                                <jsp:include page="/WEB-INF/Paneles/${jsp}"/>

                            </fieldset>
                        </section>


                    </article>
                </div>

            </div>
        </div>

    </body>
</html>

