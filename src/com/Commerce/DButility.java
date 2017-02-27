package com.Commerce;

import java.sql.*;

public class DButility {

	// JDBC driver name and database URL
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL="jdbc:mysql://localhost/ecommerce";

	//  Database credentials
	static String USER = "root";
	static String PASS = "root";
	   
	static Connection conn=null;
	static Statement stmt=null;
	static ResultSet rs=null;
	static int UpdatedRows=0;
	static int DeletedRows=0;
	static int InsertedRows=0;
	
	//====================Open Connection=========================
	public static Connection openConnection(){
		
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			System.out.println("---------------------------------------------------------");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException|SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//------------------Execute Select Statement--------------------------
	public static ResultSet SelectQuery(Connection con,String sql){
	      //STEP 4: Execute a query
	      System.out.println(sql);
	      try {
	    	  stmt = con.createStatement();
		      rs = stmt.executeQuery(sql);

	      } catch (SQLException e) {
	    	  e.printStackTrace();
	      }
	      
	      return rs;
	}
	
	
	//------------------Execute Insert Statement--------------------------
    public static int InsertQuery(Connection con,String sql){  
          
        try{  
        	stmt=con.createStatement();
        	InsertedRows = stmt.executeUpdate(sql);

        }catch(Exception ex){ex.printStackTrace();}  
       
        return InsertedRows;  
	}
	
	//------------------Execute Delete Statement--------------------------
	public static int DeleteQuery(Connection con,String sql){  
        DeletedRows=0;
        try{  
             
            stmt =con.createStatement(); 
            
            DeletedRows=stmt.executeUpdate(sql);  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return DeletedRows;  
    }  

	//------------------Execute Update Statement--------------------------
	public static int UpdateQuery(Connection con,String sql){
		//STEP 4: Execute a query
		System.out.println("Updating tables....");
		try {
			stmt = con.createStatement();
			UpdatedRows = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UpdatedRows;
	}
	
	
	//======================Close Resources===============================
	public static void CloseResources(Connection con){
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}
		try{
			if(conn!=null){
				conn.close();
				con.close();
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		System.out.println("---------------------------------------------------------");
		System.out.println("Goodbye!");

	}

}
