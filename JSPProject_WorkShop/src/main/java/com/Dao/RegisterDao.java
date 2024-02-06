package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.model.Customer;

public class RegisterDao {
     
	public static int registerCustomer(Customer c)
	{
		int result=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			PreparedStatement ps = con.prepareStatement("insert into customerInfo values (?,?,?,?,?,?,?)");
			
			ps.setString(1, null);
			ps.setString(2, c.getCust_name());
			ps.setString(3, c.getCust_email());
			ps.setString(4, c.getCust_pass());
			ps.setString(5, c.getCust_address());
			ps.setString(6, c.getCust_gender());
			ps.setString(7, c.getCust_dob());
			
			 result = ps.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
