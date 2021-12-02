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

import com.organissembly.bean.Announcement;
import com.organissembly.bean.Organization;
import com.organissembly.dao.AnnouncementDao;
import com.organissembly.dao.OrgDao;

public class AddAnnouncementServlet extends HttpServlet {
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
		
		Announcement bean = new Announcement();
		AnnouncementDao dao = new AnnouncementDao();
		
		List<String> getOrgId = dao.getOrgIdByUserId(userId);
		
		String newAnnounId = dao.getUID();
		String newAnnounOrgId = getOrgId.get(0);
		String newAnnounPostedBy = request.getParameter("announcementPostedBy");
		String newAnnounTitle = request.getParameter("announcementTitle");
		String newAnnounDetails = request.getParameter("announcementBody");
		
		List<String> getOrgName = dao.getAnnounOrgName(newAnnounOrgId);
		String newAnnounOrgName = getOrgName.get(0);

		bean.setAnnouncementId(newAnnounId);
		bean.setAnnouncementOrgId(newAnnounOrgId);
		bean.setAnnouncementPostedById(newAnnounPostedBy);
		bean.setAnnouncementTitle(newAnnounTitle);
		bean.setAnnouncementBody(newAnnounDetails);
		bean.setAnnouncementOrgName(newAnnounOrgName);

		int status = dao.save(bean);
		
		List<Announcement> announcementList = new ArrayList<Announcement>();
		
		List<String> orgIdList = dao.getOrgIdByUserId(userId);
		
		if (userRole.compareTo("Student") == 0) {
			announcementList = dao.getAllEnabledRecords(orgIdList);
		} else {
			announcementList = dao.getAllRecords(orgIdList);
		}
		
		session.setAttribute("list",announcementList);
		session.setAttribute("orgId",orgIdList);
		
		if (userRole.compareTo("Student") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("announcement_student.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student Coordinator") == 0) {
			//RequestDispatcher rd=request.getRequestDispatcher("organization_coordinator.jsp");
			//rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Representative") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("announcement_representative.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Adviser") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("announcement_adviser.jsp");
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
