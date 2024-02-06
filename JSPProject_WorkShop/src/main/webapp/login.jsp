<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
form{
	width:50%;
	margin: auto;
	background-color: grey;
}
</style>
</head>
<body>
	<form action="LoginController" method="get">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="cust_email"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="cust_password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" name="Cancel"></td>
			</tr>
		</table>
	</form>
</body>
</html>