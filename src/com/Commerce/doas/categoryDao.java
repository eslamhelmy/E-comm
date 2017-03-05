package com.Commerce.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Commerce.bean.categoryBean;

public class categoryDao  {
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
	
	
	public ArrayList<categoryBean> getCategoryList() {
		
		ArrayList<categoryBean> list=new ArrayList<categoryBean>();  
        
        try{  
            Connection con=conMange.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from categories");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	categoryBean category=new categoryBean();  
            	category.setCategoryId(rs.getInt(1));  
            	category.setCategoryName(rs.getString(2));
            	category.setCategoryDescription(rs.getString(3));
            	
                list.add(category);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
	}
	

}
