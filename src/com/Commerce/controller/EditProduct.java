package com.Commerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.ProductBean;
import com.Commerce.doas.ProductDao;

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
	private ProductBean productById;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		id = request.getParameter("id");
			System.out.println("id"+id);
		//make object from ProductDao to use deleteById method
				ProductDao product=new ProductDao();
				productById = product.getProductById(Integer.parseInt(id));
				
				request.setAttribute("sendproduct", productById);
				request.getRequestDispatcher("editProduct.jsp").forward(request, response);

	}

}
