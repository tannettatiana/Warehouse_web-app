package ru.rsreu.antonushkinaosipova.moderator.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;

public class DeletingGoodCommand implements ActionCommand{
	
	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		String product = request.getParameter("deletedProductName");
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		UpdatingProductDAO deletingProduct = factory.updateProduct();
		if (deletingProduct.deleteProduct(product)) {
			request.setAttribute("productDeletingStatus", "Продукт удален успешно!");
		} else {
			request.setAttribute("productDeletingStatus", "Продукт не может быть удален!");
		}
		factory.close();
		
		ActionCommand command = new ViewingGoodsCommand();
		page = command.execute(request); 
		return page;
	
	}

}
