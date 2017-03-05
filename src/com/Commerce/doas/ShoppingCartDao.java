package com.Commerce.doas;

import java.sql.*;

import com.Commerce.bean.ShoppingCartBean;
import com.Commerce.bean.categoryBean;


public class ShoppingCartDao implements ShoppingCartInterface{
	
	private Connection con;
	ConnectionManager conMange=new ConnectionManager();
	
	public  int addToShoppingCart(ShoppingCartBean shopingCart){  
	    int status=0;  
	    try{  
	         con=conMange.getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into shopping_carts(user_id,products_ID) values(?,?)");
	        
	        ps.setInt(1,shopingCart.getUserId());
	        ps.setInt(2, shopingCart.getProductId());
	  
	        status=ps.executeUpdate();  
	        con.close();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}

	
	
	
	

}
