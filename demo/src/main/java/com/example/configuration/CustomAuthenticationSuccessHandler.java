package com.example.configuration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);

		boolean admin = false;
		boolean user = false;

		logger.info("AT onAuthenticationSuccess(...) function!");

	//	for (GrantedAuthority auth : authentication.getAuthorities()) {
		for (GrantedAuthority auth : authentication.getAuthorities()) {
		if ("ADMIN".equals(auth.getAuthority())) {
				admin = true;
			}
			if ("USER".equals(auth.getAuthority())) {
				user = true;
			}
		}
		if (admin) {
			response.sendRedirect("/admin/home.html");
		} else if (user) {
			response.sendRedirect("/doctor/doctor.html");
		} else {
			response.sendRedirect("/helpdesk/helpDesk.html");

		}
	}
}
