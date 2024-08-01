package ru.rsreu.antonushkinaosipova;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.rsreu.antonushkinaosipova.resources.MessageManager;

public class AdminPagesFilter implements Filter{
	
	
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = null;
		try {
			if (session.getAttribute("user") != null) {
				user = (User)session.getAttribute("user");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user == null || !user.getRole().getName().equals("admin")) {
			req.getSession().setAttribute("nullPage", MessageManager.getProperty("message.not.admin"));
			resp.sendRedirect(req.getContextPath());
			return;
		}
		chain.doFilter(request, response);
	}
	
	@Override 
	public void init(FilterConfig filterConfig) throws ServletException {
    }
}

