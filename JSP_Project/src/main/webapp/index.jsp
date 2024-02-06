<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>hello world</h1>

	<!-- 
Special tag of jsp:
1. Declaration tag:	
	used to declare variables.
	every declaration must end with semicolon.
 -->

	<%!String name = "Pikachu";
	int age = 21;
	int a = 34, b = 82;%>

	<!-- 
2. Expression Tag: 
	Used to evaluate expression and display result on the browser.	
 -->

	<h3>
		Name :
		<%=name%></h3>
	<h3>
		Age :
		<%=age%></h3>
	<h3>
		Division of 82/34 :
		<%=b / a%>
	</h3>


	<!-- 
3. Scriplet Tag:
	Used to hold any valid java code.
 -->
	<%
	//we can write jdbc code, collection code, multithreading code, Declaration code.
	// requestDispatcher
	//out.println()
	out.println("Inside scriplet tag");
	%>



</body>
</html>