package com.jdbc.prepared_statement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateUsingPreparedStatementExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// step1: load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2: establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			
			//step3: created preparedStatement
			String query = "update employees set salary=? where employeename=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			//step4: get dynamic input from user.
			System.out.println("Enter EmployeeName to update salary.");
			String name = br.readLine();
			String salary = br.readLine();
			
			//step5: set input to parametrized query
			ps.setString(1, salary);
			ps.setString(2, name);
			
			//step 6: exucute statement
			int i = ps.executeUpdate();
			if(i==1) {
				System.out.println("updated");
			}
			else {
				System.out.println("not updated");
			}
			
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
