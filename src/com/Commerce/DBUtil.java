package com.Commerce;

import java.sql.*;

public class DBUtil {

	private  String driver;
	private  String connectionUrl;
	private  String userName;
	private  String password;
	
	//Constractor for initialize DB Connection
	DBUtil(String driver,String connectionUrl,String userName,String password){
		
		this.driver=driver;
		this.connectionUrl=connectionUrl;
		this.userName=userName;
		this.password=password;
	}
	
	// Connection
	public  Connection getConnection(){  
		Connection con=null;  
		try{  
			Class.forName(driver);  
			con=DriverManager.getConnection(connectionUrl,userName,password);  
		}catch(Exception e){System.out.println(e);}  
		return con;  
	}

	// Retrieve data
	 public  ResultSet selectData(String sql)  {  
		   
	 		ResultSet resultSet=null;
	 		
		       try {
		    	   	Connection con = getConnection();
		    	   	Statement statement = con.createStatement();
		    	   	resultSet = statement.executeQuery(sql);
		    	   
			       } catch (SQLException e) {
			    	   	System.out.println("SQLException" + e);
			    	   	e.printStackTrace();
			              }  	 
			  return  resultSet;
		 }
	 // Insert data
	    public  int insertData(String sql,String[]values){  
		        int status=0;  
		        try{  
		            Connection con=getConnection();     
		            PreparedStatement ps=con.prepareStatement(sql);
		            
		            for (int i = 0; i < values.length; i++)
		            {
			        	  ps.setString(i+1,values[i]);                                   	  
				    }
		            status=ps.executeUpdate();
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return status;  
		    } 

	    // Update 
		public  int updateData(String sql ,String []values){  
		        int status=0;  
		        try{  
		            Connection con=getConnection();     
		            PreparedStatement ps=con.prepareStatement(sql);
		            
		            for (int i = 0; i < values.length; i++)
		            {
			        	  ps.setString(i+1,values[i]);                                   	  
				    }
		            status=ps.executeUpdate();
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return status;  
		    } 

		// Delete	 
		public  int deleteData(String sql,String key){  
			        int status=0;  
			        try{  
			            Connection con=getConnection();  
			            PreparedStatement ps=con.prepareStatement(sql); 
			            ps.setString(1,key);
			            status=ps.executeUpdate();  
			              
			            con.close();  
			        }catch(Exception e){e.printStackTrace();}  
			          
			        return status;  
			    }  








}
