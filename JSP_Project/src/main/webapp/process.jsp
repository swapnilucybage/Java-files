<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bean.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- 4.jsp:usebean :- used to create Bean class Object 
	     5.jsp:setProperty
	     6.jsp:getProperty -->


	<!-- Create Object of Bean Class -->
	<jsp:useBean id="obj" class="com.bean.Book"></jsp:useBean>

	<!-- Read Data from UI and set it to bean object -->
	<!-- Bean class property name(private data member name and UI field name must be Same) -->

	<%-- <jsp:setProperty property="bookName" name="obj"/>
	<jsp:setProperty property="authorName" name="obj"/>
	<jsp:setProperty property="price" name="obj"/> --%>

	<jsp:setProperty property="*" name="obj" />
	<h3>Book Details</h3>
	 Book Name:
	<jsp:getProperty property="bookName" name="obj" /><br>
	 Author Name:
	<jsp:getProperty property="authorName" name="obj" /><br>
	 Price :
	<jsp:getProperty property="price" name="obj" />

	<h3>Process using Java Code</h3>
	<%-- <%
String bn = request.getParameter("bookName");
String an = request.getParameter("authorName");
float p = Float.parseFloat(request.getParameter("price"));

//Create bean class object
Book book = new Book();

//Call to setter methods
book.setBookName(bn);
book.setAuthorName(an);
book.setPrice(p);

//Read data from object and Display it on browser
out.print("Book Name:" + book.getBookName()+"<br>");
out.print("Author Name:" + book.getAuthorName()+"<br>");
out.print("Price:" + book.getPrice());
%> --%>
</body>
</html>