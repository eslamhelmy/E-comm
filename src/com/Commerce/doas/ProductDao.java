package com.Commerce.doas;

import java.sql.*;
import java.util.ArrayList;

import com.Commerce.bean.ProductBean;
import com.Commerce.bean.UserBean;

public class ProductDao implements ProductInterface{

	ConnectionManager conMange=new ConnectionManager();
	private Connection con;
	
	
	public ArrayList<ProductBean> getProductList() {
	
		ArrayList<ProductBean> list=new ArrayList<ProductBean>();  
        
        try{  
            Connection con=conMange.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from products");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	ProductBean product=new ProductBean();  
            	product.setProductId(rs.getInt(1));  
            	product.setProductName(rs.getString(2));
            	product.setPrice(rs.getFloat(3));
            	product.setQuantity(rs.getInt(4));
            	product.setImgPath(rs.getString(5));
            	product.setInStock(rs.getString(6));
            	product.setDescription(rs.getString(7));
            	product.setCategoryId(rs.getInt(8));
                list.add(product);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
	}

	@Override
	public ProductBean getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public int addProduct(ProductBean product) {
		
		    int status=0;  
		    try{  
		         con=conMange.getConnection();  
		        PreparedStatement ps=con.prepareStatement(  
		"insert into products(name,price,Quantity,ImagePath,In_stock,Description,category_id) values(?,?,?,?,?,?,?)");

		        ps.setString(1,product.getProductName());
		        ps.setFloat(2,(float)product.getPrice()); 
		        ps.setInt(3, product.getQuantity());
		        ps.setString(4,product.getImgPath());
		        ps.setString(5,product.getInStock());
		        ps.setString(6, product.getDescription());
		        ps.setInt(7,product.getCategoryId());
		        
		        status=ps.executeUpdate();  
		        con.close();  
		    }catch(Exception e){System.out.println(e);}  
		    return status;  
		
	}

	@Override
	public void editProduct(ProductBean product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(ProductBean product) {
		// TODO Auto-generated method stub
		
	}
	

}
