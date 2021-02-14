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
<form action="Login" method="post">
Usuario: <input type="text">
Contraseña: <input type="text">
<input type="submit" value="Iniciar sesión">
</form>
<jsp:include page="_pie.jsp"></jsp:include>
</body>
</html>