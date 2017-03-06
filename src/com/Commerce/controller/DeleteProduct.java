package com.Commerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.doas.ProductDao;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int deleteProduct;
	private String id;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			id = request.getParameter("id");
		int productId=Integer.parseInt(id);
		//make object from ProductDao to use deleteById method
		ProductDao product=new ProductDao();
		deleteProduct = product.deleteProduct(productId);
		if(deleteProduct>0){
			System.out.println("deleted ");
			response.sendRedirect("viewProducts.jsp");
		}
		else{
			response.getWriter().println("can not delete");
		}
	}

}
