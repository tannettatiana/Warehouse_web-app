package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;


public class ApprovingEnterRequestCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		String enterRequestId = request.getParameter("approvedEnterRequest");
		if (enterRequestId == null) {
			enterRequestId = request.getParameter("approvedEnterRequestHistory");
		}
		
		
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		UpdatingEnterRequestDAO approvedRequest = factory.updateEnterRequest();
		approvedRequest.doApprove(Integer.parseInt(enterRequestId));
		factory.close();
		
		ActionCommand command = new ViewingEnterRequestsCommand();
		page = command.execute(request); 
		
		return page;
		
	}
	
}