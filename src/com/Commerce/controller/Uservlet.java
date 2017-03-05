package com.Commerce.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import java.io.*;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.AdminEnum;
import com.Commerce.bean.UserBean;
import com.Commerce.doas.UserDao;
import com.sun.glass.ui.Pixels.Format;

@WebServlet("/Uservlet")
public class Uservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
     public int randomNum(){
    	Random rand = new Random();
    	int  n = rand.nextInt(1000) + 1;
    
    	return n;
    	
    }
			 
			
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		UserBean userBean= new UserBean();  
		 AdminEnum adminenum = null;

				 String name=request.getParameter("uname");  
				 String password=request.getParameter("psw");
				 String birthDate=request.getParameter("bdate");
				 String eMail=request.getParameter("email");
				 String job=request.getParameter("job");
				 String creditNum=request.getParameter("cnum");
				 double credit=Double.parseDouble(creditNum);
				
				userBean.setFullName(name);
				userBean.setPassword(password);
				userBean.setEmail(eMail);
				userBean.setJob(job);
				userBean.setDateOfBirth(birthDate);
				userBean.setCreditNumber(credit);
			    userBean.setIsAdmin(adminenum.normal);
				userBean.setId(randomNum());
				
				UserDao userDao=new UserDao();
				int status=userDao.save(userBean);
				
				if(status>0){
					request.getSession(true).setAttribute("userData", userBean);
					out.print("<p>Record saved successfully!</p>");
					
					response.sendRedirect("Welcome");
					request.getRequestDispatcher("viewProfile.html").include(request, response);
					
				}
			  else{  
				  
		         out.println("Sorry! unable to save record");  
		         request.getRequestDispatcher("register.html").include(request, response);  
		     }  
	}

}
