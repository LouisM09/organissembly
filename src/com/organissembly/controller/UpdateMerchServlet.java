package com.organissembly.controller;

import java.io.FileInputStream;
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

import com.organissembly.bean.Merch;
import com.organissembly.dao.MerchDao;

@MultipartConfig(maxFileSize = 16177215)
public class UpdateMerchServlet extends HttpServlet {
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
		
		Merch bean = new Merch();
		MerchDao dao = new MerchDao();
		
		String editMerchId = request.getParameter("merchId");
		String editMerchPostedBy = request.getParameter("editPostedBy");
		String editMerchTitle = request.getParameter("editTitle");
		String editMerchDetails = request.getParameter("editBody");
		String editMerchPrice = request.getParameter("editPrice");
		String editMerchIsApproved = request.getParameter("editIsApproved");
		String editMerchIsEnabled = request.getParameter("editIsEnabled");
		InputStream inputStream = null;
        Part filePart = request.getPart("editImage");
        if (filePart != null) {             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

		bean.setMerchId(editMerchId);
		bean.setMerchPostedById(editMerchPostedBy);
		bean.setMerchName(editMerchTitle);
		bean.setMerchDescription(editMerchDetails);
		bean.setMerchPrice(editMerchPrice);
		bean.setMerchIsApproved(editMerchIsApproved);
		bean.setMerchIsEnabled(editMerchIsEnabled);
		bean.setMerchImage(inputStream);


		int status = dao.update(bean);
		
		List<Merch> merchList = new ArrayList<Merch>();
		
		List<String> orgIdList = dao.getOrgIdByUserId(userId);
		
		if (userRole.compareTo("Student") == 0) {
			merchList = dao.getAllEnabledRecords(orgIdList);
		} else {
			merchList = dao.getAllRecords(orgIdList);
		}
		
		session.setAttribute("list",merchList);
		session.setAttribute("orgId",orgIdList);
		
		if (userRole.compareTo("Student") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("merch_student.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Student Coordinator") == 0) {
			//RequestDispatcher rd=request.getRequestDispatcher("organization_coordinator.jsp");
			//rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Representative") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("merch_representative.jsp");
			rd.forward(request, response);
		}
		else if (userRole.compareTo("Organization Adviser") == 0) {
			RequestDispatcher rd=request.getRequestDispatcher("merch_adviser.jsp");
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
