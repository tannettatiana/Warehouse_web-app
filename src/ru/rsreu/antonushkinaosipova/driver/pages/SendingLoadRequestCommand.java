package ru.rsreu.antonushkinaosipova.driver.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.User;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;

public class SendingLoadRequestCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		String page = null;
		String carNumber = request.getParameter("choosedCar");
		String product = request.getParameter("choosedProduct");
		String loadType = request.getParameter("loadType");
		
		if (carNumber != "") {
			OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
			
			UpdatingRequestDAO updatingRequestDAO = factory.updateRequest();
			User user = (User)request.getSession().getAttribute("user");
			updatingRequestDAO.addLoadRequest(user.getId(), carNumber, product, loadType);
			
			factory.close();
		}
		
		ActionCommand command = new MakingLoadRequestPageCommand();
		page = command.execute(request);
		return page;
	}

}
