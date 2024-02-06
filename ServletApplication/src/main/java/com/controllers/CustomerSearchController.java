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

import com.dao.CustomerRegistrationDao;

/**
 * Servlet implementation class CustomerSearchController
 */
@WebServlet("/CustomerSearchController")
public class CustomerSearchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String search = request.getParameter("cust_search");
		
		response.setContentType("text/html");
		System.out.println("Search is: "+search);
		
		ResultSet rs = CustomerRegistrationDao.searchResult(search);

		out.println("<table border=1px>");
		out.println("<tr>"
						+ "<td>Id</td>"
						+ "<td>Name</td>"
						+ "<td>Email</td>"
						+ "<td>password</td>"
						+ "<td>address</td>"
						+ "<td>gender</td>"
						+ "<td>dob</td>"
					+ "</tr>"
					);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
