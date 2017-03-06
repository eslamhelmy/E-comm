package com.Commerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.ProductBean;
import com.Commerce.doas.ProductDao;

@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
	private ProductBean productBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		id = request.getParameter("id");
		
		//make object from ProductDao to use getProductById() method
		ProductDao product =new ProductDao();
		productBean = product.getProductById(Integer.parseInt(id));
		//put productBean in the request
		request.setAttribute("productData", productBean);
		request.getRequestDispatcher("productData.jsp").forward(request, response);
	}

}
