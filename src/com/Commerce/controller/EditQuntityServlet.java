package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.doas.OrderDao;

/**
 * Servlet implementation class EditQuntityServlet
 */
@WebServlet("/EditQuntityServlet")
public class EditQuntityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQuntityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		int productId=Integer.parseInt(request.getParameter("idProduct"));
		int newQuantity=Integer.parseInt(request.getParameter("quntity"));
		
		OrderDao orderdao=new OrderDao();
		int status=orderdao.UpdateQuantity(productId, newQuantity);
		if(status>0){
			//out.print("<h1> Product Added To Shopping Cart !.<h1>");
			request.getRequestDispatcher("ShoppingCart.jsp").include(request, response);

		}
	  else{  
		  
	     out.println("Sorry! unable to add to update !");  
	  
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
