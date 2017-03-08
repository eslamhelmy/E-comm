package com.Commerce.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Commerce.bean.ProductBean;
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
	public int updateCategory(categoryBean cb){
		int status=0;
		//open connection
		Connection con = ConnectionManager.getConnection();
		 
		try {
			PreparedStatement ps = con.prepareStatement("update categories set category_name=?,Description=? where category_id=? ");
			ps.setString(1, cb.getCategoryName());
			ps.setString(2, cb.getCategoryDescription());
			ps.setInt(3, cb.getCategoryId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	public int deleteCategory(int id){
		int status1=0;
		int status2 = ProductDao.deleteProductByCategory(id);
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from categories where category_id=?");
			ps.setInt(1, id);
			status1=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status1;
	}
	public categoryBean getCategoryById(int id) {
		categoryBean category=new categoryBean(); 
          
	        try{  
	             con=conMange.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from categories where category_id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	category.setCategoryId(rs.getInt(1));
	            	category.setCategoryName(rs.getString(2));
	            	category.setCategoryDescription(rs.getString(3));
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return category;  
	}


}
