package com.organissembly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.organissembly.bean.Organization;
import com.organissembly.bean.User;
import com.organissembly.dao.LoginDao;
import com.organissembly.dao.MemberDao;
import com.organissembly.dao.OrgDao;
import com.organissembly.dao.passEncrypt;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User bean = new User();
		LoginDao dao = new LoginDao();
		OrgDao orgDao = new OrgDao();
		bean.setEmail(email);

		String encPassword = passEncrypt.cryptWithMD5(password);
		//bean.setPassword(password);
		bean.setPassword(encPassword);
		
		request.setAttribute("bean",bean);
		
		boolean status = dao.validate(bean);
		
		if(status){
			/* getting all info and setting it in session */
			String userId = dao.getUserID(bean);
			String userRole = dao.getUserRole(bean);
			String firstName = dao.getFirstName(bean);
			String middleName = dao.getMiddleName(bean);
			String lastName = dao.getLastName(bean);
			String dateCreated = dao.getDateCreated(bean);
			String dateUpdated = dao.getDateUpdated(bean);
			String points = dao.getPoints(bean);
			List<String> affiliateOrgs = OrgDao.getAffiliateOrgs(userId);
			
		String orgId =	MemberDao.getOrgIdByUserId(userId);
			List<Organization> orgInfo = OrgDao.getSpecificOrganization(orgId);
			
	
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
			session.setAttribute("points",points);
			session.setAttribute("affiliateOrgs", affiliateOrgs);
			session.setAttribute("orgInfo", orgInfo);
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
			else if (userRole.compareTo("Organization Adviser") == 0) {
				RequestDispatcher rd=request.getRequestDispatcher("main_adviser.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("main_admin.jsp");
				rd.forward(request, response);
			}
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}
	}catch(Exception E){
			RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
	}
		
}//end do get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
