package com.jdbc.prepared_statement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteUsingPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// step1: load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2: establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			
			//step3: created preparedStatement
			String query = "delete from employees where salary=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			//step4: get dynamic input from user.
			System.out.println("Enter Salary to delete record.");
			String salary = br.readLine();
			
			//step5: set input to parametrized query
			ps.setString(1, salary);
			
			//step 6: exucute statement
			int i = ps.executeUpdate();
			if(i==1) {
				System.out.println("Deleted");
			}
			else {
				System.out.println("Deleted multiple values");
			}
			
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
