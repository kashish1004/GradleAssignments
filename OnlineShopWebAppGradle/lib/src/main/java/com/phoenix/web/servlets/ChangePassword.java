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
import javax.servlet.http.HttpSession;

import com.phoenix.daos.LoginDao;
import com.phoenix.daos.LoginDaoImpl;
import com.phoenix.data.User;
import com.phoenix.services.LoginService;
import com.phoenix.services.LoginServiceImpl;
import com.phoenix.web.exceptions.ServiceException;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePass")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if(session!=null) {
			try {
				String newPass = request.getParameter("newpasswd");
				String cfNewPass = request.getParameter("cfmnewpasswd");
				String usname  = (String)session.getAttribute("user");
				if(newPass.equals(cfNewPass)) {
					LoginDao loginDao = new LoginDaoImpl();
					User user = loginDao.getUserbyId(usname);
					user.setPassword(newPass);
					LoginService ls = new LoginServiceImpl();
					String message = ls.changePassword(user);
					System.out.println(message);
					session.invalidate();
					response.sendRedirect("login.html");
					}
				else {
					out.println("<p style = 'color:red'>Enter Same Password in both fields.</p>");
					RequestDispatcher rd = request.getRequestDispatcher("change.jsp");
					rd.include(request, response);
				}
			}
			catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			out.println("<h3 style = 'color:red'>Session expired</h3>");
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
