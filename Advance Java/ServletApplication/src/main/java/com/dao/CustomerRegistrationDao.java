package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Customer;

public class CustomerRegistrationDao {
	public static int registerCustomer(Customer customer) {
		int result =0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			PreparedStatement ps = con.prepareStatement("insert into CustomerInfo values(?,?,?,?,?,?,?)");
			ps.setString(1, null);
			ps.setString(2, customer.getCust_name());
			ps.setString(3, customer.getCust_email());
			ps.setString(4, customer.getCust_pass());
			ps.setString(5, customer.getCust_address());
			ps.setString(6, customer.getCust_gender());
			ps.setString(7, customer.getCust_dob());
			
			result= ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean loginCustomer(Customer customer) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			
			PreparedStatement ps =  con.prepareStatement("select * from customerInfo where email=? and password=?");
			
		
			ps.setString(1, customer.getCust_email());
			ps.setString(2, customer.getCust_pass());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
//				System.out.println("Login successfull.");
				return true;
			}else {
//				System.out.println("Login again.");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ResultSet getDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			PreparedStatement ps =  con.prepareStatement("select * from customerInfo");
			
			ResultSet rs = ps.executeQuery();
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet getMyProfile(String email) {
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			
			PreparedStatement ps =  con.prepareStatement("select * from customerInfo where email=?");
			
		
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public static ResultSet searchResult(String search)
	{
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db?SSL=false","root","root");
			String query = " select * from customerInfo  where  address like '%"+search+"%' or name like '%"+search+"%'";
			
			PreparedStatement ps =  con.prepareStatement(query);
			
		
//			ps.setString(1, search);
//			ps.setString(2, search);
			
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
