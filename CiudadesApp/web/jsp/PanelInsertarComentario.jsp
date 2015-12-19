<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form action="" method="post" enctype="multipart/form-data" name="formulario_mensaje">
    <label style="text-align: center;font-size: 20pt;color: #ff934d"> Insertar Comentario </label>
    <br>
    <br>


    <label for="nombre">Nombre: Mi Nombre</label>

    <!--<input type=?text? name=?nombre? id=?nombre? required="" /><br>-->
    <br><br>

    <label for="mensaje">Mensaje: </label>
    <br>
    <textarea id="mensaje" name="mensaje" placeholder="Escriba su comentario" cols="39" rows="20" style="font-size: 0.8em"></textarea>
    <br><br>
    <!--<a href="#" class="btn btn-primary btn-block btn-large">Enviar Mensaje</a>-->
    <label for=?direccion? >Dirección:</label><br>
    <input type="text" name=?direccion? id="direccion" required="" size="35"/><br><br>

    <label for="fecha">Fecha:</label><br>
    <input type="text" name="fecha" id="fecha" required="" size="35"/><br><br>

    <label for="descripción">Descripción:</label><br>
    <input type="text" name=?nombre? id="descripción" required="" size="35"/><br><br><br>

    <input type="submit" value="Subir Comentario">

    <br>
    <br>


</form>


