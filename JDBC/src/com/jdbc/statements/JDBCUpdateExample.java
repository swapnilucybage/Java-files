package com.jdbc.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCUpdateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			 
			 Statement stmt = con.createStatement();
				
				String sql_query = "update employees SET EmployeeName = 'Sharukh', Salary = 86000.00 where EmployeeID = 3 ";
				//step 4 :- Execute Statement
				int i = stmt.executeUpdate(sql_query);
				if(i==1)
				{
					System.out.println("Updated");
				}else
				{
					System.out.println("Try Again");
				}
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}	
	 }
}

