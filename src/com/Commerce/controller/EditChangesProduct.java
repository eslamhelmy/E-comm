package com.Commerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.ProductBean;
import com.Commerce.doas.ProductDao;

/**
 * Servlet implementation class EditChangesProduct
 */
@WebServlet("/EditChangesProduct")
public class EditChangesProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductBean product;
	private int productId;
	private String productName;
	private String productCategory;
	private String productQuantity;
	private String productPrice;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		product =(ProductBean) request.getAttribute("sendproduct");
		String id = request.getParameter("idproduct");
		productId=Integer.parseInt(id);
		productName = request.getParameter("name");
		productCategory = request.getParameter("category");
		productQuantity = request.getParameter("quantity");
		productPrice = request.getParameter("price");
		//put in pojo
		ProductBean productB=new ProductBean();
		productB.setProductId(productId);
		productB.setProductName(productName);
		productB.setPrice(Double.parseDouble(productPrice));
		productB.setQuantity(Integer.parseInt(productCategory));
//		productB.setImgPath(product.getImgPath());
//		productB.setInStock(product.getInStock());
//		productB.setDescription(product.getDescription());
		productB.setCategoryId(Integer.parseInt(productCategory));
		
		//call updateProduct
		ProductDao p=new ProductDao();
		int updateProduct = p.updateProduct(productB);
		if(updateProduct>0){
			System.out.println("edited");
			response.sendRedirect("viewProducts.jsp");
		}
		
	}

}
