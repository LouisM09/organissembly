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

import com.organissembly.bean.Event;
import com.organissembly.bean.Organization;
import com.organissembly.bean.Registrant;
import com.organissembly.bean.User;
import com.organissembly.dao.EventDao;
import com.organissembly.dao.OrgDao;
import com.organissembly.dao.RegistrantDao;
import com.organissembly.dao.UserDao;

public class AddRegistrantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		String userRole = null;
		String userId = null;
		String userName = null;
		userId = session.getAttribute("userId").toString();
		userName = session.getAttribute("fullName").toString();
		try {
			userRole = session.getAttribute("userRole").toString();
		} catch (Exception e) {}
		
		Registrant bean = new Registrant();
		RegistrantDao regDao = new RegistrantDao();
		EventDao dao = new EventDao();
		UserDao	userDao = new UserDao();
		
		List<String> getOrgId = dao.getOrgIdByUserId(userId);
		
		String newRegistrantId = regDao.getUID();
		String newRegistrantMemberId = userId;
		String newRegistrantOrgId = request.getParameter("eventOrgId");
		String newRegistrantEventId = request.getParameter("eventId");
		String newEventTitle = request.getParameter("eventTitle");

		bean.setRegistrantId(newRegistrantId);
		bean.setRegistrantMemberId(newRegistrantMemberId);
		bean.setRegistrantOrgId(newRegistrantOrgId);
		bean.setRegistrantEventId(newRegistrantEventId);
		bean.setRegistrantEventName(newEventTitle);
		bean.setRegistrantName(userName);

		int existing = 0;
		int status = regDao.isExisting(bean);
		if (status == 0) {
			status = regDao.save(bean);
			int givePoints = userDao.givePoint(userId);
			existing = 0;
		} else {
			existing = 1;
		}
		
		List<Event> eventList = new ArrayList<Event>();
		
		List<String> orgIdList = dao.getOrgIdByUserId(userId);
		
		if (userRole.compareTo("Student") == 0) {
			eventList = dao.getAllEnabledRecords(orgIdList);
		} else {
			eventList = dao.getAllRecords(orgIdList);
		}
		
		session.setAttribute("list",eventList);
		session.setAttribute("orgId",orgIdList);
		
		if (userRole.compareTo("Student") == 0 && existing == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("event_student.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student") == 0 && existing == 1) {
			RequestDispatcher rd=request.getRequestDispatcher("event_student_error.jsp");
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
