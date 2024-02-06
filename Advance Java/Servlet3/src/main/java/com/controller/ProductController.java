package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.model.Product;

public class ProductController extends HttpServlet{
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
//		out.println("<h1>Welcome to servlet demo</h1>");
//		out.println("Name: <input type='text'>");
		
//		String p_id= request.getParameter("productId");
		String p_name= request.getParameter("productName");
		String p_price= request.getParameter("productPrice");
		String p_avail= request.getParameter("productAvailability");
//		String p_image= request.getParameter("productImage");
		
		Product p = new Product();
		p.setP_name(p_name);
		p.setP_availability(p_avail);
		p.setP_price(p_price);
		
		int result = ProductDao.registerCustomer(p);
		
		if(result ==1)
		{
			out.println("Record Inserted");
		}else
		{
			out.println("Try Again");
		}
		response.sendRedirect("Homepage.html");
		
		
		
	}
}
