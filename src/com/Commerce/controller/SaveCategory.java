package com.Commerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.categoryBean;
import com.Commerce.doas.categoryDao;

@WebServlet("/SaveCategory")
public class SaveCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
	private int categoryId;
	private String name;
	private String desc;
	private int updateCategory;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		categoryId = Integer.parseInt(id);
		System.out.println("ssssssss"+categoryId);
		name = request.getParameter("name");
		desc = request.getParameter("desc");
		
		categoryBean cb=new categoryBean();
		cb.setCategoryId(categoryId);
		cb.setCategoryName(name);
		cb.setCategoryDescription(desc);
		
		categoryDao cd=new categoryDao();
		updateCategory = cd.updateCategory(cb);
		if(updateCategory>0){
			response.sendRedirect("viewCategories.jsp");
		}
		else{
			response.getWriter().println("can not update category");
		}
	}

}
