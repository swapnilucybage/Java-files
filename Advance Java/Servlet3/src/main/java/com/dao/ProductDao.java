package com.dao;

import java.sql.*;

import com.model.Product;

public class ProductDao {
	public static ResultSet getDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from products");

			ResultSet rs = ps.executeQuery();
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int registerCustomer(Product p) {
		int result =0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			PreparedStatement ps = con.prepareStatement("insert into products values(?,?,?,?)");
			ps.setString(1, null);
			ps.setString(2, p.getP_name());
			ps.setString(3, p.getP_price());
			ps.setString(4, p.getP_availability());
			
			result= ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
