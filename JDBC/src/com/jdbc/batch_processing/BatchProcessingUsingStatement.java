package com.jdbc.batch_processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessingUsingStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2nd step:-
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			//3rd Step:- Create Statement
			Statement stmt = con.createStatement();
			
			stmt.addBatch("insert into employees values(null,'Ramu',109,45000.00)");
			stmt.addBatch("insert into employees values(null,'Saluu',110,69000.00)");
			stmt.addBatch("delete from employees where salary>=50000.00");
			stmt.addBatch("update employees set salary=100000 where name='Ramu'");
			
			int arr[]= stmt.executeBatch();
			System.out.println("Output:");
			for (int i : arr) {
				System.out.println(i);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
