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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*	//writer response
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
			*/
		
		/////////////////////////////////////////////////
		out = response.getWriter();
		LoginReq lr=new LoginReq();
		//receive parameters
	    email = request.getParameter("email");
		password = request.getParameter("password");
		lr.setEmail(email);	
		lr.setPassword(password);
		UserDao ud=new UserDao();
		boolean statusLogin=ud.LoginValidate(lr);
		if(statusLogin){
			out.print("Welcome");
			
		}else
		{
			out.println("Not register");
		}
		
		/////////////////////////////////////////////////////
	}

}
