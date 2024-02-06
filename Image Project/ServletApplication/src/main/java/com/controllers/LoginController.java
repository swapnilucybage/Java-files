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

import com.dao.CustomerDao;
import com.model.Customer;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String cust_email = request.getParameter("cust_email");
		String cust_pass = request.getParameter("cust_pass");
		
		Customer.setCust_email(cust_email);
		Customer.setCust_pass(cust_pass);
		
		if(CustomerDao.loginCustomer()) {
			
			out.println("Customer Login Successfully....");
			
//			Create Cookie on first request : 
//			Cookie ck = new Cookie("cookie_email", cust_email);
//			response.addCookie(ck);
			
//			2. Create Http Session :
			HttpSession session = request.getSession();
			session.setAttribute("cust_email", cust_email);
			
			RequestDispatcher rd = request.getRequestDispatcher("WelcomeController");
			rd.forward(request, response);
//			response.sendRedirect("customer-registration.html");
		}
		
		else {
			
			out.println("Invalid Credentials, Try Again!!!!!!");
			RequestDispatcher rd = request.getRequestDispatcher("customer-login.html");
			rd.include(request, response);
		}
	}

}
