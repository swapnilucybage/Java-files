package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Customer;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class LoginDao {

	public static boolean loginCustomer(Customer c) {
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from customerInfo where email=? and password=?");
			ps.setString(1, c.getCust_email());
			ps.setString(2, c.getCust_pass());
			Resultset rs = (Resultset) ps.executeQuery();
			
			if(((ResultSet) rs).next()) {
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
}
