package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.EnterRequestInformation;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewingEnterRequestsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		String page = null;

		OracleDataBaseDAOFactory factory;
		factory = OracleDataBaseDAOFactory.getInstance();
		ViewEnterRequestsDAO enterRequestsInformationDAO = factory.getEnterRequestsInformation();

		ArrayList<EnterRequestInformation> enterRequestInformation = enterRequestsInformationDAO
				.viewEnterRequestsInformation(QueryManager.getProperty("view.enter.requests"));
		ArrayList<EnterRequestInformation> enterRequestsHistory = enterRequestsInformationDAO
				.viewEnterRequestsInformation(QueryManager.getProperty("warehouseman.view.enter.request.history"));

		request.setAttribute("enterRequestInformation", enterRequestInformation);
		request.setAttribute("enterRequestsHistory", enterRequestsHistory);

		page = ConfigurationManager.getProperty("path.page.warehouseman.reqests.enter");
		return page;
	}

}
