
<form action="${pageContext.request.contextPath}/GuardarPregunta" method="post" enctype="multipart/form-data" name="formulario_pregunta">
    <label style="text-align: center;font-size: 20pt;color: #ff934d"> Añadir Pregunta </label>
    <br>
    <br>

    <label for="pregunta">Pregunta :</label>
    <br>
    <textarea id="pregunta" name="pregunta" placeholder="Escriba pregunta" cols="50" rows="5" style="font-size: 0.8em"></textarea>

    <br><br>

    <label for="ciudad" >Ciudad:</label><br>
    <input type="text" name="ciudad" id="ciudad" required="" size="20"/><br><br>

    <input type="submit" value="Guardar">

    <br>
    <br>
</form>
