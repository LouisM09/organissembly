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

public class AddUserServlet extends HttpServlet {
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
		
		String addUserId = dao.getUID();
		String addUserEmail = request.getParameter("addUserEmail");
		String addUserPassword = request.getParameter("addUserPassword");
		String addUserFirstName = request.getParameter("addUserFirstName");
		String addUserMiddleName = request.getParameter("addUserMiddleName");
		String addUserLastName = request.getParameter("addUserLastName");
		String addUserLevel = request.getParameter("addUserLevel");
		String addUserIdNumber = request.getParameter("addUserId");
		String addUserYear = request.getParameter("addUserYear");
		String addUserSection = request.getParameter("addUserSection");

		bean.setUserId(addUserId);
		bean.setEmail(addUserEmail);

		String encPassword = passEncrypt.cryptWithMD5(addUserPassword);
		//bean.setPassword(password);
		bean.setPassword(encPassword);
		
		bean.setFirstName(addUserFirstName);
		bean.setMiddleName(addUserMiddleName);
		bean.setLastName(addUserLastName);
		bean.setUserLevel(addUserLevel);
		bean.setNumber(addUserIdNumber);
		bean.setYear(addUserYear);
		bean.setSection(addUserSection);

		int status = dao.adminSave(bean);
		
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
