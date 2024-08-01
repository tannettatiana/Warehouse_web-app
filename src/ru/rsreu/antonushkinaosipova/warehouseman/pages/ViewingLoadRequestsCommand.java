package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.LoadRequestInformation;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewingLoadRequestsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		String page = null;

		OracleDataBaseDAOFactory factory;
		factory = OracleDataBaseDAOFactory.getInstance();
		ViewLoadRequestDAO loadRequestInformationDAO = factory.getLoadRequestInformation();
		ArrayList<LoadRequestInformation> loadRequestInformation = loadRequestInformationDAO
				.viewLoadRequestsInformation(QueryManager.getProperty("warehouseman.view.load.requests"));
		
		ArrayList<LoadRequestInformation> unloadRequestInformation = loadRequestInformationDAO
				.viewLoadRequestsInformation(QueryManager.getProperty("warehouseman.view.unload.requests"));
		
		ArrayList<LoadRequestInformation> loadRequestInformationHistory = loadRequestInformationDAO
				.viewLoadRequestsInformation(QueryManager.getProperty("warehouseman.view.load.requests.history"));
		
		ArrayList<LoadRequestInformation> unloadRequestInformationHistory = loadRequestInformationDAO
				.viewLoadRequestsInformation(QueryManager.getProperty("warehouseman.view.unload.requests.history"));
		
		request.setAttribute("loadRequestInformation", loadRequestInformation);
		request.setAttribute("unloadRequestInformation", unloadRequestInformation);
		request.setAttribute("loadRequestInformationHistory", loadRequestInformationHistory);
		request.setAttribute("unloadRequestInformationHistory", unloadRequestInformationHistory);
		page = ConfigurationManager.getProperty("path.page.warehouseman.reqests.load");
		return page;
	}

}
