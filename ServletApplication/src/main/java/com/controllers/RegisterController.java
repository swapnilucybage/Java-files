package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerRegistrationDao;
import com.model.Customer;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
//		out.println("<h1>Welcome to servlet demo</h1>");
//		out.println("Name: <input type='text'>");
		
		String cust_name= request.getParameter("cust_name");
		String cust_email= request.getParameter("cust_email");
		String cust_pass= request.getParameter("cust_pass");
		String cust_gender= request.getParameter("cust_gender");
		String cust_address= request.getParameter("cust_address");
		String cust_dob= request.getParameter("cust_dob");
		
		
		//Create Model Class Object
		
		Customer customer = new Customer();
		//Set Data received from UI to model object
		customer.setCust_name(cust_name);
		customer.setCust_email(cust_email);
		customer.setCust_pass(cust_pass);
		customer.setCust_gender(cust_gender);
		customer.setCust_address(cust_address);
		customer.setCust_dob(cust_dob);
		
		//Call DAO Class Method
		int result =CustomerRegistrationDao.registerCustomer(customer);
		if(result ==1)
		{
			out.println("Record Inserted");
		}else
		{
			out.println("Try Again");
		}
		response.sendRedirect("Login.html");
		response.setContentType("text/html");
		
//		out.println(cust_name);
//		out.println(cust_email);
//		out.println(cust_pass);
//		out.println(cust_gender);
//		out.println(cust_address);
//		out.println(cust_dob);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
