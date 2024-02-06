package com.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.dao.ProductDao;

@WebServlet("/ViewProducts")
public class ViewProducts extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		ResultSet rs = ProductDao.getProductDetails();	
		
        try {
			
        	PrintWriter out = response.getWriter();
			
			out.println("<h1>------------------Product Details------------------</h1>");
			
			out.println("<table cellspacing=\"4px\" cellpadding=\"5px\">");
			out.println("<tr><td>Product Name</td><td>Product Price</td><td>Product Image</td></tr>");
			while(rs.next()) {
				
				out.print("<tr>");
				out.print("<td>" + rs.getString(2) + "</td>");
				out.print("<td>" + rs.getString(3) + "</td>");
				out.print("<td> <a href ='ProductImage?id=" + rs.getInt(1) + "'>View Product Image </a></td>");
				out.print("</tr>");
			}
        	
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
