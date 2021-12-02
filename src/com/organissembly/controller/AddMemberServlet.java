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

import com.organissembly.bean.Member;
import com.organissembly.bean.Organization;
import com.organissembly.bean.User;
import com.organissembly.dao.LoginDao;
import com.organissembly.dao.MemberDao;
import com.organissembly.dao.OrgDao;


public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Member bean = new Member();
		MemberDao dao = new MemberDao();
		
		String newMemberUserId = request.getParameter("member_userId");
		String newMemberOrgId = request.getParameter("member_orgId");
		//String newMemberDateJoined = request.getParameter("member_dateJoined");

		bean.setUserId(newMemberUserId);
		bean.setOrgId(newMemberOrgId);

		int existing = 0;
		int status = dao.isExisting(bean);
		if (status == 0) {
			status = dao.save(bean);
			existing = 0;
		} else {
			existing = 1;
		}
		
		HttpSession session=request.getSession();
		String userRole = null;
		try {
			userRole = session.getAttribute("userRole").toString();
		} catch (Exception e) {}

		List<Organization> list = new ArrayList<Organization>();
		
		OrgDao daoOrg = new OrgDao();
		
		if (userRole.compareTo("Student Coordinator") == 0) {
			list = daoOrg.getAllRecords();
		} else {
			list = daoOrg.getAllEnabledRecords();
		}
		
		session.setAttribute("list",list);
		
		if (userRole.compareTo("Student") == 0 && existing == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("organization_student.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student") == 0 && existing == 1) {
			RequestDispatcher rd=request.getRequestDispatcher("organization_student_error.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student Coordinator") == 0 && existing == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("organization_coordinator.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Representative") == 0 && existing == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("organization_representative.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Adviser") == 0 && existing == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("organization_adviser.jsp");
			rd.forward(request, response);
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
