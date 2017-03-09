package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.UserBean;

/**
 * Servlet implementation class ShoppingcartServlet
 */
@WebServlet("/ShoppingcartServlet")
public class ShoppingcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingcartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		UserBean userbean=new UserBean();
		userbean =(UserBean) request.getSession(false).getAttribute("userData");
		if(userbean !=null){
			//RequestDispatcher rd2=request.getRequestDispatcher("HomeServlet");
			//rd2.include(request, response);
			RequestDispatcher rd=request.getRequestDispatcher("ShoppingCartDesign.jsp");
			rd.include(request, response);
		
		}
		else
		{
			out.print("Not member !");
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
