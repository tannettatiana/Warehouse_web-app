package ru.rsreu.antonushkinaosipova.moderator.pages;

import java.sql.SQLException;
import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;


public class AddingGoodsPageCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException, IllegalStateException  {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.moderator.goods.adding");
		return page;
	}

}
