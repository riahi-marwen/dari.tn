package tn.esprit.projet.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.projet.controller.UserJsfController;


public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

		UserJsfController usermaroController = 
				(UserJsfController) httpServletRequest.getSession().getAttribute("employeController");

		if (usermaroController!=null && usermaroController.getAuthenticatedUser() != null && usermaroController.getLoggedIn()) 
		{ filterChain.doFilter(servletRequest, servletResponse);} 
		
		else {httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsf" );}
	}

}

