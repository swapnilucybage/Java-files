package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Customer;

public class CustomerDao {

	public static int registerCustomer() {
		
		int res = 0;
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_nov_23", "root", "Lokesh@123");
			
			PreparedStatement ps = con.prepareStatement("insert into CustomerInfo values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, null);
			ps.setString(2, Customer.getCust_name());
			ps.setString(3, Customer.getCust_email());
			ps.setString(4, Customer.getCust_pass());
			ps.setString(5, Customer.getCust_add());
			ps.setString(6, Customer.getCust_gend());
			ps.setString(7, Customer.getCust_dob());
			
			res = ps.executeUpdate();
		}
		
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return res;
	}
	
	public static boolean loginCustomer() {
		
		boolean res = false;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_nov_23", "root", "Lokesh@123");
			
			PreparedStatement ps = con.prepareStatement("select * from CustomerInfo where email = ? and password = ?");
			ps.setString(1, Customer.getCust_email());
			ps.setString(2, Customer.getCust_pass());
			
			ResultSet rs = ps.executeQuery();
			res = rs.next();
		}
		
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return res;
	}
	
	public static ResultSet getCustomerDetails() {
		
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_nov_23", "root", "Lokesh@123");
			
			PreparedStatement ps = con.prepareStatement("select * from CustomerInfo");
			
			rs = ps.executeQuery();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static ResultSet getCustomerDetailsByEmail(String email) {
		
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_nov_23", "root", "Lokesh@123");
			
			PreparedStatement ps = con.prepareStatement("select * from CustomerInfo where email = ?");
			ps.setString(1, email);
			
			rs = ps.executeQuery();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static ResultSet searchCustomer(String query) {
		
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_nov_23", "root", "Lokesh@123");
			
			PreparedStatement ps = con.prepareStatement("select * from CustomerInfo where name=? or email=? or address=?");
			ps.setString(1, query);
			ps.setString(2, query);
			ps.setString(3, query);
			
			rs = ps.executeQuery();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return rs;
	}
}
