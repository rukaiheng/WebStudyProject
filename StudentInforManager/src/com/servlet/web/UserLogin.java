package com.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.UserCollection;
import com.servlet.model.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet(description = "this is a servlet used to conform wheather the post user is in data base", urlPatterns = { "/login" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//1. first get the post parameter
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//if uername or password is empty, send a warning message to user
		if(username.isEmpty() || password.isEmpty())
		{
			request.setAttribute("errorMessage", "user name or pass word should not be null.");
			//forward to another page in server
			request.getRequestDispatcher("index.jsp").forward(request,response);
			//break
			return;
		}
		
		//using uername and password to find users in database
		UserCollection collection = new UserCollection();
		User user = collection.getUser(username, password);
		if(user == null)
		{
			//send a message to user to tell him user name or pass word is not correct.
			request.setAttribute("Nouser", "user name or pass word is not correct.");
		}
		else
		{
			System.out.println("log in the system.");
			//forword to main page
		}
	}

}
