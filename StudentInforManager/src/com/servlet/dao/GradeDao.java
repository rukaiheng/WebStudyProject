package com.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlet.model.Grade;
import com.servlet.model.PageBean;

public class GradeDao {

	private ResultSet resultSet = null;
	private int count = 0;
	
	private String sqlStringNolimit = null;
	
	public ResultSet gadeList(Connection con, PageBean page, Grade grade)
	{
		try {
			StringBuffer sqlStringBuffer = new StringBuffer("select * from grade");
			if(grade != null)
			{
				if(!grade.getGradeName().isEmpty())
				{
					sqlStringBuffer.append(" and gradename like '%"+ grade.getGradeName() +"%'");
				}
			}
			sqlStringNolimit = sqlStringBuffer.toString();
			
			sqlStringBuffer.append(" limit ?,?");
			if(page != null)
			{
				String sqlString = sqlStringBuffer.toString().replaceFirst("and", "where");
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
		if(sqlStringNolimit != null)
		{
			try {
				String sqlString = sqlStringNolimit.replaceFirst("and", "where");
				PreparedStatement statement = con.prepareStatement(sqlString);
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					count ++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(count);
		return count;
	}
}
