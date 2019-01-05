package com.nanowebhub.utils;

import java.sql.*;



public class connection {
  private static final String  Driver = "org.h2.Driver";
  private static final String  Url = "jdbc:h2:tcp://localhost/~/JspServlet";
  private static final String  Userid = "sa";
  private static final String  password = "";
  public static  Connection con = null;
  
  static {
	  
	  try {
		  System.out.println("Driver Connection..."); 	  
 	  // STEP 1: Register JDBC driver 
    	Class.forName(Driver);    	
     // //STEP 2: Open a connection 
        System.out.println("Connecting to database..."); 
        con = DriverManager.getConnection(Url,Userid,password); 
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	    
  }

public static Connection getCon() {
	return con;
}
  
  
  
  
}
