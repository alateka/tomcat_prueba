<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
<jsp:include page="_cabecera.jsp"></jsp:include>
<b>Inicie sesión por favor</b>
<form action="Login" method="POST">
Usuario: <input type="text" name="usuario">
Contraseña: <input type="password" name="contrasenia">
<input type="submit" value="Iniciar sesión">
</form>
<jsp:include page="_pie.jsp"></jsp:include>
</body>
</html>