package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import com.model.Customers;


@WebServlet("/CustomerDao")
public class CustomerDao {
	
	public static boolean loginCustomer(Customers customer) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shop","root","root");
			
			PreparedStatement ps =  con.prepareStatement("select * from customer where c_email=? and c_password=?");
			
		
			ps.setString(1, customer.getC_email());
			ps.setString(2, customer.getC_pass());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Login successfull.");
				return true;
			}else {
				System.out.println("Login again.");
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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shop","root","root");
			PreparedStatement ps =  con.prepareStatement("select * from products");
			
			ResultSet rs = ps.executeQuery();
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
