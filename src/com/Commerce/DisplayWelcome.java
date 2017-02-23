package com.Commerce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayWelcome")
public class DisplayWelcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerBean customer;
	private PrintWriter out;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customer = (CustomerBean)request.getSession(true).getAttribute("profile");
		if(customer!=null){
			
		out = response.getWriter();
		out.println("welcome");
		out.print(customer.getName().toString());
		
		}
		
	}
	
}
