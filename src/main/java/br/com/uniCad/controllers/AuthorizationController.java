package br.com.uniCad.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizationController extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		boolean isNotinitialPageRequests = !(request.getRequestURI().endsWith("/") ||
				request.getRequestURI().endsWith("/login") ||
				request.getRequestURI().endsWith("/logout"));
		boolean igualURLAssets = request.getRequestURI().contains("assets");

		if(session.getAttribute("user") == null && isNotinitialPageRequests){
			if(session.getAttribute("user") == null && igualURLAssets)
				return true;

			response.sendRedirect("logout");
			return false;
		}

		return true;
	}
}
