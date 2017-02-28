package com.Commerce.doas;

import com.Commerce.DBUtil;
import com.Commerce.bean.UserBean;
import com.Commerce.dtos.*;

import java.sql.*;

public class UserDao implements UserInterface{

	private Connection con;
	private ResultSet resultSet;
	private PreparedStatement ps;
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
	         con=getConnection();  
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
	
//	Connection con=null;
//	public  Connection getConnection(){  
//	      
//	    try{  
//	        Class.forName("com.mysql.jdbc.Driver");  
//	        con=DriverManager.getConnection("jdbc:mysql://localhost/ecommerce","root","admin");  
//	    }catch(Exception e){System.out.println(e);}  
//	    return con;  
//	} 
	

//private PreparedStatement statement;

//	public  int save(UserBean userBean){  
//	    int status=0;  
//	    try{  
////	        Connection con=getConnection();
//	    	database=new DBUtil("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ecommerce", "root", "Root");
//	    	con = database.getConnection();
//	        PreparedStatement ps=con.prepareStatement(  
//	"insert into Users(userName,password,Full_name,Date_of_birth,Email,credit_number,job) values(?,?,?,?,?,?,?,?)");
//
//	        ps.setInt(1,1);
//	        ps.setString(2,userBean.getUserName()); 
//	        ps.setString(3, userBean.getPassword());
//	        ps.setString(4, userBean.getFullName());
//	        ps.setDate(5, userBean.getDateOfBirth());
//	        ps.setString(6,userBean.getEmail());
//	        //ps.setString(7, userBean.getCreditNumber());
//	        ps.setString(7,"1000");
//	        ps.setString(8, userBean.getJob());
//	    
//	        status=ps.executeUpdate();  
//	    }catch(Exception e){System.out.println(e);}  
//	    return status;  
//	}  
	public LoginRes login(LoginReq lr){
		LoginRes lrs=new LoginRes();
		DBUtil database=new DBUtil("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ecommerce", "root", "Root");
    	con = database.getConnection();
    	
			resultSet = database.selectData("select * from ecommerce.users");
			try {
				while(resultSet.next()){
					if(lr.getEmail().equals(resultSet.getString("Email"))&&lr.getPassword().equals(resultSet.getString("Password"))){
					
					lrs.setUserName(resultSet.getString("Full Name"));
					break;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return lrs;
		
		
	}
	public boolean LoginValidate(LoginReq loginrequest){
		boolean status=false;
		con=getConnection();  
		try {
			String email=loginrequest.getEmail();
			String password=loginrequest.getPassword();		
			
		    ps=con.prepareStatement( "select * from Users where Email = ? and password= ?");
			ps.setString(1,email);	
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();  
			status=rs.next();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		return status;
	}
	
	
	
	
	
}
