
<%@page import="com.Dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.*,com.model.Customer,java.sql.PreparedStatement"
    
    %>
    
<%
	String email = (String)session.getAttribute("cust_email");
	Customer c = CustomerDao.getMyProfile(email);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome page <%= session.getAttribute("cust_email") %></h1>
	<a href="profile.jsp">Profile</a>
	
	
	
	
	
	<h2>Customer Details are:</h2>
	<table border="1">
	<tr>
		<td>Id</td>
		<td>Name</td>
		<td>Email</td>
		<td>password</td>
		<td>Address</td>
		<td>Gender</td>
		<td>DOB</td>
	</tr>
	
	<tr>
		<td><%= c.getCust_id() %></td>
		<td><%= c.getCust_name() %></td>
		<td><%= c.getCust_email() %></td>
		<td><%= c.getCust_pass() %></td>
		<td><%= c.getCust_address() %></td>
		<td><%= c.getCust_gender() %></td>
		<td><%= c.getCust_dob() %></td>
	</tr>
	
	</table>
</body>
</html>