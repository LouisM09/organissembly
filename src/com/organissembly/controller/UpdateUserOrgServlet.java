package com.organissembly.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.organissembly.bean.Organization;
import com.organissembly.dao.MemberDao;
import com.organissembly.dao.OrgDao;

/**
 * Servlet implementation class UpdateUserOrgServlet
 */

public class UpdateUserOrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
	HttpSession session=request.getSession();
		Organization bean = new Organization();
		OrgDao dao = new OrgDao();
		String userRole = null;
		String userId = null;
		userId = session.getAttribute("userId").toString();
		String editOrgId = request.getParameter("orgId");
		String editOrgName = request.getParameter("editOrgName");
		String editOrgAbout = request.getParameter("editOrgAbout");
		String editOrgVision = request.getParameter("editOrgVision");
		String editOrgMission = request.getParameter("editOrgMission");
		
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
	
		bean.setOrgImage(inputStream);

		int status = dao.updateDetails(bean);
		
	

		try {
			userRole = session.getAttribute("userRole").toString();
		} catch (Exception e) {}

		
		List<Organization> list = new ArrayList<Organization>();

		String orgId = MemberDao.getOrgIdByUserId(userId).toString();
		
		list = OrgDao.getSpecificOrganization(orgId);
		
		if (userRole.compareTo("Student") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("userOrg_Student.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Representative") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("userOrg_Representative.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Adviser") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("userOrg_Adviser.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
