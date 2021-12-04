package com.organissembly.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.organissembly.bean.Event;
import com.organissembly.bean.Organization;
import com.organissembly.dao.EventDao;
import com.organissembly.dao.OrgDao;

public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String userRole = null;
		String userId = null;
		userId = session.getAttribute("userId").toString();
		try {
			userRole = session.getAttribute("userRole").toString();
		} catch (Exception e) {}
		
		Event bean = new Event();
		EventDao dao = new EventDao();
		
		List<String> getOrgId = dao.getOrgIdByUserId(userId);
		
		String newEventId = dao.getUID();
		String newEventOrgId = getOrgId.get(0);
		String newEventPostedBy = request.getParameter("eventPostedBy");
		String newEventTitle = request.getParameter("eventTitle");
		String newEventDetails = request.getParameter("eventBody");
		
		List<String> getOrgName = dao.getEventOrgName(newEventOrgId);
		String newEventOrgName = getOrgName.get(0);

		bean.setEventId(newEventId);
		bean.setEventOrgId(newEventOrgId);
		bean.setEventPostedById(newEventPostedBy);
		bean.setEventTitle(newEventTitle);
		bean.setEventDescription(newEventDetails);
		bean.setEventOrgName(newEventOrgName);

		int status = dao.save(bean);
		
		List<Event> eventList = new ArrayList<Event>();
		
		List<String> orgIdList = dao.getOrgIdByUserId(userId);
		
		if (userRole.compareTo("Student") == 0) {
			eventList = dao.getAllEnabledRecords(orgIdList);
		} else {
			eventList = dao.getAllRecords(orgIdList);
		}
		
		session.setAttribute("list",eventList);
		session.setAttribute("orgId",orgIdList);
		
		if (userRole.compareTo("Student") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("event_student.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student Coordinator") == 0) {
			//RequestDispatcher rd=request.getRequestDispatcher("organization_coordinator.jsp");
			//rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Representative") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("event_representative.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Adviser") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("event_adviser.jsp");
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
