package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.UserBean;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBean userData;
	private PrintWriter writer;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		writer = response.getWriter();
		userData = (UserBean) request.getSession(false).getAttribute("userData");
		if(userData!=null){
			writer.println("welcome   "+userData.getFullName());
			request.getRequestDispatcher("viewProfile.html").include(request, response);
			request.getRequestDispatcher("productsView.jsp").include(request, response);

		}
		else{
			response.sendRedirect("register.html");
		}
	}

}
