package com.model;

public class Customer {

	private static int cust_id;
	private static String cust_name, cust_email, cust_gend, cust_add, cust_pass, cust_dob;
	public static int getCust_id() {
		return cust_id;
	}
	public static void setCust_id(int cust_id) {
		Customer.cust_id = cust_id;
	}
	public static String getCust_name() {
		return cust_name;
	}
	public static void setCust_name(String cust_name) {
		Customer.cust_name = cust_name;
	}
	public static String getCust_email() {
		return cust_email;
	}
	public static void setCust_email(String cust_email) {
		Customer.cust_email = cust_email;
	}
	public static String getCust_gend() {
		return cust_gend;
	}
	public static void setCust_gend(String cust_gend) {
		Customer.cust_gend = cust_gend;
	}
	public static String getCust_add() {
		return cust_add;
	}
	public static void setCust_add(String cust_add) {
		Customer.cust_add = cust_add;
	}
	public static String getCust_pass() {
		return cust_pass;
	}
	public static void setCust_pass(String cust_pass) {
		Customer.cust_pass = cust_pass;
	}
	public static String getCust_dob() {
		return cust_dob;
	}
	public static void setCust_dob(String cust_dob) {
		Customer.cust_dob = cust_dob;
	}
}
