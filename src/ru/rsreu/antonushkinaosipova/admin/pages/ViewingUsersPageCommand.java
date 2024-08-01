package ru.rsreu.antonushkinaosipova.admin.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.UserInformation;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewingUsersPageCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		String page = null;
		
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		UsersInformationDAO usersInformationDAO = factory.getUsersInformation();
		ArrayList<UserInformation> usersInformation = usersInformationDAO.getUsersInformation(QueryManager.getProperty("get.users.all"));
		request.setAttribute("usersInformation", usersInformation);
		page = ConfigurationManager.getProperty("path.page.admin.users");
		factory.close();
		
		return page;
	}
	
}
