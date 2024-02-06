package com.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.model.Product;

@WebServlet("/RegisterProductController")
public class RegisterProductController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String img_path = "E:\\CTEP-November 2023\\Advanced_Java_01-02-2023\\images\\" + request.getParameter("prod_img");
		System.out.println(img_path);
		File file = new File(img_path);
        FileInputStream fis = new FileInputStream(file);
		
		Product.setName(request.getParameter("prod_name"));
		Product.setPrice(Float.parseFloat(request.getParameter("prod_price")));
		Product.setProd_img(fis);
		
		int res = ProductDao.registerProduct();
		
		System.out.println(res);
	}

}
