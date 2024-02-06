package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerRegistrationDao;

@WebServlet("/CustomerDetailsController")
public class CustomerDetailsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet rs = CustomerRegistrationDao.getDetails();
		
		PrintWriter out = response.getWriter();
		
		
			out.println("<table border=1px>");
			out.println("<tr>"
							+ "<td>Id</td>"
							+ "<td>Name</td>"
							+ "<td>Email</td>"
							+ "<td>password</td>"
							+ "<td>address</td>"
							+ "<td>gender</td>"
							+ "<td>dob</td>"
						+ "</tr>");
			try {
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>"+rs.getString(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getString(5)+"</td>");
					out.println("<td>"+rs.getString(6)+"</td>");
					out.println("<td>"+rs.getString(7)+"</td>");
					out.println("</tr>");
					
				}
			out.println("</table>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
