package com.servlet.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.servlet.dao.GradeDao;
import com.servlet.model.PageBean;
import com.servlet.util.DBUtil;
import com.servlet.util.JsonUtil;
import com.servlet.util.ResponseUtil;

/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		
		DBUtil dbutil = new DBUtil();
		Connection con =  dbutil.getConnection();
		
		//get result set
		GradeDao grade = new GradeDao();
		ResultSet resultSet = grade.gadeList(con, pageBean);
		
		//change the result set to json array
		JSONArray jsonArray = JsonUtil.getJsonArrayFromResultSet(resultSet);
		int count = grade.gradeCount(con);
		
		dbutil.disConnection();
		
		//we should send json object to browser(easyui use this object to initalize it's data grid)
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", count);
		
		ResponseUtil.WriteJsonObject(response, jsonObject);
	}
}
