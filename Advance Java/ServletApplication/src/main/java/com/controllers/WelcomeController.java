package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeController
 */
@WebServlet("/WelcomeController")
public class WelcomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("cust_email");
//		String pass = request.getParameter("cust_pass");
		out.println("<h3>Welcomt :"+ email+"</h3>");
		
		// 1. we cannot able to access email in MyProfileController servlet.
//		out.println("<a href='MyProfileController'>MyProfile</a>");
		
		// 2. session tracking with hidden field.
//		out.println("<form action=\"MyProfileController\" method=\"get\">" );
//		out.println("<input type=\"hidden\" name=\"hidden_email\" value='"+email+"'>");
//		out.println("<input type=\"submit\" value=\'MyProfile'\">");
//		out.println("</form>");
//		out.println("<br>");
		
		// 3. URL rewriting
//		out.println("<a href='MyProfileController?url_email="+email+"'>MyProfile</a>");
		
//		4. cookie
//		out.println("<a href='MyProfileController'>MyProfile</a>");
		
//		5. Session
		out.println("<a href='MyProfileController'>MyProfile</a>");
		
		
		out.println("<form action=\"CustomerSearchController\" method=\"get\">" );
		out.println("Search: <input type=\"text\" name=\"cust_search\">");
		out.println("<input type=\"submit\" value=\"submit\">");
		out.println("</form>");
	}

}
