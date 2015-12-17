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
        <meta charset="UTF-8">
        <title>Foro ciudades</title>

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/normalize.css" rel="stylesheet" type="text/css"/>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/grid.css'>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat'>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/icomoon-scrtpxls.css'>

        <script src="${pageContext.request.contextPath}/js/prefixfree.min.js"></script>
        <style>

            fieldset.no_border {
                border:none;
            }
        </style>

    </head>

    <body>

        <div class="container">

            <jsp:include page="PanelIzquierdo.jsp"/>

            <div class="grid_8">

                <jsp:include page="Cabecera.jsp"/>
                <jsp:include page="PanelBotonesConfiguracion.jsp"/>

                <div>
                    <article class="box post">
                        <section style="text-align: center">
                            <fieldset class="no_border">

                                <jsp:include page="${jsp}"/>

                            </fieldset>
                        </section>


                    </article>
                </div>

            </div>
        </div>

    </body>
</html>

