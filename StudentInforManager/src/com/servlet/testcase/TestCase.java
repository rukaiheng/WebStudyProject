package com.servlet.testcase;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;

import com.servlet.dao.UserCollection;
import com.servlet.util.DBUtil;

class TestCase {

	@Test
	void test() {
		
		//using DBUtil to connect mysql
		DBUtil dbutil  = new DBUtil();
		
		dbutil.getConnection();
		
		dbutil.disConnection();	
	}
	
	@Test
	void testuserCollection()
	{
		UserCollection collection = new UserCollection();
		ArrayList<com.servlet.model.User> users = collection.getUsers();
		if(users.size() > 0)
		{
			System.out.println("there is" + users.size() + "users");
		}
	}
}
