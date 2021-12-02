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

import com.organissembly.bean.Organization;
import com.organissembly.dao.OrgDao;


public class OrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		String userRole = null;
		try {
			userRole = session.getAttribute("userRole").toString();
		} catch (Exception e) {
			
			List<Organization> list = new ArrayList<Organization>();
			
			OrgDao dao = new OrgDao();
			list = dao.getAllEnabledRecords();
			
			session.setAttribute("list",list);
			
			RequestDispatcher rd=request.getRequestDispatcher("organization.jsp");
			rd.forward(request, response);
		}
		
		OrgDao dao = new OrgDao();

		List<Organization> list = new ArrayList<Organization>();
		
		if (userRole.compareTo("Student Coordinator") == 0) {
			list = dao.getAllRecords();
		} else {
			list = dao.getAllEnabledRecords();
		}
		
		session.setAttribute("list",list);
		
		if (userRole.compareTo("Student") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("organization_student.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student Coordinator") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("organization_coordinator.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Representative") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("organization_representative.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Adviser") == 0) {
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
