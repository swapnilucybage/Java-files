package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDao;
import com.model.Customers;

@WebServlet("/loginController")
public class loginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
//		System.out.println(email);
//		System.out.println(pass);

		Customers c = new Customers();
		c.setC_email(email);
		c.setC_pass(pass);

		boolean result = CustomerDao.loginCustomer(c);

		if (result) {
			// cookie
//			Cookie ck = new Cookie("cust_email", email);
//			response.addCookie(ck);

//			Session
//			HttpSession session = request.getSession(true);
//			session.setAttribute("cust_email", email);
//			session.setAttribute("password", pass);

			out.println("<h2 style='color:green'>Login Successfull.</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("HomePageController");
			rd.include(request, response);

		} else {
			out.println("<h2 style='color:red'>Login Again.</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");

			rd.include(request, response);
		}
	}

}
