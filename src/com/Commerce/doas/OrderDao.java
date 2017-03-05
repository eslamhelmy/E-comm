package com.Commerce.doas;

import java.sql.*;
import java.util.ArrayList;

import com.Commerce.bean.OrderBean;
import com.Commerce.bean.ProductBean;


public class OrderDao  implements OrderInterface{

	ConnectionManager conMange=new ConnectionManager();
	private Connection con;
	
	public int addOrder(OrderBean order) {
		
	    int status=0;  
	    try{  
	         con=conMange.getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into orders(user_id,product_id,Quantity,Image,Price,ProductName) values(?,?,?,?,?,?)");

	        ps.setInt(1,order.getUserId());
	        ps.setFloat(2,order.getProductId()); 
	        ps.setInt(3, order.getQuntity());
	        ps.setString(4,order.getImgPath());
	        ps.setDouble(5,order.getPrice());
	        ps.setString(6,order.getProductName());
	        
	        
	        status=ps.executeUpdate();  
	        con.close();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	
}
	
	public ArrayList<OrderBean> getOrder() {
		
		ArrayList<OrderBean> list=new ArrayList<OrderBean>();  
        
        try{  
            Connection con=conMange.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from orders");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	OrderBean order=new OrderBean();  
            	
            	order.setUserId(rs.getInt(2));  
            	order.setProductId(rs.getInt(3));
            	order.setQuntity(rs.getInt(4));
            	order.setImgPath(rs.getString(5));
            	order.setPrice(rs.getDouble(6));
            	order.setProductName(rs.getString(7));
            
            	list.add(order);
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
	}
	
	public static int delete(int id){
		int status=0;
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from ecommerce.orders where user_id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
}
