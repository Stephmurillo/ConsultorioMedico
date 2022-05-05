<%-- 
    Document   : registro.jsp
    Created on : May 1, 2022, 8:14:24 PM
    Author     : muril
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Información del paciente</title>
  <link rel="stylesheet" href="../../css/default.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-page">
  <div class="form">
      <h2>Información del Paciente</h2>
    <form class="register-form" action="AccionPacienteRegistro" method="post">
        <input type="text" name="nombre" placeholder="nombre"/>
        <input type="text" name="apellido1" placeholder="primer apellido"/>
        <input type="text" name="apellido2" placeholder="segundo apellido"/>
        <select name="genero" placeholder="genero">
            <option value="M">Masculino</option>
            <option value="F">Femenino</option>
            <option value="O">Otro</option>
        </select>
        <input type="text" name="fecha_nacimiento" placeholder="fecha nacimiento" onfocus="(this.type='date')">
        <input type="tel" name="telefono" placeholder="telefono" maxlength="12" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
        <input class="button" type="submit" value="Guardar">
    </form>
  </div>
</div>
</body>
</html>
