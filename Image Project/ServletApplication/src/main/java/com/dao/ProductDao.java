package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Product;

public class ProductDao {

public static int registerProduct() {
		
		int res = 0;
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_nov_23", "root", "Lokesh@123");
			
			PreparedStatement ps = con.prepareStatement("insert into new_products values(?, ?, ?, ?)");
			ps.setString(1, null);
			ps.setString(2, Product.getName());
			ps.setFloat(3, Product.getPrice());
			ps.setBinaryStream(4, Product.getProd_img());
			
			res = ps.executeUpdate();
		}
		
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return res;
	}
	
	public static ResultSet getProductDetails() {
		
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_nov_23", "root", "Lokesh@123");
			
			PreparedStatement ps = con.prepareStatement("select * from new_products");
			
			rs = ps.executeQuery();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static ResultSet getProductDetailsById(int id) {
		
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_nov_23", "root", "Lokesh@123");
			
			PreparedStatement ps = con.prepareStatement("select * from new_products where prod_id = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return rs;
	}
}
