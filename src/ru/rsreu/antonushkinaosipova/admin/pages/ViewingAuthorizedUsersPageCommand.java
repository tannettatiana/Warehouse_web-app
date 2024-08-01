package ru.rsreu.antonushkinaosipova.admin.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.UserInformation;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewingAuthorizedUsersPageCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		UsersInformationDAO usersInformationDAO = factory.getUsersInformation();
		ArrayList<UserInformation> authorizedUsersInformation = usersInformationDAO.getUsersInformation(QueryManager.getProperty("get.users.authorized"));
		request.setAttribute("authorizedUsersInformation", authorizedUsersInformation);
		page = ConfigurationManager.getProperty("path.page.admin.users.authorized");
		factory.close();
		
		return page;
	}
}
