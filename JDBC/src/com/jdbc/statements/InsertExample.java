package com.jdbc.statements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 * BufferedReader: Class from java.io
 * 					used to read dynamic input from keyboard
 * 					It takes help of InputStreamReader class from java.io package
 * 					to connect to input device
 * Constructor:--
 * BufferedReader(Object InputStreamReader)
 * methods:--
 * readLine():- it will read data line by line in string type
 * */


public class InsertExample {
	public static void main(String[] args) {
		
		
		try {
//			InputStreamReader in = new InputStreamReader(System.in);
			
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Enter EmpId,Name,DepartmentID & Salary");
			String empid = br.readLine();
			String name = br.readLine();
			String depId = br.readLine();
			String salary = br.readLine();
			
//			int id = Integer.parseInt(br.readLine());
			
		//1st step:-load driver and create object of it
			Class.forName("com.mysql.cj.jdbc.Driver");
		//2nd step:-
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
		//3rd Step:- Create Statement
		Statement stmt = con.createStatement();
		
		String sql_query = "insert into employees values('"+empid+"','"+name+"','"+depId+"','"+salary+"')";
		//step 4 :- Execute Statement
		int i = stmt.executeUpdate(sql_query);
		if(i==1)
		{
			System.out.println("Inserted");
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
