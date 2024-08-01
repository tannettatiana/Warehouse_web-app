package ru.rsreu.antonushkinaosipova.driver.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.LoadRequestInformation;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.User;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewingDriverLoadRequestsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IllegalStateException {
		String page = null;

		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		RequestInformationDAO requestInformationDAO = factory.getRequestInformation();
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<LoadRequestInformation> loadRequestInformation = requestInformationDAO.getLoadRequestInformation(
				QueryManager.getProperty("get.driver.load.requests"), user.getId(), "loading", "sent");
		request.setAttribute("driverLoadRequestInformation", loadRequestInformation);
		
		ArrayList<LoadRequestInformation> loadApprovedRequestInformation = requestInformationDAO.getLoadRequestInformation(
				QueryManager.getProperty("get.driver.load.requests"), user.getId(), "loading", "approved");
		request.setAttribute("driverApprovedLoadRequestInformation", loadApprovedRequestInformation);
		
		ArrayList<LoadRequestInformation> loadNotApprovedRequestInformation = requestInformationDAO.getLoadRequestInformation(
				QueryManager.getProperty("get.driver.load.requests"), user.getId(), "loading", "not approved");
		request.setAttribute("driverNotApprovedLoadRequestInformation", loadNotApprovedRequestInformation);
		
		
		
		ArrayList<LoadRequestInformation> unloadRequestInformation = requestInformationDAO.getLoadRequestInformation(
				QueryManager.getProperty("get.driver.load.requests"), user.getId(), "unloading", "sent");
		request.setAttribute("driverUnloadRequestInformation", unloadRequestInformation);
		
		ArrayList<LoadRequestInformation> unloadApprovedRequestInformation = requestInformationDAO.getLoadRequestInformation(
				QueryManager.getProperty("get.driver.load.requests"), user.getId(), "unloading", "approved");
		request.setAttribute("driverApprovedUnloadRequestInformation", unloadApprovedRequestInformation);
		
		ArrayList<LoadRequestInformation> unloadNotApprovedRequestInformation = requestInformationDAO.getLoadRequestInformation(
				QueryManager.getProperty("get.driver.load.requests"), user.getId(), "unloading", "not approved");
		request.setAttribute("driverNotApprovedUnloadRequestInformation", unloadNotApprovedRequestInformation);
		factory.close();

		page = ConfigurationManager.getProperty("path.page.driver.viewing.load.request");
		return page;
	}

}
