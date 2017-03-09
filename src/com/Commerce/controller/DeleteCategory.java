package com.Commerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.doas.categoryDao;

@WebServlet("/DeleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int categoryId=Integer.parseInt(id);
		categoryDao cd=new categoryDao();
		int deleteCategory = cd.deleteCategory(categoryId);
		if(deleteCategory>0){
			System.out.println("deleeeeeeeeted");
			response.sendRedirect("viewCategories.jsp");
		}
		else{
			response.getWriter().println("errrrrrrrrrrror");
		}
	
	}

}
