package com.organissembly.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("*.jsp")
public class LoginFilter implements Filter {

   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		 

		  HttpServletRequest request = (HttpServletRequest) req;
	         HttpServletResponse response = (HttpServletResponse) res;
	         HttpSession session = request.getSession(false);

	 		((HttpServletResponse) res).setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			((HttpServletResponse) res).setHeader("Pragma", "no-cache"); // HTTP 1.0.
			((HttpServletResponse) res).setDateHeader("Expires", 0); // Proxies.
			
				String loginURL = request.getContextPath() + "/index.jsp";
				boolean loggedIn = session != null && session.getAttribute("userId") != null;
		        boolean loginRequest = request.getRequestURI().equals(loginURL);
	         
		        if (loggedIn || loginRequest) {
		            chain.doFilter(request, response); // Logged-in user found or already in login page, so just continue request.
		        } else {
		            response.sendRedirect(loginURL); // No logged-in user found and not already in login page, so redirect to login page.
		        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
