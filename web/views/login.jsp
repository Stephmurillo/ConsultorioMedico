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
  <title>Inciar Sesión</title>
  <link rel="stylesheet" href="../css/default.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-page">
  <div class="form">
    <form class="login-form" action="AccionLogin" method="post">
      <input type="text" name="txtName" placeholder="usuario"/>
      <input type="password" name="txtPassword" placeholder="contraseña"/>
      <input class="button" type="submit" value="Iniciar Sesión">
      <p class="message"> <a href="./registro.jsp">Crear una nueva cuenta</a></p>
    </form>
  </div>
</div>
</body>
</html>
