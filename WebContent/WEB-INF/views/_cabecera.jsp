<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<div style="background: #198754; color: #f4f4f4; display: flex;
    justify-content: space-around;
    align-items: center;">
<h1>Alberto</h1>
<div>
<a style="margin-right: 1px" href="Inicio">Inicio</a>
<a style="margin-right: 1px" href="Login">Login</a>
<a style="margin-right: 1px" href="ListaProductos">Listado de Productos</a>
</div>
<p>Has iniciado sesión como:  
<%
HttpSession sesion = (HttpSession) request.getSession();
out.println(sesion.getAttribute("usuario"));
%>
</p>
</div>

