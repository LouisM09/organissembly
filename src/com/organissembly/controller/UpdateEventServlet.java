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
import com.organissembly.dao.EventDao;
@MultipartConfig(maxFileSize = 16177215)
public class UpdateEventServlet extends HttpServlet {
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
		
		Event bean = new Event();
		EventDao dao = new EventDao();
		
		String editEventId = request.getParameter("eventId");
		String editEventPostedBy = request.getParameter("editPostedBy");
		String editEventTitle = request.getParameter("editTitle");
		String editEventDetails = request.getParameter("editBody");
		String editEventStatus = request.getParameter("editStatus");
		String editEventIsApproved = request.getParameter("editIsApproved");
		String editEventIsEnabled = request.getParameter("editIsEnabled");
		String editEventActualDate = request.getParameter("eventActualDate");
		String editEventActualTime = request.getParameter("eventActualTime");
		InputStream inputStream = null;
        Part filePart = request.getPart("editImage");
        if (filePart != null) {             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }	
		
		
		bean.setEventId(editEventId);
		bean.setEventPostedById(editEventPostedBy);
		bean.setEventTitle(editEventTitle);
		bean.setEventDescription(editEventDetails);
		bean.setEventStatus(editEventStatus);
		bean.setEventIsApproved(editEventIsApproved);
		bean.setEventIsEnabled(editEventIsEnabled);
		bean.setEventActualDate(editEventActualDate);
		bean.setEventActualTime(editEventActualTime);
		bean.setEventImage(inputStream);

		int status = dao.update(bean);
		
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
