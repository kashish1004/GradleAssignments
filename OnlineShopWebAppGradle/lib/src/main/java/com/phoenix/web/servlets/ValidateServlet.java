package com.phoenix.web.servlets;
/* Author kashish.jain@stltech.in
 * Creation Date - 06-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phoenix.web.models.LoginBean;

/**
 * Servlet implementation class ValidateServlet
 * @author kashish.jain@stltech.in
 */
@WebServlet("/LoginS")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("username");
		String password = request.getParameter("passwd");
		LoginBean obj = new LoginBean();
		request.setAttribute("ob", obj);
		//setting parameters
		obj.setUsername(uname);
		obj.setPassword(password);
		
		if(obj.isValid()) {
			//dispatching to welcome servlet
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
		else {
			//error message to user
			PrintWriter ob = response.getWriter();
			ob.println("<p style = 'color:red'>Invalid username or password. Login again</p>");
			//asking user to login again
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
