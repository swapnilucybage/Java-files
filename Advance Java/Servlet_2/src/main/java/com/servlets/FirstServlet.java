package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		name ="myServlet",
		urlPatterns = "/FirstServlet",
		/* ServletConfig:- interface
		 * per servlet we have single config object
		 * Below is use to declare variable in servletConfig scope
		 * */
		initParams = {
			@WebInitParam(name="url", value="jdbc:mysql://localhost/db"),
			@WebInitParam(name="driver", value="com.mysql.cj.jdbc.Driver")
		})

public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		
		//single parameter
		String url = config.getInitParameter("url");
		out.println("url: "+url);
		
		//multiple parameter
		Enumeration<String> paramer_name_list = config.getInitParameterNames();
		while(paramer_name_list.hasMoreElements()) {
			String pn = paramer_name_list.nextElement();
			String pv = config.getInitParameter(pn);
			out.println(pv);
		}
		
		//ServletContext 
		ServletContext context1 = getServletContext();
		context1.setAttribute("Shared_Url: ", url);
		
		out.println("Shared_url" + context1.getAttribute("Shared_Url: "));
			
		ServletContext context = getServletContext();
		out.println("Employee Name"+context.getInitParameter("employee_name"));
		out.println("Company Name"+context.getInitParameter("company_name"));
		
	}

	

}
