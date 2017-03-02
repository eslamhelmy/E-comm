package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.ProductBean;
import com.Commerce.bean.categoryBean;
import com.Commerce.doas.ProductDao;
import com.Commerce.doas.categoryDao;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getPathImg(String pathImg){
    	String replaceString=pathImg.replace('\\','/');
		 String split[]  = replaceString.split("/");
		 String s = "img/";
		 String ss=split[split.length-1];
		 s = s.concat(ss);
		 return s;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		ProductBean product=new ProductBean();
		ProductDao productDao=new ProductDao();
		
		String nameProduct=request.getParameter("productName");
		float price=Float.parseFloat(request.getParameter("price"));
		int quant=Integer.parseInt(request.getParameter("quantity"));
		String img=getPathImg(request.getParameter("image"));
		String inStock=request.getParameter("stock");
		String descrption=request.getParameter("productDesc");
		int cateID=Integer.parseInt(request.getParameter("categId"));
		
		
		
		
		product.setProductName(nameProduct);
		product.setPrice(price);
		product.setQuantity(quant);
		product.setImgPath(img);
		product.setInStock(inStock);
		product.setDescription(descrption);
		product.setCategoryId(cateID);
		
		
		int status=productDao.addProduct(product);
		if(status>0){
			out.print("<p>Product added successfully!</p>");
		}
	  else{  
		  
         out.println("Sorry! unable to add Category");  
          
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
