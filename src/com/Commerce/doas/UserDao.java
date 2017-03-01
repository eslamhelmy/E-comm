package com.Commerce.doas;

import com.Commerce.DBUtil;
import com.Commerce.bean.UserBean;
import com.Commerce.dtos.*;

import java.sql.*;

public class UserDao implements UserInterface{

	private Connection con;
	private PreparedStatement ps;
	ConnectionManager connManager=new ConnectionManager();

	public  int save(UserBean userBean){  
	    int status=0;  
	    try{  
	         con=connManager.getConnection();  
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
	        con.close();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	public boolean LoginValidate(LoginReq loginrequest){
		boolean status=false;
		con=connManager.getConnection();  
		try {
			String email=loginrequest.getEmail();
			String password=loginrequest.getPassword();		
			
		    ps=con.prepareStatement( "select * from Users where Email = ? and password= ?");
			ps.setString(1,email);	
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();  
			status=rs.next();
			
			 con.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		return status;
	}
	
	
	
	
	
}
