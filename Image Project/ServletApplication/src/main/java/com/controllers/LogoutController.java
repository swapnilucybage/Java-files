package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
//		1. Cookie Logout : 
//		Cookie ck = new Cookie("cookie_email", null);
//		ck.setMaxAge(0);
//		response.addCookie(ck);
		
//		2. HttpSession Logout : 
		HttpSession session = request.getSession(false);
		session.setAttribute("cust_email", null);
		session.invalidate();
		
//		out.println("Email" +session.getAttribute("cust_email"));
		out.println("Logout Successfully!!!");
		RequestDispatcher rd = request.getRequestDispatcher("customer-login.html");
		rd.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
