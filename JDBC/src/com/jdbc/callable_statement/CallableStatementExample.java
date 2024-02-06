package com.jdbc.callable_statement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.CallableStatement;
/*
 * callable statement: Inerface from java.sql
 * connection interface hold factory method for callableStatement interface public callableStatement preparecall()
 * 
 * 
 * */

public class CallableStatementExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
			
			CallableStatement cs = (CallableStatement) con.prepareCall("call updateemployee(?, ?)");
			
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Enter name and update salary:");
			cs.setString(1, br.readLine());
			cs.setString(2, br.readLine());
			
			int i = cs.executeUpdate();
			if(i > 0) {
				System.out.println("Update successful");
			}else {
				System.out.println("Update unsuccessful");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
