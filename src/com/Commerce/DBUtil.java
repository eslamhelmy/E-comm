package com.project;

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









}
