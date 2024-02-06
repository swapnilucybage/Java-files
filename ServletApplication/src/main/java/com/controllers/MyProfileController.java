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

import com.dao.CustomerRegistrationDao;
import com.mysql.cj.xdevapi.Result;


@WebServlet("/MyProfileController")
public class MyProfileController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

//		String email = request.getParameter("cust_email");

//
		ResultSet rs = null;
		//cookie:
//		Cookie ck[] = request.getCookies();
//		if (ck != null) {
//			String email = ck[0].getValue();
//			if (email != null) {
//				out.print("<h1 style='color:red'>" + email + "</h1>");
////				System.out.println("Welcome" + email);
//				rs = CustomerRegistrationDao.getMyProfile(email);
//			}
//
//		}
		
//		out.print("<a href=\"LogOutController\"> Logout </a>");
//
//		out.println("<table border=1px>");
//		out.println("<tr>" + "<td>Id</td>" + "<td>Name</td>" + "<td>Email</td>" + "<td>password</td>"
//				+ "<td>address</td>" + "<td>gender</td>" + "<td>dob</td>" + "</tr>");
//		try {
//			while (rs.next()) {
//				out.println("<tr>");
//				out.println("<td>" + rs.getString(1) + "</td>");
//				out.println("<td>" + rs.getString(2) + "</td>");
//				out.println("<td>" + rs.getString(3) + "</td>");
//				out.println("<td>" + rs.getString(4) + "</td>");
//				out.println("<td>" + rs.getString(5) + "</td>");
//				out.println("<td>" + rs.getString(6) + "</td>");
//				out.println("<td>" + rs.getString(7) + "</td>");
//				out.println("</tr>");
//
//			}
//			out.println("</table>");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		Session
		HttpSession session  = request.getSession(false);
		out.println("<h2>"+session.getAttribute("cust_email")+"</h2>");
		out.println("<h2>"+session.getAttribute("password")+"</h2>");
		
		if(session != null) {
			String email = (String) session.getAttribute("cust_email");
			if(email != null) {
				out.print("<a href=\"LogOutController\"> Logout </a>");

				out.println("<table border=1px>");
				out.println("<tr>" + "<td>Id</td>" + "<td>Name</td>" + "<td>Email</td>" + "<td>password</td>"
						+ "<td>address</td>" + "<td>gender</td>" + "<td>dob</td>" + "</tr>");
				try {
					while (rs.next()) {
						out.println("<tr>");
						out.println("<td>" + rs.getString(1) + "</td>");
						out.println("<td>" + rs.getString(2) + "</td>");
						out.println("<td>" + rs.getString(3) + "</td>");
						out.println("<td>" + rs.getString(4) + "</td>");
						out.println("<td>" + rs.getString(5) + "</td>");
						out.println("<td>" + rs.getString(6) + "</td>");
						out.println("<td>" + rs.getString(7) + "</td>");
						out.println("</tr>");

					}
					out.println("</table>");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
