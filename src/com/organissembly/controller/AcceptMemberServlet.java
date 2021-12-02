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


public class AcceptMemberServlet extends HttpServlet {
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
		//bean.setDateJoined(newMemberDateJoined);

		int status = dao.update(bean);
		
		HttpSession session=request.getSession();
		String userRole = null;
		try {
			userRole = session.getAttribute("userRole").toString();
		} catch (Exception e) {}

		List<Member> list = new ArrayList<Member>();
		
		String orgId = dao.getOrgIdByUserId(newMemberUserId);
		list = dao.getAllApplicantRecords(orgId);
		
		session.setAttribute("list",list);
		
		if (userRole.compareTo("Organization Adviser") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("applicant_adviser.jsp");
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
