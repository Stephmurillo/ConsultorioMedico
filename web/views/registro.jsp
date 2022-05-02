<%-- 
    Document   : login
    Created on : Apr 30, 2022, 11:55:50 AM
    Author     : muril
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Registrarse</title>
  <link rel="stylesheet" href="../css/login.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-page">
  <div class="form">
    <form class="register-form" action="AccionRegistro" method="post">
        <select name="id_rol">
            <option value="2">Medico</option>
            <option value="3">Paciente</option>
        </select>
        <input type="text" name="ced_usuario" placeholder="usuario"/>
        <input type="password" name="contrasena" placeholder="contraseña"/>
        <input class="button" type="submit" value="Crear">
        <p class="message">Ya tienes una cuenta? <a href="./login.jsp">Inicia Sesión</a></p>
    </form>
  </div>
</div>
</body>
</html>
