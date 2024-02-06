<%@page import="com.Dao.CustomerDao"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="search.jsp">
		Search <input type="search" name="cust_search"> <input
			type="submit" value="Submit">
	</form>

	<%
	if (request.getParameter("cust_search") != null) {
		String search = request.getParameter("cust_search");
		ResultSet rs = CustomerDao.getSearchDetails(search);
		if (rs != null) {
	%>
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

		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getString(6)%></td>
			<td><%=rs.getString(7)%></td>
		</tr>
		<%
		}
		}
		}
		%>
	</table>
</body>
</html>