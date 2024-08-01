package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewingDriversCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		String page = null;

		OracleDataBaseDAOFactory factory;
		factory = OracleDataBaseDAOFactory.getInstance();
		ViewDriversDAO driversInformationDAO = factory.getDriverInformation();
		ArrayList<DriverInformation> driverInformation = driversInformationDAO
				.viewDriverInformation(QueryManager.getProperty("warehouseman.view.drivers"));
		request.setAttribute("driverInformation", driverInformation);

		page = ConfigurationManager.getProperty("path.page.warehouseman.drivers.onStorage");
		return page;
	}

}
