package com.bloodBank.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
  
	private static final String URL="jdbc:mysql://localhost:3306/bloodbank" ;
	
	private static final String DRIVER="com.mysql.jdbc.Driver" ;
	
	private static final String USERNAME="bloodBank"  ;
	
	private static final String PASSWORD="bloodBank";
	
	private static Connection connection = null ;
	
	
	public static Connection openConnection() {
		
		if(connection!=null)
		{
			return connection;
		}
		else
		{
			try
			{
			Class.forName(DRIVER);
			
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//System.out.println("Connection Successfull");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return connection ;
		}
	}
	
}
