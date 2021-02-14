<%@ page import="bd.ConsultasBD" %>
<%@ page import="entidades.Productos" %>
<%@ page import = "java.util.LinkedList"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de productos</title>
</head>
<body>
<h1>Listado de productos</h1>
<p>Esta consulta se lanzo el ==> <%=new java.util.Date()%></p>
<table border="1">
<tr>
<th>cod</th>
<th>nombre</th>
<th>precio</th>
</tr>
<%
LinkedList<Productos> listado = ConsultasBD.getListado();
for (int i=0;i<listado.size();i++)
{
   out.println("<tr>");
   out.println("<td>"+listado.get(i).getCod()+"</td>");
   out.println("<td>"+listado.get(i).getNombre()+"</td>");
   out.println("<td>"+listado.get(i).getPrecio()+"€ </td>");
   out.println("</tr>");
}
%>
</table>
</body>
</html>