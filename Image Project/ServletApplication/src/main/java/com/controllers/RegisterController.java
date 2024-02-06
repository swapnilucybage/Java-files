package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.model.Customer;

@WebServlet("/RegisterController")  //servlet url-mapping
public class RegisterController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		display on browser : 
//		PrintWriter out = response.getWriter();
//		out.println("<h1>Welcome to Web Application.....</h1>");
//		out.println("Name : <input type='text'>");
//		
//		System.out.println("Welcome to Web Application.....");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

//		display on browser : 
		PrintWriter out = response.getWriter();
//		out.println("<h1>Welcome to Web Application.....</h1>");
//		out.println("Name : <input type='text'>");
//		
//		System.out.println("Welcome to Web Application.....");
		
//		Read Data from UI :
		
		String cust_name = request.getParameter("cust_name");
		String cust_email = request.getParameter("cust_email");
		String cust_pass = request.getParameter("cust_pass");
		String cust_add = request.getParameter("cust_add");
		String cust_gend = request.getParameter("cust_gend");
		String cust_dob = request.getParameter("cust_dob");
		
//		out.println("Name : " +cust_name);
//		out.println("Email : " +cust_email);
//		out.println("Password : " +cust_pass);
//		out.println("Gender : " +cust_gend);
//		out.println("DOB : " +cust_dob);
		
//		Create Model Class Object : 
//		Customer customer = new Customer();
		
//		set data received from ui to model object :
		Customer.setCust_id(0);
		Customer.setCust_name(cust_name);
		Customer.setCust_email(cust_email);
		Customer.setCust_pass(cust_pass);
		Customer.setCust_gend(cust_gend);
		Customer.setCust_dob(cust_dob);
		Customer.setCust_add(cust_add);
		
//		Call Dao Class Method: 
		int res = CustomerDao.registerCustomer();
		
		if(res > 0) {
			
			System.out.println("Record Inserted.......");
			response.sendRedirect("customer-login.html");
		}
		
		else System.out.println("Try Again!!!!!!");
	}
}
