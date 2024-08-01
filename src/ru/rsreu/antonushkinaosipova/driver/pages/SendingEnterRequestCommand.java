package ru.rsreu.antonushkinaosipova.driver.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.User;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;

public class SendingEnterRequestCommand implements ActionCommand{
	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException, IllegalStateException {
		String page = null;
		String carNumber = request.getParameter("enteringCar");
		
		if (carNumber != "") {
			OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
			
			UpdatingRequestDAO updatingRequestDAO = factory.updateRequest();
			User user = (User)request.getSession().getAttribute("user");
			//updatingRequestDAO.addEnterRequest(user.getId(), carNumber);
			
			if (updatingRequestDAO.addEnterRequest(user.getId(), carNumber)) {
				request.setAttribute("enterRequestAddingStatus", "Заявка успешно отправлена!");
			} else {
				request.setAttribute("enterRequestAddingStatus", "У Вас уже есть активная заявка!");
			}
			
			factory.close();
		}
		
		ActionCommand command = new MakingEnterRequestPageCommand();
		page = command.execute(request);
		return page;
	}
}
