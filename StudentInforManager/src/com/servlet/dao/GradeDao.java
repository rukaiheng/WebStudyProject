package com.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlet.model.PageBean;

public class GradeDao {

	public ResultSet gadeList(Connection con, PageBean page)
	{
		ResultSet resultSet = null;
		try {
			String sqlString = "select * from grade limit ?, ?";
			if(page != null)
			{
				PreparedStatement prepareStatement = con.prepareStatement(sqlString);
				prepareStatement.setInt(1, page.getStart());
				prepareStatement.setInt(2, page.getRows());
				resultSet = prepareStatement.executeQuery();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			resultSet = null;
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public int gradeCount(Connection con)
	{
		int count = 0;
		try {
			String sqlString = "select count(*) as total from grade";
			PreparedStatement statement = con.prepareStatement(sqlString);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				count = resultSet.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
