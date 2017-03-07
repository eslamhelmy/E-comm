package com.Commerce.doas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Commerce.bean.ProductBean;

public class ProductDao implements ProductInterface{

	ConnectionManager conMange=new ConnectionManager();
	private Connection con;
	
	
	public List<ProductBean> getProductList() {
	
		List<ProductBean> list=new ArrayList<ProductBean>();  
        
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
		ProductBean product=new ProductBean();  
          
	        try{  
	             con=conMange.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from products where product_id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	product.setProductId(rs.getInt(1));
	            	product.setProductName(rs.getString(2));
	            	product.setPrice(rs.getDouble(3));
	            	product.setQuantity(rs.getInt(4));
	            	product.setImgPath(rs.getString(5));
	            	product.setInStock(rs.getString(6));
	            	product.setDescription(rs.getString(7));
	            	product.setCategoryId(rs.getInt(8));
	            	
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return product;  
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
	public int deleteProduct(int id) {
		int status=0;
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from ecommerce.products where product_id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

		
	}
	
	 public  int UpdateProductQuantity(int productID,int newQuantity){  
	        int status=0;  
	        try{  
	        	con=conMange.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update products set Quantity=? where product_id=?");  
	            ps.setInt(1,newQuantity);  
	            ps.setInt(2,productID);  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	            
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	
	 public int updateProduct(ProductBean product){
		 int status=0;
		 Connection con = ConnectionManager.getConnection();
		 try {
			PreparedStatement ps = con.prepareStatement("update products set name=?,price=?,Quantity=?,category_id=? where product_id=?");
			ps.setString(1, product.getProductName());
			ps.setFloat(2, (float)product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setInt(4, product.getCategoryId());
			ps.setInt(5, product.getProductId());
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return status;
		 
	 }
	 
	 public ArrayList<ProductBean> SearchInProduct(String key) {
			
		 ArrayList<ProductBean> list=new ArrayList<ProductBean>();  
	        
	        try{  
	            Connection con=conMange.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from products where name LIKE ? or price LIKE ?");
	            ps.setString(1, "%" + key + "%");
	            ps.setString(2,key );
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

	 
	 
	 
	 
}
