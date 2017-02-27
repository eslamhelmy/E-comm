package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.UserBean;
import com.Commerce.doas.UserDao;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlets() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter(); 
	
		 String name=request.getParameter("uname");  
		 String password=request.getParameter("psw");
		 String fullName=request.getParameter("fname");
		// Date birthDate=request.getParameter("bdate");
		 String eMail=request.getParameter("email");
		 String address=request.getParameter("addrs");
		 String job=request.getParameter("job");
		// String creditNum=request.getParameter("cnum");
		UserBean userBean= new UserBean();
		
		userBean.setUserName(name);
		userBean.setPassword(password);
		userBean.setFullName(fullName);
		userBean.setEmail(eMail);
		userBean.setAddress(address);
		userBean.setJob(job);
		
		UserDao userDao=new UserDao();
		int status=userDao.save(userBean);
		
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
		}
	  else{  
		  
          out.println("Sorry! unable to save record");  
          request.getRequestDispatcher("register.html").include(request, response);  
      }  
		
	}

}
