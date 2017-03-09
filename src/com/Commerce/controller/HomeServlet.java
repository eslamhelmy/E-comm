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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	     //   rd.include(request, response);
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		AdminEnum adminEnum=null;
		if(session !=null){
			UserBean userbean=(UserBean) session.getAttribute("userData");
			
		System.out.println(userbean.getAdmin());
			if(userbean.getAdmin().equals(adminEnum.admin)){
				out.print("Welcome "+userbean.getFullName());
				//include header admin
			}
			
			else
			{
				out.print("Welcome "+userbean.getFullName());
				//include header user
			}
		}
		else{
			out.print("Welcome Guset");
			//include header user
			
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
