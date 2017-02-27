package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.UserValidate;
import com.Commerce.doas.UserDao;
import com.Commerce.dtos.LoginReq;
import com.Commerce.dtos.LoginRes;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private boolean checkEmail;
	private PrintWriter writer;
	private LoginRes loginRes;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//writer response
		writer = response.getWriter();
		LoginReq lr=new LoginReq();
		
		//receive parameters
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		//check validation and put in DTO Request
		UserValidate check=new UserValidate();
		checkEmail = check.checkEmail(email);
		if(checkEmail==true){
			lr.setEmail(email);	
			lr.setPassword(password);
		}
		else{
			while(checkEmail==false){
				break;
			}
		}
		//call login method
		
		
		loginRes = new UserDao().login(lr);
		writer.println("Welcome"+loginRes.getUserName());
			
	}

}
