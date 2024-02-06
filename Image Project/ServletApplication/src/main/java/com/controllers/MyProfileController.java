package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDao;
import com.model.Customer;

@WebServlet("/MyProfileController")
public class MyProfileController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Hiii</h1>");
		
		try {
			
//			1. Hidden :
//			String email = request.getParameter("hid_email");
			
//			2. URL Rewriting: 
//			String email = request.getParameter("url_email");
			
//			Getter Setter :
//			String email = Customer.getCust_email();
			out.println("Using Getter Setter : " + Customer.getCust_email() + "<br><br>");
			
//			3.Cookie : 
//			Cookie[] ck = request.getCookies();
			
//			4. Using Http Session : 
			HttpSession session = request.getSession(false);
			String email = (String) session.getAttribute("cust_email");
			
//			String email = null;
//			if(ck != null) email = ck[0].getValue();
//			out.println("Using Cookie : " + email + "<br><br>");
			
//			out.println("<h1>" + email + "</h1>");
			ResultSet rs = CustomerDao.getCustomerDetailsByEmail(email);
			
			while(rs.next()) {
				
				out.println("Id : " + rs.getInt(1));
				out.println("<br><br>");
				out.println("Name : " + rs.getString(2));
				out.println("<br><br>");
				out.println("Email : " + rs.getString(3));
				out.println("<br><br>");
				out.println("Address : " + rs.getString(5));
				out.println("<br><br>");
				out.println("Gender : " + rs.getString(6));
				out.println("<br><br>");
				out.println("DOB : " + rs.getString(7));
				out.println("<br><br>");
			}
		} 
		
		catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Hiii</h1>");
		
		try {
			
//			1. Hidden :
//			String email = request.getParameter("hid_email");
			
//			2. URL Rewriting: 
			String email = request.getParameter("url_email");
			
//			out.println("<h1>" + email + "</h1>");
			ResultSet rs = CustomerDao.getCustomerDetailsByEmail(email);
			
			while(rs.next()) {
				
				out.println("Id : " + rs.getInt(1));
				out.println("<br><br>");
				out.println("Name : " + rs.getString(2));
				out.println("<br><br>");
				out.println("Email : " + rs.getString(3));
				out.println("<br><br>");
				out.println("Address : " + rs.getString(5));
				out.println("<br><br>");
				out.println("Gender : " + rs.getString(6));
				out.println("<br><br>");
				out.println("DOB : " + rs.getString(7));
				out.println("<br><br>");
			}
		} 
		
		catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
