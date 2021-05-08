package com.cts.creditcard.util;
import java.io.*;
import java.sql.*;
import java.util.Properties;
import com.cts.creditcard.exception.CreditCardAdminSystemException;

public class DBConnectionManager {
	private static Connection con=null;
	private static DBConnectionManager instance;
	private DBConnectionManager() throws CreditCardAdminSystemException{
		
	}
	public static DBConnectionManager getInstance() throws CreditCardAdminSystemException{
	
		if(instance==null)
			 instance=new DBConnectionManager();
		
		
		return instance;
	
	}
	public Connection getConnection() throws IOException,SQLException,ClassNotFoundException{
		Properties pros=new Properties();
		FileInputStream fis=new FileInputStream("database.properties");
		Class.forName(pros.getProperty("driver"));
		con=DriverManager.getConnection(pros.getProperty("url"),pros.getProperty("username"),pros.getProperty("password"));
		fis.close();
		return con;
		
	}
	

}
