<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String datoRecuperado = session.getAttribute("resultadoBusqueda").toString();
	%>
	<%=datoRecuperado%>
	
	<%= 
	session.getAttribute("resultadoBusqueda").toString()
	%>
	<form method="get" action="volver">
		<input type="submit" name="Enviar" value="VOLVER">
	</form>
</body>
</html>