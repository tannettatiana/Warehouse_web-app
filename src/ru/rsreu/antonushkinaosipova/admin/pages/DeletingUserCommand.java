package ru.rsreu.antonushkinaosipova.admin.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;

public class DeletingUserCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {

		String page = null;
		String login = request.getParameter("deletingLogin");

		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		UpdatingUserDAO deletingUser = factory.updateUser();
		deletingUser.deleteUser(login);
		factory.close();

		ActionCommand command = new DeletingUserPageCommand();
		page = command.execute(request);
		return page;
	}

}
