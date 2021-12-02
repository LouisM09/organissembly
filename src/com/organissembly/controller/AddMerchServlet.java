package com.organissembly.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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
public class AddMerchServlet extends HttpServlet {
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
		
		List<String> getOrgId = dao.getOrgIdByUserId(userId);
		
		String newMerchId = dao.getUID();
		String newMerchOrgId = getOrgId.get(0);
		String newMerchPostedBy = request.getParameter("merchPostedBy");
		String newMerchName = request.getParameter("merchName");
		String newMerchDescription = request.getParameter("merchDescription");
		String newMerchPrice = request.getParameter("merchPrice");
		InputStream inputStream = null;
        Part filePart = request.getPart("merchImage");
        if (filePart != null) {             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

		bean.setMerchId(newMerchId);
		bean.setMerchOrgId(newMerchOrgId);
		bean.setMerchPostedById(newMerchPostedBy);
		bean.setMerchName(newMerchName);
		bean.setMerchDescription(newMerchDescription);
		bean.setMerchPrice(newMerchPrice);
		bean.setMerchImage(inputStream);

		int status = dao.save(bean);
		
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
