package com.Commerce.doas;

import com.Commerce.DBUtil;
import com.Commerce.bean.UserBean;
import com.Commerce.dtos.*;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import java.sql.*;

public class UserDao implements UserInterface{

	private Connection con;
	private PreparedStatement ps;

	ConnectionManager connManager=new ConnectionManager();
	private int executeUpdate;


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
	


	public UserBean login(LoginReq lr){
		
		UserBean userbean=new UserBean();
		DBUtil database=new DBUtil("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
    	con = database.getConnection();

			ResultSet resultSet = database.selectData("select * from ecommerce.users");
			try {
				while(resultSet.next()){
					if(lr.getEmail().equals(resultSet.getString("Email"))&&lr.getPassword().equals(resultSet.getString("Password"))){
					
					userbean.setFullName(resultSet.getString("Full_Name"));
					userbean.setEmail(resultSet.getString("Email"));
					userbean.setDateOfBirth(resultSet.getString("Date_of_birth"));
					userbean.setPassword(resultSet.getString("Password"));
					userbean.setJob(resultSet.getString("job"));
					userbean.setCreditNumber(resultSet.getDouble("credit_card"));
					
//					lrs.setUserName(resultSet.getString("Full Name"));
					break;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return userbean;
		
		
	}

	public boolean LoginValidate(LoginReq loginrequest){
		boolean status=false;
		con=connManager.getConnection();  
		try {
			String email=loginrequest.getEmail();
			String password=loginrequest.getPassword();		
			
		    ps=con.prepareStatement( "select * from ecommerce.users where Email = ? and password= ?");
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



	public int updateUser(RegisterReq updateData) {
		DBUtil database=new DBUtil("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
    	con = database.getConnection();
    	try {
			PreparedStatement p=con.prepareStatement("update ecommerce.users set Full_Name=?,Email=?,Password=?,Date_of_birth=?,job=?,credit_card=? where ID=?");
			p.setString(1, updateData.getFullName());
			p.setString(2, updateData.getEmail());
			p.setString(3, updateData.getPassword());
			p.setString(4, updateData.getDateOfBirth());
			p.setString(5, updateData.getJob());
			p.setDouble(6, updateData.getCredit());
			p.setInt(7, updateData.getId());
			executeUpdate = p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return executeUpdate;
	}
	
	
	
	
	
}
