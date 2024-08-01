package ru.rsreu.antonushkinaosipova.driver.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class MakingLoadRequestPageCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		
		RequestInformationDAO driverInformationDAO = factory.getRequestInformation();
		
		ArrayList<String> cars = driverInformationDAO.getRequestFieldList(QueryManager.getProperty("get.car.numbers"));
		request.setAttribute("loadingCarNumber", cars);
		
		ArrayList<String> products = driverInformationDAO.getRequestFieldList(QueryManager.getProperty("get.products.name"));
		request.setAttribute("products", products);
		
		factory.close();
		
		page = ConfigurationManager.getProperty("path.page.driver.making.load.request");
		return page;
	}

}
