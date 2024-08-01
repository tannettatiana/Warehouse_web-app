package ru.rsreu.antonushkinaosipova;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;

public class LogoutCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
			LoginLogicDAO loginLogic = factory.getLoginLogic();
			try {
				User user = (User)session.getAttribute("user");
				loginLogic.doLogout(user.getId());
				session.invalidate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			factory.close();
		}
		request.setAttribute("isLogout", true);	
		String page = ConfigurationManager.getProperty("path.page.index");
		return page;
	}
}
