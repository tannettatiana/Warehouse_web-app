package ru.rsreu.antonushkinaosipova.admin.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class AddingUserPageCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		
		UsersInformationDAO rolesInformationDAO = factory.getUsersInformation();
		ArrayList<String> rolesInformation = rolesInformationDAO.getStringList(QueryManager.getProperty("get.roles"));
		request.setAttribute("rolesInformation", rolesInformation);
		
		factory.close();
		
		page = ConfigurationManager.getProperty("path.page.admin.users.adding");
		return page;
	}

}
