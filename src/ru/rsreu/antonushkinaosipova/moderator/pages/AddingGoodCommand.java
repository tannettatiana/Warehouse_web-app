package ru.rsreu.antonushkinaosipova.moderator.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;


public class AddingGoodCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;

		String productName = request.getParameter("addingGoodName");
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();

		if (productName != "") {
			UpdatingProductDAO updatingProduct = factory.updateProduct();
			if (updatingProduct.addProduct(productName)) {
				request.setAttribute("productAddingStatus", "Продукт добавлен на склад!");
			} else {
				request.setAttribute("productAddingStatus", "Продукт уже есть на складе!");
			}
		}

		factory.close();
		ActionCommand command = new AddingGoodsPageCommand();
		page = command.execute(request);
		return page;


	}

}
