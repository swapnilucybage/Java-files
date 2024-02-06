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

@WebServlet("/LogOutController")
public class LogOutController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//cookie logout
//		Cookie ck = new Cookie("cust_email", "");
//		ck.setMaxAge(0);
//		
//		response.addCookie(ck);
		
//		session logout
		HttpSession session =  request.getSession(false);
		session.setAttribute("cust_email", null);
		session.setAttribute("password", null);
		
		session.invalidate();
		
		PrintWriter out = response.getWriter();
		out.println("<h2 style='color:brown'>Logout successful</h2>");
		
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.include(request, response);
	}

	

}
