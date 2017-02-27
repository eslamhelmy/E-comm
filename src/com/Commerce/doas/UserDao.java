package com.Commerce.doas;

import com.Commerce.bean.UserBean;
import java.sql.*;

public class UserDao {
	Connection con=null;
	public  Connection getConnection(){  
	      
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost/ecommerce","root","admin");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	} 

	public  int save(UserBean userBean){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into Users(userName,password,Full_name,Date_of_birth,Email,credit_number,job) values(?,?,?,?,?,?,?)");  
	        ps.setString(2,userBean.getUserName()); 
	        ps.setString(3, userBean.getPassword());
	        ps.setString(4, userBean.getFullName());
	        ps.setDate(5, userBean.getDateOfBirth());
	        ps.setString(6,userBean.getEmail());
	        //ps.setString(7, userBean.getCreditNumber());
	        ps.setString(8, userBean.getJob());
	    
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	
	
	
	
	
}
