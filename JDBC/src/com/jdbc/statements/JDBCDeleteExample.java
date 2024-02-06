package com.jdbc.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDeleteExample {
	 public static void main(String[] args) {
		
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			 
			 Statement stmt = con.createStatement();
				
				String sql_query = "delete from employees where Salary>60000.00 ";
				//step 4 :- Execute Statement
				int i = stmt.executeUpdate(sql_query);
				if(i==1)
				{
					System.out.println("Delete Only One Value");
				}else
				{
					System.out.println("Delete Multiple Values");
				}
				}
			catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
			}
				
	 }
}

