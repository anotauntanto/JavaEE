<%-- 
    Document   : Panelmapa
    Created on : 19-dic-2015, 15:55:27
    Author     : inftel07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ubicación</title>
        <style type="text/css">
            div#map_container{
                width:400px;
                height:400px;
            }
        </style>
        <script type="text/javascript" 
        src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

        <script type="text/javascript">
            function loadMap() {
                var latlng = new google.maps.LatLng(${coordenadas.x},${coordenadas.y});
                var myOptions = {
                    zoom: 16,
                    center: latlng,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                var map = new google.maps.Map(document.getElementById("map_container"), myOptions);

                var marker = new google.maps.Marker({
                    position: latlng,
                    map: map
                });

            }
        </script>
    </head>

    <body onload="loadMap()">
        <div id="map_container"></div>

    </body>
</html>