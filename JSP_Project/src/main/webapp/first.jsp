<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Action tag.
			1. jsp:include
			2. jsp:forward
			3. jsp:params
			4.jsp:usebean :- used to create Bean class Object
			5.jsp:setProperty
			6.jsp:getProperty
	 -->
	
	<h1>Welcome to first page</h1>
	<%!String name = "January";%>
	
	<%-- 
	<%
	request.setAttribute("emp_name",name);
	%> 
	--%>
	
	<jsp:forward page="second.jsp">
		<jsp:param value="<%=name%>" name="emp_name"/>
	</jsp:forward>	
	
	
	<%-- 
		<jsp:include page="second.jsp"></jsp:include> 
	--%>

	<%-- <%
	RequestDispatcher rd = request.getRequestDispatcher("second.jsp");
	rd.include(request, response);
	
	
	%> --%>

</body>
</html>