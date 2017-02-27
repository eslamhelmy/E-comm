package com.Commerce.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.UsersBean;
import com.Commerce.doas.UsersDao;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersBean users = new UsersBean();
	     users.setEmail(request.getParameter("id"));
	     users.setPassword(request.getParameter("pwd"));
	     users.setPassword(request.getParameter("pwd"));
	     users.setPassword(request.getParameter("pwd"));
	     users.setPassword(request.getParameter("pwd"));
	     users.setPassword(request.getParameter("pwd"));
	     users.setPassword(request.getParameter("pwd"));
	     
	     UsersBean Result = UsersDao.login(users);
	     
	     if(Result.isValid()){
	    	 System.out.print("Logged in ");
	    	 //-----open loggedInPage------
	     }else{
	    	 System.out.print("not Logged in ");
	    	 //-----error page-------------
	    	 RequestDispatcher rd= request.getRequestDispatcher("Error.html");
	    	 rd.include(request, response);
	     }
	}

}
