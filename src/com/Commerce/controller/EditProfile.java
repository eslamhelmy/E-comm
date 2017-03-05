package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.UserBean;
import com.Commerce.doas.ConnectionManager;
import com.Commerce.doas.UserDao;
import com.Commerce.dtos.RegisterReq;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fullName;
	private String email;
	private String password;
	private String creditCard;
	private String dateBirth;
	private String job;
	private int updateUser=0;
	private UserBean userData;
	private int id;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//receive parameters
		PrintWriter out=response.getWriter();
		fullName = request.getParameter("fullName");
		email = request.getParameter("email");
		password = request.getParameter("password");
		creditCard = request.getParameter("creditcard");
		dateBirth = request.getParameter("dateofbirth");
		job = request.getParameter("job");

		UserBean updateData=new UserBean();
		
		updateData.setFullName(fullName);
		updateData.setEmail(email);
		updateData.setPassword(password);
		updateData.setDateOfBirth(dateBirth);
		updateData.setCreditNumber(Double.parseDouble(creditCard));
		updateData.setJob(job);
		userData =(UserBean) request.getSession(false).getAttribute("userData");
		id = userData.getId();
		updateData.setId(id);
		System.out.println(id);
		
		//updateData
		UserDao us=new UserDao();
		updateUser = us.updateUser(updateData);

		if(updateUser>0){

			request.getSession(true).setAttribute("userData", updateData);

			//response.sendRedirect("viewProfile.jsp");
			out.print("Your Data Updated !");
			
		}

		else{
			response.getWriter().println("error in updating data");
			
		}
		



}
}