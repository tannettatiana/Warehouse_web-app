package ru.rsreu.antonushkinaosipova.moderator.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.UserInformation;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.admin.pages.UsersInformationDAO;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewingUsersStatusCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException{
		String page = null;
		
		
		OracleDataBaseDAOFactory factory;
		factory = OracleDataBaseDAOFactory.getInstance();
		UsersInformationDAO usersInformationDAO = factory.getUsersInformation();
		ArrayList<UserInformation> usersActive = usersInformationDAO.getUsersInformation(QueryManager.getProperty("view.users.active"));
		request.setAttribute("usersActive", usersActive);
		
		ArrayList<UserInformation> usersBlocked = usersInformationDAO.getUsersInformation(QueryManager.getProperty("view.users.blocked"));
		request.setAttribute("usersBlocked", usersBlocked);
		
		page = ConfigurationManager.getProperty("path.page.moderator.users");
		return page;
		
	}

}
