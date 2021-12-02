package com.organissembly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.organissembly.bean.User;
import com.organissembly.dao.LoginDao;
import com.organissembly.dao.UserDao;
import com.organissembly.dao.passEncrypt;

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		User bean = new User();
		LoginDao dao = new LoginDao();
		
		String userid = request.getParameter("userId");
		String userrole = request.getParameter("userRole");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstName");
		String middlename = request.getParameter("middleName");
		String lastname = request.getParameter("lastName");
		String dateupdated = request.getParameter("dateUpdated");
    
		bean.setUserId(userid);
		bean.setEmail(email);
		
		String encPassword = passEncrypt.cryptWithMD5(password);
		//bean.setPassword(password);
		bean.setPassword(encPassword);
		
		bean.setFirstName(firstname);
		bean.setMiddleName(middlename);
		bean.setLastName(lastname);
		bean.setDateUpdated(dateupdated);
		request.setAttribute("bean",bean);
		
		int status = UserDao.update(bean);
		
		if (status == 1){
			/* getting all info and setting it in session */
			String userId = dao.getUserID(bean);
			String userRole = dao.getUserRole(bean);
			String firstName = dao.getFirstName(bean);
			String middleName = dao.getMiddleName(bean);
			String lastName = dao.getLastName(bean);
			String dateCreated = dao.getDateCreated(bean);
			String dateUpdated = dao.getDateUpdated(bean);
			
			HttpSession session=request.getSession();
			session.setAttribute("userId",userId);
			session.setAttribute("userRole",userRole);
			session.setAttribute("email",email);  
			session.setAttribute("password",password);
			session.setAttribute("firstName",firstName);
			session.setAttribute("middleName",middleName);
			session.setAttribute("lastName",lastName);
			session.setAttribute("dateCreated",dateCreated);
			session.setAttribute("dateUpdated",dateUpdated);
			session.setAttribute("fullName",firstName+" "+middleName+" "+lastName);
			session.removeAttribute("accountUpdateStatus");
			
			if (userRole.compareTo("Student") == 0) {
				RequestDispatcher rd=request.getRequestDispatcher("main_student.jsp");
				rd.forward(request, response);
			}
			else if (userRole.compareTo("Student Coordinator") == 0) {
				RequestDispatcher rd=request.getRequestDispatcher("main_coordinator.jsp");
				rd.forward(request, response);
			}
			else if (userRole.compareTo("Organization Representative") == 0) {
				RequestDispatcher rd=request.getRequestDispatcher("main_representative.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("main_adviser.jsp");
				rd.forward(request, response);
			}
		}
		else{
			/* getting all info and setting it in session */
			String userId = dao.getUserID(bean);
			String userRole = dao.getUserRole(bean);
			String firstName = dao.getFirstName(bean);
			String middleName = dao.getMiddleName(bean);
			String lastName = dao.getLastName(bean);
			
			HttpSession session=request.getSession();
			session.setAttribute("userId",userId);
			session.setAttribute("userRole",userRole);
			session.setAttribute("firstName",firstName);
			session.setAttribute("middleName",middleName);
			session.setAttribute("lastName",lastName);
			session.setAttribute("fullName",firstName+" "+middleName+" "+lastName);
			session.setAttribute("accountUpdateStatus", "error");
			
			if (userRole.compareTo("Student") == 0) {
				RequestDispatcher rd=request.getRequestDispatcher("main_student.jsp");
				rd.forward(request, response);
			}
			else if (userRole.compareTo("Student Coordinator") == 0) {
				RequestDispatcher rd=request.getRequestDispatcher("main_coordinator.jsp");
				rd.forward(request, response);
			}
			else if (userRole.compareTo("Organization Representative") == 0) {
				RequestDispatcher rd=request.getRequestDispatcher("main_representative.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("main_adviser.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
