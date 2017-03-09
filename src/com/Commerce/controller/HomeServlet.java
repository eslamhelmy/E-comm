package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Commerce.bean.UserBean;
import com.Commerce.bean.AdminEnum;
/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		UserBean userbean=new UserBean();
		userbean =(UserBean) request.getSession(false).getAttribute("userData");
		
		
		if(userbean !=null){
		
			String name=userbean.getFullName();
		//	System.out.println(userbean.getAdmin());

		//	if(userbean.getAdmin().equals(adminEnum.admin)){
			if(name.equals("admin")){
				//out.print("Welcome "+userbean.getFullName());
				out.print("<h4 align='right'>Welcome  "+userbean.getFullName()+"</h4>");
				out.print("<a href='LogOut'  style='float:right'><h4>logOut</h4></a><br>");
				
				//include header admin
			}
			
			else
			{
				out.print("<h4 align='right'>Welcome  "+userbean.getFullName()+"</h4>");
				out.print("<a href='LogOut'  style='float:right'><h4>logOut</h4></a><br>");
				
				//include header user
				RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
				rd.include(request, response);
			
				
			}
			
		}
		else{
			
			//include header user
			
			out.print("<h4 align='right'>Welcome Guset </h4>");
			out.print("<h4 align='left'> please sign in / sign up ! </h4>");
			
			//include header user
			RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
			rd.include(request, response);
		
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
