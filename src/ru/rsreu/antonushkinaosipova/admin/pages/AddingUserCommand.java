package ru.rsreu.antonushkinaosipova.admin.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;

public class AddingUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		
		String login = request.getParameter("addingLogin");
		String password = request.getParameter("addingPassword");
		String role = request.getParameter("choosedRole");
		
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();	
		if (login != "" && password != "") {
			UpdatingUserDAO updatingUser = factory.updateUser();
			updatingUser.addUser(login, password, role);
		}
		factory.close();
		
		ActionCommand command = new AddingUserPageCommand();
		page = command.execute(request);
		return page;
	}

}
