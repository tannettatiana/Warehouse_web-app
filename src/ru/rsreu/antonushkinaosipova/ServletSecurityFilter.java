package ru.rsreu.antonushkinaosipova;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.rsreu.antonushkinaosipova.resources.MessageManager;

public class ServletSecurityFilter implements Filter{
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		User user = null;
		
		if (session.getAttribute("user") != null) {
			user = (User)session.getAttribute("user");
		}
		
		if (user == null) {
			req.getSession().setAttribute("nullPage", MessageManager.getProperty("message.not.authorized"));
			resp.sendRedirect(req.getContextPath());
		} else {
			req.getSession().setAttribute("nullPage", MessageManager.getProperty("message.use.navigation"));
			resp.sendRedirect(req.getContextPath());
		}
	}
}
