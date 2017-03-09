package com.Commerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.categoryBean;
import com.Commerce.doas.categoryDao;

@WebServlet("/EditCategory")
public class EditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
	private int categoryId;
	private categoryBean categoryBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		categoryId = Integer.parseInt(id);
		System.out.println("ghghh"+categoryId);
		categoryDao cd=new categoryDao();
		categoryBean = cd.getCategoryById(categoryId);
		request.setAttribute("category", categoryBean);
		request.getRequestDispatcher("editCategory.jsp").forward(request, response);
//		response.sendRedirect("editCategory.jsp");
	}

}
