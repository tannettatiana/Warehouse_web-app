package ru.rsreu.antonushkinaosipova.driver.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.EnterRequestInformation;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.User;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewingDriverEnterRequestsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IllegalStateException {
		String page = null;

		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		RequestInformationDAO requestInformationDAO = factory.getRequestInformation();
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<EnterRequestInformation> sentRequestInformation = requestInformationDAO
				.getEnterRequestInformation(QueryManager.getProperty("get.driver.enter.requests"), user.getId(), "sent");
		
		ArrayList<EnterRequestInformation> activeRequestInformation = requestInformationDAO
				.getEnterRequestInformation(QueryManager.getProperty("get.driver.enter.requests"), user.getId(), "active");
		
		ArrayList<EnterRequestInformation> inactiveRequestInformation = requestInformationDAO
				.getEnterRequestInformation(QueryManager.getProperty("get.driver.enter.requests"), user.getId(), "inactive");
		
		request.setAttribute("driverEnterRequestInformation", sentRequestInformation);
		request.setAttribute("driverActiveEnterRequestInformation", activeRequestInformation);
		request.setAttribute("driverInactiveEnterRequestInformation", inactiveRequestInformation);
		
		
		factory.close();

		page = ConfigurationManager.getProperty("path.page.driver.viewing.enter.request");
		return page;
	}

}
