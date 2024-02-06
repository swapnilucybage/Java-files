package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.LoginDao;
import com.model.Customer;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String email = request.getParameter("cust_email");
		String pass = request.getParameter("cust_password");

		Customer c = new Customer();
		c.setCust_email(email);
		c.setCust_pass(pass);

		boolean result = LoginDao.loginCustomer(c);
		if (result) {
			// cookie
			//Cookie ck = new Cookie("cust_email", email);
			//response.addCookie(ck);

			//Session
			HttpSession session = request.getSession(true);
			session.setAttribute("cust_email", email);
			session.setAttribute("password", pass);

			out.println("<h2 style='color:green'>Login Successfull.</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");

			rd.forward(request, response);

		} else {
			out.println("<h2 style='color:red'>Login Again.</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");

			rd.include(request, response);
		}
	}

}
