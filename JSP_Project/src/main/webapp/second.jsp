<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 style="color:red">Second page</h2>
<%-- <p>Name: <%= request.getAttribute("emp_name") %></p> --%>

<p> Name: <%=request.getParameter("emp_name") %> </p>

</body>
</html>