package com.jdbc.concur_and_type;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * ResultSet.Type_Forward_Only :- can travel throught result set in forward direction
 * 								- this is default type of ResultSet
 * 
 * ResultSet.Type_SCROLL_INSENSITIVE:-
 * 	can travel throught result set in forward as well as backward direction
 * -After creating resultSet if some has done any modification in background
 * database changes will not get reflected in ResultSet
 * 
 * ResultSet.Type_SCROLL_SENSITIVE:-
 * 	can travel throught result set in forward as well as backward direction
 * -After creating resultSet if some has done any modification in background
 * database changes will get reflected in ResultSet
 * 
 * Result.CONCUR_READ_ONLY :- we can only read data from resultSet
 * ResultSet.CONCUR_UPDATABLE:- we can perform all CRUD operation on ResultSet
 * */

public class ResultSetComcur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","root");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery("select * from employees");
			if(rs.getConcurrency()== ResultSet.CONCUR_UPDATABLE)
			{
				rs.moveToCurrentRow();
				
				System.out.println("Enter Name of Employees:");
				String name = br.readLine();
				System.out.println("Enter DepartmentID:");
				String depId = br.readLine();
				System.out.println("Enter			 Salary:");
				String salary = br.readLine();
				
				rs.updateString(1, null);
				rs.updateString(2, name);
				rs.updateString(3, depId);
				rs.updateString(4, salary);
				
				rs.insertRow();
			}
			/*
			 * Moves the cursor to the remembered cursor
			 * usually the current row.
			 * This method has no effect if the cursor is not on the insert row.
			 * */
			rs.moveToCurrentRow();
		while(rs.next())
			{
				//Insert
				
			System.out.println(rs.getInt(1)+"\t"+
					rs.getString(2)+"\t"+
					rs.getString(3)+"\t"+
					rs.getString(4)+"\t");
				//update
//				if(rs.getString(2).equalsIgnoreCase(name))
//				{
//					rs.updateString(4, salary);
//					rs.updateRow();
//					System.out.println("Update Successfull");
//				}
//				else
//					{
//					
//						System.out.println(rs.getInt(1)+"\t"+
//								rs.getString(2)+"\t"+
//								rs.getString(3)+"\t"+
//								rs.getString(4)+"\t");
//					}
				// delete record --using concur
//				if(rs.getString(2).equalsIgnoreCase(name))
//				{
//					rs.deleteRow();
//				}
//				else
//				{
//				
//					System.out.println(rs.getInt(1)+"\t"+
//							rs.getString(2)+"\t"+
//							rs.getString(3)+"\t"+
//							rs.getString(4)+"\t");
//				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
