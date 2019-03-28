<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Añadir contacto</h3>
	<form method="get" action="LogOut">
		<input type="submit" name="Enviar" value="Log Out">
	</form>
	<table>
		<tr>
			<td><p><b>Nombre</b></p></td>
			<td><p><b>Telefono</b></p></td>
			<td>
			</td>
		</tr>
		<tr>
			<form method="get" action="AddUser">
				<td><input type="text" name="name"></td>
				<td><input type="text" name="telefono"></td>
				<td><input type="submit" name="Enviar" value="Add user"></td>
			</form>
		</tr>
	</table>
	<h3>Eliminar contacto</h3>
	<table>
		<tr>
			<td><p><b>Nombre usuario</b></p></td>
			<td></td>
		</tr>
		<tr>
			<form method="get" action="DropUser">
				<td><input type="text" name="name"></td>
				<td><input type="submit" name="Enviar" value="Drop user"></td>
			</form>
		</tr>
	</table>
	<h3>Actualizar contacto</h3>
	<table>
		<tr>
			<td><p><b>Nombre</b></p></td>
			<td><p><b>Telefono</b></p></td>
			<td></td>
		</tr>
		<tr>
			<form method="get" action="UpdateUser">
				<td><input type="text" name="name"></td>
				<td><input type="text" name="telefono"></td>
				<td><input type="submit" name="Enviar" value="Update user"></td>
			</form>
		</tr>
	</table>
	<h3>Ver contactos</h3>
	<table>
		<tr>
			<td></td>
		</tr>
		<tr>
			<form method="get" action="listUser">
				<td><input type="submit" name="Enviar" value="Find user"></td>
			</form>
		</tr>
</body>
</html>