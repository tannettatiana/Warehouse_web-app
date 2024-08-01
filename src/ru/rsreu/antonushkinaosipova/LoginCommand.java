package ru.rsreu.antonushkinaosipova;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.MessageManager;

public class LoginCommand implements ActionCommand{
	
	private User getOldSessionUser(HttpServletRequest request) {
		User oldUser = new User();
		HttpSession oldSession = request.getSession(false);
		if (oldSession != null) {
			if (oldSession.getAttribute("user") != null) {
				oldUser = (User)oldSession.getAttribute("user");
			}
		}
		return oldUser;
	}
	
	private String getUserPage(HttpServletRequest request, User user) {
		String page = ConfigurationManager.getProperty("path.page.login");;
		User oldUser = getOldSessionUser(request);
		if (user.getEmptiness()) {
			request.getSession().setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
		} else if (user.getBlockStatus()) {
			request.getSession().setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror.blocked"));
		} else if (oldUser.getId() != user.getId() && oldUser.getId() != -1) {
			request.getSession().setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.already.authorized") + oldUser.getLogin());
		} else {
			page = (user.getRole()).getMainPage();
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
		}
		return page;
	}
	
	private String getPage(HttpServletRequest request, String login, String password) throws ClassNotFoundException, SQLException {
		String page;
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		LoginLogicDAO loginLogic = factory.getLoginLogic();
		User user = loginLogic.doLogin(login, password);
		page = getUserPage(request, user);
		factory.close();
		return page;
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		try {
			page = getPage(request, login, pass);
		} catch (ClassNotFoundException | SQLException e) {
			page = ConfigurationManager.getProperty("path.page.login");
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			e.printStackTrace();
		}
		
		request.setAttribute("isLogin", true);
		return page;
	}
}
