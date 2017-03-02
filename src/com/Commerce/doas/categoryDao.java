package com.Commerce.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Commerce.bean.categoryBean;

public class categoryDao {
	private Connection con;
	ConnectionManager conMange=new ConnectionManager();
	
	public  int insertCategory(categoryBean category){  
	    int status=0;  
	    try{  
	         con=conMange.getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into categories(category_name,Description) values(?,?)");

	        
	        ps.setString(1,category.getCategoryName()); 
	        ps.setString(2,category.getCategoryDescription());
	   
	        status=ps.executeUpdate();  
	        con.close();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	
	
	

}
