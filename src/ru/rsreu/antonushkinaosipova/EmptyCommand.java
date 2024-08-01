package ru.rsreu.antonushkinaosipova;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;

public class EmptyCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}

}
