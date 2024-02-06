<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
		table {
			width: 30%;
			margin: auto;
			background-color: lightblue;
			border: 2px solid black;
		}
		
		tr, td {
			margin: 5px;
		}
	</style>
</head>
<body>
	<form action="RegisterController" method="get">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="cust_name"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="cust_email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="cust_pass"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>Male<input type="radio" name="cust_gender" value="Male">
					Female<input type="radio" name="cust_gender" value="Male"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea rows="7" cols="20" name="cust_address"></textarea></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="cust_dob"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
				<td><input type="reset" value="reset"></td>
			</tr>

		</table>
	</form>
</body>
</html>