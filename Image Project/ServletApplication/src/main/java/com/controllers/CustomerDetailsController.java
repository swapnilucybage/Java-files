package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;

@WebServlet("/CustomerDetailsController")
public class CustomerDetailsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			PrintWriter out = response.getWriter();
			ResultSet rs = CustomerDao.getCustomerDetails();
			
			out.println("<h1>------------------Customer Details------------------</h1>");
			
			out.println("<table cellspacing=\"4px\" cellpadding=\"5px\">");
			out.println("<tr><td>Name</td><td>Email</td><td>Address</td><td>Gender</td><td>DOB</td></tr>");
			while(rs.next()) {
				
				out.print("<tr>");
				out.print("<td>" + rs.getString(2) + "</td>");
				out.print("<td>" + rs.getString(3) + "</td>");
				out.print("<td>" + rs.getString(5) + "</td>");
				out.print("<td>" + rs.getString(6) + "</td>");
				out.print("<td>" + rs.getString(7) + "</td>");
				out.print("</tr>");
			}
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
