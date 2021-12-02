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

import com.organissembly.bean.Member;
import com.organissembly.bean.Organization;
import com.organissembly.bean.User;
import com.organissembly.dao.LoginDao;
import com.organissembly.dao.MemberDao;
import com.organissembly.dao.OrgDao;

@MultipartConfig(maxFileSize = 16177215)
public class AddOrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Organization bean = new Organization();
		OrgDao dao = new OrgDao();
		
		String newOrgId = dao.getUID();
		String newOrgName = request.getParameter("orgName");
		String newOrgAbout = request.getParameter("orgAbout");
		String newOrgVision = request.getParameter("orgVision");
		String newOrgMission = request.getParameter("orgMission");
		String newOrgAdviser = request.getParameter("orgAdviser");
		String newOrgPresident = request.getParameter("orgPresident");
		String newOrgSecretary = request.getParameter("orgSecretary");
		String newOrgPro = request.getParameter("orgPro");
		InputStream inputStream = null;
        Part filePart = request.getPart("orgImage");
        if (filePart != null) {             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

		bean.setOrgId(newOrgId);
		bean.setOrgName(newOrgName);
		bean.setOrgAbout(newOrgAbout);
		bean.setOrgVision(newOrgVision);
		bean.setOrgMission(newOrgMission);
		bean.setOrgAdviserId(newOrgAdviser);
		bean.setOrgPresidentId(newOrgPresident);
		bean.setOrgSecretaryId(newOrgSecretary);
		bean.setOrgProId(newOrgPro);
		bean.setOrgImage(inputStream);
		
		int status = dao.save(bean);
		
		dao.updateUserLevel(newOrgAdviser, "Organization Adviser");
		dao.updateUserLevel(newOrgPresident, "Organization Representative");
		dao.updateUserLevel(newOrgSecretary, "Organization Representative");
		dao.updateUserLevel(newOrgPro, "Organization Representative");
		
		// Updates member table
		Member memberBean = new Member();
		MemberDao memberDao = new MemberDao();
		// Adviser
		memberBean.setUserId(newOrgAdviser);
		memberBean.setOrgId(newOrgId);

		int status1 = memberDao.isExisting(memberBean);
		if (status1 == 0) {
			status1 = memberDao.saveApprove(memberBean);
		} else {
		}
		// President
		memberBean.setUserId(newOrgPresident);
		memberBean.setOrgId(newOrgId);

		int status2 = memberDao.isExisting(memberBean);
		if (status2 == 0) {
			status2 = memberDao.saveApprove(memberBean);
		} else {
		}
		// Secretary
		memberBean.setUserId(newOrgSecretary);
		memberBean.setOrgId(newOrgId);

		int status3 = memberDao.isExisting(memberBean);
		if (status3 == 0) {
			status3 = memberDao.saveApprove(memberBean);
		} else {
		}
		// PRO
		memberBean.setUserId(newOrgPro);
		memberBean.setOrgId(newOrgId);

		int status4 = memberDao.isExisting(memberBean);
		if (status4 == 0) {
			status4 = memberDao.saveApprove(memberBean);
		} else {
		}
		
		HttpSession session=request.getSession();
		String userRole = null;
		try {
			userRole = session.getAttribute("userRole").toString();
		} catch (Exception e) {}

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
