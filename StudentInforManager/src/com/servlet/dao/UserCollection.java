package com.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.servlet.model.User;
import com.servlet.util.DBUtil;

/*
 * this file can get all users in database and find the user with given username and password
 */
public class UserCollection {
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<User> getUsers()
	{
		//query users in database
		DBUtil dbutil = new DBUtil();
		Connection connection =  dbutil.getConnection();
		
		 try {
			Statement statement =  connection.createStatement();
			ResultSet result =  statement.executeQuery("select * from user");
			
			while(result.next())
			{
				int id = result.getInt("id");
				String username = result.getString("username");
				String password = result.getString("password");
				User newuser = new User();
				newuser.setId(id);
				newuser.setUsername(username);
				newuser.setPassword("password");
				users.add(newuser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public User getUser(String username, String password)
	{
		//first get the connection
		DBUtil dbutil = new DBUtil();
		Connection connection =  dbutil.getConnection();
		User targetUser = null;
		String sqlString = "select * from user where username = ? and password = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result =  statement.executeQuery();
			while(result.next())
			{
				targetUser = new User();
				targetUser.setId(result.getInt("id"));
				targetUser.setUsername(result.getString("username"));
				targetUser.setPassword(result.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return targetUser;
	}
}
