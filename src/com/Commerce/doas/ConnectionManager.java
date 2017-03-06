package com.Commerce.doas;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	public static Connection getConnection(){  
		Connection con=null;
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost/ecommerce","root","Root");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	} 
	


}
