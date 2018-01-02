package com.servlet.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	static public JSONArray getJsonArrayFromResultSet(ResultSet resultSet) 
	{
		JSONArray JsonArray = new JSONArray();
		ResultSetMetaData metaData;
		try {
			metaData = resultSet.getMetaData();
			int columnCount =  metaData.getColumnCount(); //return the coloumn count of result set
			
			while(resultSet.next())
			{
				JSONObject jsonObject = new JSONObject();
				for(int i = 1; i <= columnCount; ++i)
				{
					jsonObject.put(metaData.getColumnName(i), resultSet.getObject(i));
				}
				JsonArray.add(jsonObject);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JsonArray;
	}
}
