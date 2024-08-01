package ru.rsreu.antonushkinaosipova.moderator.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;

public class BlockingUserCommand  implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		String userId = request.getParameter("blockedUserId");
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();

		if (userId != "") {
			BlockingUserDAO updatingProduct = factory.blockUser();
			updatingProduct.doBlock(Integer.parseInt(userId));
		}

		factory.close();
		ActionCommand command = new ViewingUsersStatusCommand();
		page = command.execute(request);
		return page;
	}
	
}
