package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;

@WebServlet("/HomePageController")
public class HomePageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		ResultSet rs = null;
		
		rs = CustomerDao.getDetails();

		out.print("<a href=\"LogOutController\"> Logout </a>");

		out.println("<table border=1px>");
		out.println("<tr>" + 
						"<td>Id</td>" + 
						"<td>Name</td>" + 
						"<td>Price</td>" + 
						"<td>Availability</td>"+
						"<td>Images</td>"
					+"</tr>");
		try {
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td>");
				
				//Image retrival
				byte[] imageData = rs.getBytes("image_data");
				out.println("<td>" + rs.getString(5) + "</td>");
//				out.println("<td>" + rs.getString(6) + "</td>");
//				out.println("<td>" + rs.getString(7) + "</td>");
				out.println("</tr>");

			}
			out.println("</table>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.println("<a href=\"ProductsRegistration.html\" > Add Products </a>");
		
		
        
        // Write the image data to a file
//        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\swapnilu\\Downloads\\file1.jpg")) {
//            fos.write("C:\\Users\\swapnilu\\Downloads\\file1.jpg");
//            System.out.println("Image retrieved and saved successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

	}

}
