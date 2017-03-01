package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.Commerce.bean.UserBean;
import com.Commerce.doas.UserDao;
import com.Commerce.dtos.LoginReq;
import com.Commerce.dtos.LoginRes;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String email;
	private String password;
	private boolean checkEmail;
	private PrintWriter out;
	private LoginRes loginRes;

	private UserBean userbean;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////////////////////////////////////////////////
		out = response.getWriter();
		LoginReq lr=new LoginReq();
		//receive parameters
	    email = request.getParameter("email");
		password = request.getParameter("password");
		lr.setEmail(email);	
		lr.setPassword(password);
		UserDao ud=new UserDao();
		userbean = ud.login(lr);
		if(userbean.getFullName()!=null){
			request.getSession().setAttribute("userData", userbean);
			response.sendRedirect("Welcome");
		}
		else{
			out.println("Not Registered");
		}
//		boolean statusLogin=ud.LoginValidate(lr);
//		if(statusLogin){
//			
//			out.print("Welcome");
//			
//		}else
//		{
//			out.println("Not register");
//		}
//		
		/////////////////////////////////////////////////////
	}

}
