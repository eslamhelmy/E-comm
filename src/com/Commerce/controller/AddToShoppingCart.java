package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.OrderBean;
import com.Commerce.bean.ProductBean;
import com.Commerce.bean.ShoppingCartBean;
import com.Commerce.bean.UserBean;
import com.Commerce.doas.OrderDao;
import com.Commerce.doas.ProductDao;
import com.Commerce.doas.ShoppingCartDao;

@WebServlet("/AddToShoppingCart")
public class AddToShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		UserBean userbean=new UserBean();
		userbean =(UserBean) request.getSession(false).getAttribute("userData");
		int userId=userbean.getId();    // user Id
		System.out.println(userId);
		
		int productId=Integer.parseInt(request.getParameter("idProduct")); // product Id
		System.out.println(productId);

	
	//this.getServletContext().getRequestDispatcher("/viewProfile.html").forward(request, response);
	ShoppingCartBean shoppCart =new ShoppingCartBean();
	shoppCart.setUserId(userId);
	shoppCart.setProductId(productId);
	
	ShoppingCartDao shoppDao=new ShoppingCartDao();
	shoppDao.addToShoppingCart(shoppCart);
	
	ProductDao prudDao=new ProductDao();
	ProductBean productObj=prudDao.getProductById(productId);
	
	OrderBean orderObj=new OrderBean();
	OrderDao orderDaoObj=new OrderDao();
	
	orderObj.setUserId(userId);
	orderObj.setProductId(productObj.getProductId());
	orderObj.setQuntity(1);
	orderObj.setImgPath(productObj.getImgPath());
	orderObj.setPrice(productObj.getPrice());
	orderObj.setProductName(productObj.getProductName());
	
	int status=orderDaoObj.addOrder(orderObj);
	
	
	
	
	if(status>0){
		//out.print("<h1> Product Added To Shopping Cart !.<h1>");
		
		request.getRequestDispatcher("Welcome").include(request, response);

	}
  else{  
	  
     out.println("Sorry! unable to add to ShoppingCart !");  
  
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
