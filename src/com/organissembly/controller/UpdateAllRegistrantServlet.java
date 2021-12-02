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

import com.organissembly.bean.Registrant;
import com.organissembly.dao.RegistrantDao;

public class UpdateAllRegistrantServlet extends HttpServlet {
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
		
		Registrant bean = new Registrant();
		RegistrantDao dao = new RegistrantDao();
		
		List<Registrant> registrantList = new ArrayList<Registrant>();
		
		List<String> orgIdList = dao.getOrgIdByUserId(userId);

		bean.setRegistrantOrgId(orgIdList.get(0));

		int status = dao.updateAll(bean);
		
		if (userRole.compareTo("Organization Representative") == 0) {
			registrantList = dao.getAllRecords(orgIdList);
		}
		
		session.setAttribute("list",registrantList);
		session.setAttribute("orgId",orgIdList);
		
		if (userRole.compareTo("Student") == 0) {
//			RequestDispatcher rd=request.getRequestDispatcher("event_student.jsp");
//			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student Coordinator") == 0) {
			//RequestDispatcher rd=request.getRequestDispatcher("organization_coordinator.jsp");
			//rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Representative") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("registrant_representative.jsp");
			rd.forward(request, response);
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
