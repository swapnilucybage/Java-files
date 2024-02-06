package com.jdbc.prepared_statement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertUsingPreparedStatement {
	
	public static void main(String[] args) {
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// step1: load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2: establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			
			//step3: created preparedStatement
			String query = "Insert into employees values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			//step4: get dynamic input from user.
			System.out.println("Enter EmpId,Name,DepartmentID & Salary");
//			String empid = br.readLine();
			String name = br.readLine();
			String depId = br.readLine();
			String salary = br.readLine();
			
			//step5: set input to parametrized query
			ps.setString(1, null);
			ps.setString(2, name);
			ps.setString(3, depId);
			ps.setString(4, salary);
			
			//step 6: exucute statement
			int i = ps.executeUpdate();
			if(i==1) {
				System.out.println("Inserted");
			}
			else {
				System.out.println("Try again");
			}
			
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}
