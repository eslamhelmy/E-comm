package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.categoryBean;
import com.Commerce.doas.categoryDao;

/**
 * Servlet implementation class addCategoryServlet
 */
@WebServlet("/addCategoryServlet")
public class addCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		categoryBean category=new categoryBean();
		categoryDao cateDao=new categoryDao();
		
		
		String nameCateg=request.getParameter("categName");
		String disCateg=request.getParameter("categDesc");
		
		category.setCategoryName(nameCateg);
		category.setCategoryDescription(disCateg);
		
		int status=cateDao.insertCategory(category);
		if(status>0){
			out.print("<p>Category added successfully!</p>");
		}
	  else{  
		  
         out.println("Sorry! unable to add Category");  
          
     }  
		
		
		
		
	}




}
