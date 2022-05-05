<%-- 
    Document   : registro
    Created on : May 1, 2022, 8:14:51 PM
    Author     : muril
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información del medico</title>
        <link rel="stylesheet" href="../../css/default.css">
    </head>
<body>
<div class="login-page">
  <div class="form">
      <h2>Información del Medico</h2>
    <form class="register-form" action="AccionMedicoRegistro" method="post">
        <input type="text" name="nombre" placeholder="nombre"/>
        <input type="text" name="apellido1" placeholder="primer apellido"/>
        <input type="text" name="apellido2" placeholder="segundo apellido"/>
        <select name="genero" placeholder="genero">
            <option value="M">Masculino</option>
            <option value="F">Femenino</option>
            <option value="O">Otro</option>
        </select>
        <input type="text" name="costo_consulta" placeholder="costo consulta"/>
        <select name="frecuencia_citas" placeholder="frecuencia citas">
            <option value="20">cada 20 min</option>
            <option value="40">cada 40 min</option>
            <option value="60">cada 60 min</option>
        </select>
        <input class="button" type="submit" value="Guardar">
    </form>
  </div>
</div>
</body>
</html>
