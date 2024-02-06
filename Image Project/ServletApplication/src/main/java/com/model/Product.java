package com.model;

import java.io.InputStream;

public class Product {

	static int prod_id;
	static String name;
	static float price;
	static InputStream prod_img;
	public static int getProd_id() {
		return prod_id;
	}
	public static void setProd_id(int prod_id) {
		Product.prod_id = prod_id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Product.name = name;
	}
	public static float getPrice() {
		return price;
	}
	public static void setPrice(float price) {
		Product.price = price;
	}
	public static InputStream getProd_img() {
		return prod_img;
	}
	public static void setProd_img(InputStream img) {
		Product.prod_img = img;
	}
}
