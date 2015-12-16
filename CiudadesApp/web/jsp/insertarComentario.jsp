<%-- 
    Document   : insertarComentario
    Created on : 15-dic-2015, 10:14:09
    Author     : inftel06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Foro Ciudades</title>

        <link href="../css/normalize.css" rel="stylesheet" type="text/css"/>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/grid.css'>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat'>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/icomoon-scrtpxls.css'>

        <script src="../js/prefixfree.min.js" type="text/javascript"></script>


    </head>

    <body>

        <div class="container">
            <div class="grid_3">
                <section class="box widget locations">
                    <div class="avatar">
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/scrtpxls_location.png" />
                    </div>
                    <div class="details">
                        <h2>De Westerkerk</h2>
                        <p>Prinsengracht 281</p>
                       
                    </div>
                </section>
                <section class="box widget calendar">
                    <header class="header">
                        <h2>Próximos Eventos</h2>
                        <!--<p><span class="icon-arrow-left"></span>Enero<span class="icon-arrow-right"></span></p>-->
                    </header>
                    <article class="days">
                            <ul>
                            Primer Evento 
                            </ul>
                            <li>---</li>
                            <ul>
                            Segundo Evento
                            </ul>
                            <li>---</li>
                            <ul>
                            Ultimo Evento
                            </ul>
                    </article>
                    
                </section>
            </div>
            <div class="grid_8">
                <nav class="box nav">
                    <ul>
                        <li>
                            <a href="#">
                                <span class="icon-home"></span>
                                <br />
                                <span class="title">Inicio</span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="icon-images"></span>
                                <br />
                                <span class="title">Galería</span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="icon-bubble"></span>
                                <br />
                                <span class="title">Añadir nuevo hilo</span>
                            </a>
                        </li>

                        <li>
                            <a href="">
                                <span class="icon-cog"></span>
                                <br />
                                <span class="title">Iniciar sesión</span>
                            </a>
                        </li>

                        <li>
                            <a href="">
                                <span class="icon-cog"></span>
                                <br />
                                <span class="title">Cerrar sesión</span>
                            </a>
                        </li>

                    </ul>
                </nav>


                <!-- BLOQUE DE POST -->
                <div class="col_3of4">
                    <article class="box post">

                        <div class="box post" >
                            <section id=”Formulario” style="text-align: center" >
                              <!--  <p style="text-align: center;font-size: 20pt;color: #ff934d" >Subir Comentario</p>-->
                             
                                <form action="" method="post" enctype="multipart/form-data" name="formulario_mensaje">
                                    <label style="text-align: center;font-size: 20pt;color: #ff934d"> Insertar Comentario </label>
                                    <br>
                                    <br>
                                    
                                    
                                        <label for="nombre">Nombre: Mi Nombre</label>
                                        
                                        <!--<input type=”text” name=”nombre” id=”nombre” required="" /><br>-->
                                        <br><br>
                                        
                                        <label for="mensaje">Mensaje: </label>
                                        <br>
                                        <textarea id="mensaje" name="mensaje" placeholder="Escriba su comentario" cols="39" rows="20" style="font-size: 0.8em"></textarea>
                                        <br><br>
                                        <!--<a href="#" class="btn btn-primary btn-block btn-large">Enviar Mensaje</a>-->
                                        <label for=”direccion” >Dirección:</label><br>
                                        <input type="text" name=”direccion” id="direccion" required="" size="35"/><br><br>
                                        
                                        <label for="fecha">Fecha:</label><br>
                                        <input type="text" name="fecha" id="fecha" required="" size="35"/><br><br>
                                        
                                        <label for="descripción">Descripción:</label><br>
                                        <input type="text" name=”nombre” id="descripción" required="" size="35"/><br><br><br>
                                        
                                        <input type="submit" value="Subir Comentario">
                                        
                                        <br>
                                        <br>

                                    
                                </form>
                            </section>
                        </div>
                    </article>
                </div>


                <!-- BLOQUE LATERAL DERECHO -->
                <div class="inner_container">
                    <div class="col_1of4">
                        <!--<section class="box widget video">
                            <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/scrtpxls_video.png" alt="" />
                        </section>-->

                        <section class="box widget weather">
                            <header class="header">
                                <div class="temp">10&#176; <span class="icon-brightness-half"></span></div>
                                <span class="icon-partlycloudy"></span>
                            </header>
                            <article>
                                <h2>Saturday 16 January</h2>
                            </article>
                        </section>

                        <section class="box widget find">
                            <input type="text" name="find" placeholder="Busca Ciudad" />
                           <!-- <label for="favorite" class="checkbox">
                                <input type="checkbox" id="favorite" name="favorite" /> Add to favorites
                            </label>-->
                            <a href="#" class="btn btn-primary btn-large btn-block">Buscar</a>
                        </section>
                        
                          <section class="box widget find">
                            
                      
                            <a href="#" class="btn btn-primary btn-large btn-block">Ver Mapa</a>
                        </section>

                    </div>

                    <!--<div class="col_2of3">
                        <section class="box widget audio">
                            <div class="image">
                                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/scrtpxls_audio.png" />
                            </div>
                            <div class="details">
                                <h2 class="album">Geef mij maar Amsterdam</h2>
                                <p class="artist">Johnny Jordaan</p>
                                <div class="player">
                                    <div class="bar">
                                        <div class="progress" data-time="1:45"></div>
                                    </div>
                                    <div class="actions">
                                        <a href="#" class="btn"><span class="icon-arrow-left"></span></a>
                                        <a href="#" class="btn btn-primary"><span class="icon-pause"></span></a>
                                        <a href="#" class="btn"><span class="icon-arrow-right"></span></a>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>-->
                    <!--<div class="col_1of3">
                        <section class="box widget find">
                            <input type="text" name="find" placeholder="Find your city place" />
                            <label for="favorite" class="checkbox">
                                <input type="checkbox" id="favorite" name="favorite" /> Add to favorites
                            </label>
                            <a href="#" class="btn btn-primary btn-large btn-block">Search</a>
                        </section>
                    </div>-->
                </div>
            </div>
        </div>





    </body>
</html>
