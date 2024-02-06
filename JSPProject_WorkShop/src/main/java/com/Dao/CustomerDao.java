package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Customer;

public class CustomerDao {
	public static Customer getMyProfile(String email) {
		ResultSet rs=null;
		Customer c = new Customer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			
			PreparedStatement ps =  con.prepareStatement("select * from customerInfo where email=?");
			
		
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				c.setCust_address(rs.getString("address"));
				c.setCust_name(rs.getString("name"));
				c.setCust_dob(rs.getString("date_of_birth"));
				c.setCust_id(rs.getInt("cust_id"));
				c.setCust_email(rs.getString("email"));
				c.setCust_pass(rs.getString("password"));
				c.setCust_gender(rs.getString("gender"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
		
	}
	
	
	public static ResultSet getSearchDetails(String search) {
		ResultSet rs=null;
//		Customer c = new Customer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			String query = "select * from customerInfo where email like '%"+search+"%' or name like '%"+search+"%' or address like '%"+search+"%'";
			PreparedStatement ps =  con.prepareStatement(query);
			
		
//			ps.setString(1, search);
			
			rs = ps.executeQuery();
			
//			if(rs.next()) {
//				c.setCust_address(rs.getString("address"));
//				c.setCust_name(rs.getString("name"));
//				c.setCust_dob(rs.getString("date_of_birth"));
//				c.setCust_id(rs.getInt("cust_id"));
//				c.setCust_email(rs.getString("email"));
//				c.setCust_pass(rs.getString("password"));
//				c.setCust_gender(rs.getString("gender"));
//			}
			return rs;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
}
