
<form action="" method="post" enctype="multipart/form-data" name="formulario_evento">
    <label style="text-align: center;font-size: 20pt;color: #ff934d"> Añadir Evento </label>
    <br>
    <br>
    <label for="nombreEvento" >Nombre Evento :</label><br>
    <input type="text" name="nombreEvento" id="nombreEvento" required="" size="20"/><br><br>

    <label for="Descripcion">Descripción :</label>
    <br>
    <textarea id="descripcion" name="descripcion" placeholder="Escriba descripción" cols="50" rows="20" style="font-size: 0.8em"></textarea>

    <br><br>

    <label for="direccion" >Dirección:</label><br>
    <input type="text" name="direccion" id="direccion" required="" size="20"/><br><br>
    <label for="ciudad" >Ciudad:</label><br>
    <input type="text" name="ciudad" id="ciudad" required="" size="20"/><br><br>
    <label for="fecha" >Fecha:</label><br>
    <input type="text" name="fecha" id="fecha" required="" placeholder="dd/mm/yy" size="20"/><br><br>



    <input type="submit" value="Guardar">

    <br>
    <br>
</form>
