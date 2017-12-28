package com.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * file description: this file defines a class to connect to mysql database as a util class
 */
public class DBUtil {
	
	private String url = "jdbc:mysql://localhost:3306/studentinforManager";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "root";
	
	private Connection connection = null;
	
	public Connection getConnection()
	{
			try {
				Class.forName(jdbcDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
	}
	
	public void disConnection()
	{
		if(connection != null)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

