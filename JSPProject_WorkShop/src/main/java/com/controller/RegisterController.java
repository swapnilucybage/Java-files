package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.RegisterDao;
import com.model.Customer;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String name = request.getParameter("cust_name");
		String email = request.getParameter("cust_email");
		String pass = request.getParameter("cust_pass");
		String gender = request.getParameter("cust_gender");
		String address = request.getParameter("cust_address");
		String dob = request.getParameter("cust_dob");

		Customer c = new Customer();
		c.setCust_name(name);
		c.setCust_email(email);
		c.setCust_address(address);
		c.setCust_gender(gender);
		c.setCust_pass(pass);
		c.setCust_dob(dob);

		int result = RegisterDao.registerCustomer(c);

		if (result > 0) {
			System.out.println("Registration Success");
			RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		} else {
			System.out.println("Register again");
			RequestDispatcher rd =request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}
	}
}
