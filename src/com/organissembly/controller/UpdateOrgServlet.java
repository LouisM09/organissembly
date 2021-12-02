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
public class UpdateOrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Organization bean = new Organization();
		OrgDao dao = new OrgDao();
		
		String editOrgId = request.getParameter("orgId");
		String editOrgName = request.getParameter("editOrgName");
		String editOrgAbout = request.getParameter("editOrgAbout");
		String editOrgVision = request.getParameter("editOrgVision");
		String editOrgMission = request.getParameter("editOrgMission");
		String editOrgAdviser = request.getParameter("editOrgAdviser");
		String editOrgPresident = request.getParameter("editOrgPresident");
		String editOrgSecretary = request.getParameter("editOrgSecretary");
		String editOrgPro = request.getParameter("editOrgPro");
		String oldOrgAdviser = request.getParameter("oldOrgAdviser");
		String oldOrgPresident = request.getParameter("oldOrgPresident");
		String oldOrgSecretary = request.getParameter("oldOrgSecretary");
		String oldOrgPro = request.getParameter("oldOrgPro");
		String editOrgIsEnabled = request.getParameter("editIsEnabled");
		InputStream inputStream = null;
        Part filePart = request.getPart("editOrgImage");
        if (filePart != null) {             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

		bean.setOrgId(editOrgId);
		bean.setOrgName(editOrgName);
		bean.setOrgAbout(editOrgAbout);
		bean.setOrgVision(editOrgVision);
		bean.setOrgMission(editOrgMission);
		bean.setOrgAdviserId(editOrgAdviser);
		bean.setOrgPresidentId(editOrgPresident);
		bean.setOrgSecretaryId(editOrgSecretary);
		bean.setOrgProId(editOrgPro);
		bean.setIsEnabled(editOrgIsEnabled);
		bean.setOrgImage(inputStream);

		int status = dao.update(bean);
		
		dao.updateUserLevel(oldOrgAdviser, "Organization Adviser");
		dao.updateUserLevel(oldOrgPresident, "Student");
		dao.updateUserLevel(oldOrgSecretary, "Student");
		dao.updateUserLevel(oldOrgPro, "Student");
		
		dao.updateUserLevel(editOrgAdviser, "Organization Adviser");
		dao.updateUserLevel(editOrgPresident, "Organization Representative");
		dao.updateUserLevel(editOrgSecretary, "Organization Representative");
		dao.updateUserLevel(editOrgPro, "Organization Representative");
		
		// Updates member table
		Member memberBean = new Member();
		MemberDao memberDao = new MemberDao();
		
		// DELETES OLD
		// Adviser
		memberBean.setUserId(oldOrgAdviser);
		memberBean.setOrgId(editOrgId);

		int status1 = memberDao.isExisting(memberBean);
		if (status1 == 1) {
			if (editOrgAdviser.compareTo(oldOrgAdviser)!=0) {
				status1 = memberDao.delete(memberBean);
			}
		} else {
		}
		// President
		memberBean.setUserId(oldOrgPresident);
		memberBean.setOrgId(editOrgId);

		int status2 = memberDao.isExisting(memberBean);
		if (status2 == 1) {
			if (editOrgPresident.compareTo(oldOrgPresident)!=0) {
				status2 = memberDao.delete(memberBean);
			}
		} else {
		}
		// Secretary
		memberBean.setUserId(oldOrgSecretary);
		memberBean.setOrgId(editOrgId);

		int status3 = memberDao.isExisting(memberBean);
		if (status3 == 1) {
			if (editOrgSecretary.compareTo(oldOrgSecretary)!=0) {
				status3 = memberDao.delete(memberBean);
			}
		} else {
		}
		// PRO
		memberBean.setUserId(oldOrgPro);
		memberBean.setOrgId(editOrgId);

		int status4 = memberDao.isExisting(memberBean);
		if (status4 == 1) {
			if (editOrgPro.compareTo(oldOrgPro)!=0) {
				status4 = memberDao.delete(memberBean);
			}
		} else {
		}
		
		// ADDS NEW
		// Adviser
		memberBean.setUserId(editOrgAdviser);
		memberBean.setOrgId(editOrgId);

		int status5 = memberDao.isExisting(memberBean);
		if (status5 == 0 && editOrgAdviser.isEmpty() == false) {
			status5 = memberDao.saveApprove(memberBean);
		} else {
		}
		// President
		memberBean.setUserId(editOrgPresident);
		memberBean.setOrgId(editOrgId);

		int status6 = memberDao.isExisting(memberBean);
		if (status6 == 0 && editOrgPresident.isEmpty() == false) {
			status6 = memberDao.saveApprove(memberBean);
		} else {
		}
		// Secretary
		memberBean.setUserId(editOrgSecretary);
		memberBean.setOrgId(editOrgId);

		int status7 = memberDao.isExisting(memberBean);
		if (status7 == 0 && editOrgSecretary.isEmpty() == false) {
			status7 = memberDao.saveApprove(memberBean);
		} else {
		}
		// PRO
		memberBean.setUserId(editOrgPro);
		memberBean.setOrgId(editOrgId);

		int status8 = memberDao.isExisting(memberBean);
		if (status8 == 0 && editOrgPro.isEmpty() == false) {
			status8 = memberDao.saveApprove(memberBean);
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
