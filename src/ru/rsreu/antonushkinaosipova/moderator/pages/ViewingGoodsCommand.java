package ru.rsreu.antonushkinaosipova.moderator.pages;

import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ProductInformation;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ProductInformationDAO;

public class ViewingGoodsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		String page = null;

		OracleDataBaseDAOFactory factory;
		factory = OracleDataBaseDAOFactory.getInstance();
		ProductInformationDAO productsInformationDAO = factory.getProductInformaiton();
		ArrayList<ProductInformation> productInformation = productsInformationDAO.doView(QueryManager.getProperty("view.product"));
		request.setAttribute("productInformation", productInformation);
		page = ConfigurationManager.getProperty("path.page.moderator.goods.viewing");
		return page;
		
	}

}
