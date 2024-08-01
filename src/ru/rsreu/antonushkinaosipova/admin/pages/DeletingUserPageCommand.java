package ru.rsreu.antonushkinaosipova.admin.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class DeletingUserPageCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		
		UsersInformationDAO usersLoginInformationDAO = factory.getUsersInformation();
		ArrayList<String> usersLoginInformation = usersLoginInformationDAO.getStringList(QueryManager.getProperty("get.users.logins"));
		request.setAttribute("loginsInformation", usersLoginInformation);
		factory.close();
		
		page = ConfigurationManager.getProperty("path.page.admin.users.deleting");
		return page;
	}
}
