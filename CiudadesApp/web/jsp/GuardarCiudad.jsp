<form action="${pageContext.request.contextPath}/GuardarCiudad" method="post" enctype="multipart/form-data" name="formulario_ciudad">
    <label style="text-align: center;font-size: 20pt;color: #ff934d"> A�adir Ciudad </label>
    <br>
    <br>
    <label for="nombreCiudad" >Nombre Ciudad :</label><br>
    <input type="text" name="nombreCiudad" id="nombreCiudad" required="" size="20"/><br><br>

    <label for="Descripcion">Descripci�n :</label>
    <br>
    <textarea id="descripcion" name="descripcion" placeholder="Escriba descripci�n" cols="50" rows="20" style="font-size: 0.8em"></textarea>

    <br><br>

    <label for="foto" >Subir foto :</label>
    <input type="file" name="fileName" accept="image/*"><br>


    <br><br>

    <input type="submit" value="Guardar">

    <br>
    <br>


</form>

