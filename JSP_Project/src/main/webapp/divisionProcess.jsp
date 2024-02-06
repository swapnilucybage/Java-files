<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Read data from UI -->
	<%
	int no1= Integer.parseInt(request.getParameter("no1"));
	int no2= Integer.parseInt(request.getParameter("no2"));
	%>
	
	<%= "Division" + (no1/no2) %>
	
	<%-- <%! String str= null; %>
	<%= "Length is:" + str.length() %> --%>
</body>
</html>