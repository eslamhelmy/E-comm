package com.Commerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.doas.OrderDao;
import com.Commerce.doas.ShoppingCartDao;
import com.Commerce.doas.UserDao;


@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
//	private int deletecart;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		id = request.getParameter("id");
//		delete = UserDao.delete(Integer.parseInt(id));
//		if(delete>0){
////			System.out.println("deletedddd");
//			response.sendRedirect("displayUsers.jsp");
//		}
//		else if(delete==0){
			int deletecart = ShoppingCartDao.delete(Integer.parseInt(id));
			int deleteorder = OrderDao.delete(Integer.parseInt(id));
			int deleteuser = UserDao.delete(Integer.parseInt(id));
			if(deleteuser>0){
			response.sendRedirect("displayUsers.jsp");
		}
		else{
			response.getWriter().print("can not delete");
		}
	}

}
