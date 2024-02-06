package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;

@WebServlet("/WelcomeController")
public class WelcomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String email = Customer.getCust_email();
		String password = request.getParameter("cust_pass");
		
		out.println("<h3> Welcome : " + email + "</h3><br><br><br>");
		
//		1. Hidden:
//		out.println("<form action='MyProfileController' method='post'><input type=\"hidden\" name=\"hid_email\" value="+email+"> <input type=\"hidden\" name=\"cust_pass\" value="+password+"><input type=\"submit\" value=\"My Profile\"></form>");
		
//		2. URL Rewriting : 
//		out.println("<a href ='MyProfileController?url_email="+email+"'> Click here to View Profile</a><br><br><br>");
		
//		3. Cookies  4. For Http Session: 
		out.println("<a href ='MyProfileController'> Click here to View Profile</a><br><br><br>");
		
		out.println("<a href ='ViewProducts'> View All Products </a><br><br><br>");
		
		out.println("<a href ='LogoutController'> Logout </a><br><br><br>");
		
		out.println("<form action=\"SeachController\" method=\"post\">\r\n"
				+ "		\r\n"
				+ "		<input name=\"search\">\r\n"
				+ "		<input type=\"submit\" value=\"Search\">\r\n"
				+ "		\r\n"
				+ "	</form>");
	}

}
