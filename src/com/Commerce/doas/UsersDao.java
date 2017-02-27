package com.Commerce.doas;

import com.Commerce.bean.UsersBean;

import java.io.Serializable;
import java.sql.*;
import com.Commerce.*;

public class UsersDao implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
     static ResultSet rs = null;
     
     public static UsersBean login(UsersBean bean) {
    		
         //preparing some objects for connection 
         //Statement stmt = null;    
	
         String email = bean.getEmail();    
         String password = bean.getPassword();   
	    
         String searchQuery ="select * from ecommerce.users where Email='"+ email+ "' AND password='"+ password+ "'";
	    
		    
	      try 
	      {
	         //connect to DB 
	         currentCon = DButility.openConnection();
	         ResultSet rs=DButility.SelectQuery(currentCon,searchQuery);
	         	        
	        
		       
	         // if user does not exist set the isValid variable to false
	         bean.setValid(false);
	         
	        	// int coloumnsNum= rs.getMetaData().getColumnCount();
	 			while(rs.next()){
	 				bean.setId(Integer.parseInt(rs.getString("ID")));   
		  	        bean.setPassword(rs.getString("password")); 
		  	        bean.setFullName(rs.getString("Full Name"));
		  	        bean.setDateOfBirth(rs.getDate("Date_of_birth"));
		  	        bean.setEmail(rs.getString("Email"));
		  	        //bean.setCreditNumber(rs.getString("credit_number"));
		  	        bean.setJob(rs.getString("job"));
		  	        bean.setStatus(rs.getString("Status"));
	 				bean.setAdmin(rs.getBoolean("is_admin"));
	 				System.out.println("done");
	 				System.out.println(bean.getPassword());
	 			
	            bean.setValid(true);
	            }
	      } 
	      catch (Exception ex) 
	      {
	         System.out.println("Log In failed: An Exception has occurred! " + ex);
	      } 
		    
	      //some exception handling
	      finally 
	      {
	    	  DButility.CloseResources(currentCon);
	         if (rs != null)	{
	            try {
	               rs.close();
	            } catch (Exception e) {}
	               rs = null;
	            }
		/*
	         if (stmt != null) {
	            try {
	               stmt.close();
	            } catch (Exception e) {}
	               stmt = null;
	            }
		*/
	         if (currentCon != null) {
	            try {
	               currentCon.close();
	            } catch (Exception e) {
	            }
	
	            currentCon = null;
	         }
	      }
	      return bean;
      }	
  
     public static UsersBean Register(UsersBean bean) {
 		
         //preparing some objects for connection 
         //Statement stmt = null;    
	
         String email = bean.getEmail();    
         String password = bean.getPassword();   
         
         String creditNumber = bean.getCreditNumber();
         Date dateOfBirth = bean.getDateOfBirth();
         String fullName = bean.getFullName();
         String job = bean.getJob();
         String status = bean.getStatus();
         String insertQuery ="INSERT INTO `ecommerce`.`users` (`password`, `Full Name`, `Date_of_birth`, `Email`, `job`, `Status`, `is_admin` , `credit_card` ) VALUES ('"+password+"', '"+fullName+"', '"+dateOfBirth+"', '"+email+"', '"+job+"', '"+status+"', 'normal' , '"+creditNumber+"')";
	    
		    
	      try 
	      {
	         //connect to DB 
	         currentCon = DButility.openConnection();
	         int done=DButility.InsertQuery(currentCon,insertQuery);
	         	        
	        
		       
	         // if user does not exist set the isValid variable to false
	         if (done==1) 
	         {
	            bean.setValid(true);
	            return bean;
	         } 
		        
	         //if user exists set the isValid variable to true
	         else 
	         {
	        	
	            bean.setValid(false);
	            return bean;
	         }
	      } 
	      catch (Exception ex) 
	      {
	         System.out.println("Log In failed: An Exception has occurred! " + ex);
	      } 
		    
	      //some exception handling
	      finally 
	      {
	    	  DButility.CloseResources(currentCon);
	         if (rs != null)	{
	            try {
	               rs.close();
	            } catch (Exception e) {}
	               rs = null;
	            }
		/*
	         if (stmt != null) {
	            try {
	               stmt.close();
	            } catch (Exception e) {}
	               stmt = null;
	            }
		*/
	         if (currentCon != null) {
	            try {
	               currentCon.close();
	            } catch (Exception e) {
	            }
	
	            currentCon = null;
	         }
	      }
	      return bean;
      }	

	
}
