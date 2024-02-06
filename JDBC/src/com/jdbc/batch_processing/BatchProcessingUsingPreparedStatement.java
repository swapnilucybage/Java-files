package com.jdbc.batch_processing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchProcessingUsingPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2nd step:-
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","root");
			//3rd Step:- Create Statement
			PreparedStatement ps = con.prepareStatement("insert into employees values(?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter count of Employees");
			int count = Integer.parseInt(br.readLine());
			for(int i=0;i<count;i++)
			{
				System.out.println("Enter EmpId,Name,DepartmentID & Salary");
//				String empid = br.readLine();
				String name = br.readLine();
				String depId = br.readLine();
				String salary = br.readLine();
				
				//step5: set input to parametrized query
				ps.setString(1, null);
				ps.setString(2, name);
				ps.setString(3, depId);
				ps.setString(4, salary);
				
				// Add query to batch
				ps.addBatch();
			}
			
			int arr[] = ps.executeBatch();
			System.out.println("Output:-");
			for (int i : arr) {
				System.out.println(i);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
