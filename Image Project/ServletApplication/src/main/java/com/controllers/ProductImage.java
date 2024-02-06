package com.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;

@WebServlet("/ProductImage")
public class ProductImage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet rs = ProductDao.getProductDetailsById(Integer.parseInt(request.getParameter("id")));
		
		try {
			if (rs.next()) {
			    InputStream inputStream = rs.getBinaryStream(4);
			    int bytesRead;
			    byte[] buffer = new byte[4096];

			    while ((bytesRead = inputStream.read(buffer)) != -1) {
			        response.getOutputStream().write(buffer, 0, bytesRead);
			    }
			    
			    PrintWriter out = response.getWriter();
			   out.print(buffer);
			    
			} 
  	 
  	 else {
			    response.getWriter().write("Image not found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
