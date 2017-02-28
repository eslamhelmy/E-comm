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
	"insert into Users values(?,?,?,?,?,?,?,?)");

	        ps.setInt(1,userBean.getId());
	        ps.setString(2,userBean.getPassword()); 
	        ps.setString(3, userBean.getFullName());
	        ps.setDate(4,java.sql.Date.valueOf(userBean.getDateOfBirth()));
	        ps.setString(5,userBean.getEmail());
	        ps.setString(6, userBean.getJob());
	        ps.setString(7,userBean.getIsAdmin().toString());
	        ps.setDouble(8, userBean.getCreditNumber());
	      
	    
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	
	
	
	
	
}
