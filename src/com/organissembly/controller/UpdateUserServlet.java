package com.organissembly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.organissembly.bean.User;
import com.organissembly.bean.Organization;
import com.organissembly.dao.UserDao;
import com.organissembly.dao.passEncrypt;
import com.organissembly.dao.OrgDao;

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		String userRole = null;
		String userId = null;
		userId = session.getAttribute("userId").toString();
		try {
			userRole = session.getAttribute("userRole").toString();
		} catch (Exception e) {}
		
		User bean = new User();
		UserDao dao = new UserDao();
		
		String editUserId = request.getParameter("editUserId");
		String editUserEmail = request.getParameter("editUserEmail");
		String editUserPassword = request.getParameter("editUserPassword");
		String editUserFirstName = request.getParameter("editUserFirstName");
		String editUserMiddleName = request.getParameter("editUserMiddleName");
		String editUserLastName = request.getParameter("editUserLastName");
		String editUserLevel = request.getParameter("editUserLevel");

		bean.setUserId(editUserId);
		bean.setEmail(editUserEmail);

		String encPassword = passEncrypt.cryptWithMD5(editUserPassword);
		//bean.setPassword(password);
		bean.setPassword(encPassword);
		
		bean.setFirstName(editUserFirstName);
		bean.setMiddleName(editUserMiddleName);
		bean.setLastName(editUserLastName);
		bean.setUserLevel(editUserLevel);

		int status = dao.adminUpdate(bean);
		
		List<User> userList = new ArrayList<User>();
		
		if (userRole.compareTo("Student Coordinator") == 0) {
			userList = dao.adminGetAllRecords();
		}
		
		session.setAttribute("list",userList);
		
		if (userRole.compareTo("Student") == 0) {
//			RequestDispatcher rd=request.getRequestDispatcher("event_student.jsp");
//			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student Coordinator") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("user_admin.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Representative") == 0) {
//			RequestDispatcher rd=request.getRequestDispatcher("event_representative.jsp");
//			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Adviser") == 0) {
//			RequestDispatcher rd=request.getRequestDispatcher("event_adviser.jsp");
//			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
