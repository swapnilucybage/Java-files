package com.jdbc.prepared_statement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class selectUsingPreparedStatement {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			PreparedStatement ps = con.prepareStatement("select * from employees where salary>=?");
			
			System.out.println("Enter salary, base on which all records greater than salary will fetch.");
			int cid = Integer.parseInt(br.readLine());
			ps.setInt(1,  cid);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getInt("employeeid")+"\t"
//									+rs.getString("employeename")+"\t"
//									+rs.getString("departmentid")+"\t"
//									+rs.getString("salary")+"\t");
				
				System.out.println(rs.getInt(1)+"\t"
						+rs.getString(2)+"\t"
						+rs.getString(3)+"\t"
						+rs.getString(4)+"\t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
