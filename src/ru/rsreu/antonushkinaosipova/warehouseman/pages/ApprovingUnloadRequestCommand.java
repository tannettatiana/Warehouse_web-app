package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;

public class ApprovingUnloadRequestCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		String loadRequestId = request.getParameter("approvedUnloadRequest");
		if (loadRequestId == null) {
			loadRequestId = request.getParameter("approvedUnloadRequestHistory");
		}
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		UpdatingLoadRequestDAO approvedRequest = factory.updateLoadRequest();
		approvedRequest.doApprove(Integer.parseInt(loadRequestId), "in storage");
		factory.close();
		
		ActionCommand command = new ViewingLoadRequestsCommand();
		page = command.execute(request); 
		
		return page;
}
}