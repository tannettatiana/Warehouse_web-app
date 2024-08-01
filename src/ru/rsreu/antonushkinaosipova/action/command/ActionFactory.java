package ru.rsreu.antonushkinaosipova.action.command;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.EmptyCommand;
import ru.rsreu.antonushkinaosipova.resources.MessageManager;

public class ActionFactory {
	public ActionCommand defineCommand(HttpServletRequest request){
		ActionCommand current = new EmptyCommand();
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			return current;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
		
	}
}
