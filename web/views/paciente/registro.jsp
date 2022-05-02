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
  <title>Informacion del paciente</title>
  <link rel="stylesheet" href="../css/login.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-page">
  <div class="form">
    <form class="register-form" action="AccionRegistro" method="post">
         <input type="text" name="nombre" placeholder="nombre"/>
        <input type="text" name="apellido1" placeholder="primer apellido"/>
        <input type="text" name="apellido2" placeholder="segundo apellido"/>
        <select name="genero">
            <option value="masculino">Masculino</option>
            <option value="femenino">Femenino</option>
            <option value="otro">Otro</option>
        </select>
        <input type="text" name="fecha_nacimiento" placeholder="dd/MM/yyyy" onfocus="(this.type='date')">
        <input type="text" name="telefono" min="8" max="8">
        <input class="button" type="submit" value="Guardar">
    </form>
  </div>
</div>
</body>
</html>
