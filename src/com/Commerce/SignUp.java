package com.Commerce;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String password;
	private boolean checkName;
	private boolean checkEmail;
	private DBUtil connect;
	private int updateData;
	private String gender;
	private String address;
	private boolean checkAddress;
	private String birthday;
	private boolean checkBirthday;
	@Override
	public void init() throws ServletException {
	    connect=new DBUtil("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mydata", "root", "Root");
	    if(connect!=null)
		connect.getConnection();
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//receive parameters
				name = request.getParameter("name");
				checkName = new UserValidate().checkName(name);
				email = request.getParameter("email");
				checkEmail = new UserValidate().checkEmail(email);
				password = request.getParameter("password");
				gender = request.getParameter("gender");
				address = request.getParameter("address");
				checkAddress = new UserValidate().checkAddress(address);
				birthday = request.getParameter("birthday");
				checkBirthday = new UserValidate().checkBrithDate(birthday);
				//validate data
				if(checkName==false||checkEmail==false||checkAddress==false||checkBirthday==false){
					request.getRequestDispatcher("Error.html").forward(request, response);
				}
				else{
				//put in Customer pojo
				CustomerBean customer=new CustomerBean();
				customer.setName(name);
				customer.setEmail(email);
				customer.setPassword(password);
				customer.setAddress(address);
				customer.setBrithday(birthday);
				customer.setGender(gender);
				//connect to Db
				updateData = connect.insertData("insert into customer values('"+name+"','"+email+"','"+password+"','"+address+"','"+birthday+"','"+gender+"')");
				if(updateData>0){
					request.getSession().setAttribute("profile", customer);			
					response.sendRedirect("DisplayWelcome");
				}
				else{
					response.sendRedirect("Error.html");
				}
	
	}

	}
}
