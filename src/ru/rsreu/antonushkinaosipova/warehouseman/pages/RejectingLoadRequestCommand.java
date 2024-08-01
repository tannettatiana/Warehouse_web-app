package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import ru.rsreu.antonushkinaosipova.OracleDataBaseDAOFactory;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;

public class RejectingLoadRequestCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = null;
		String loadRequestId = request.getParameter("rejectedLoadRequest");
		if (loadRequestId == null) {
			loadRequestId = request.getParameter("rejectedLoadRequestHistory");
		}
		OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
		UpdatingLoadRequestDAO rejectedRequest = factory.updateLoadRequest();
		rejectedRequest.doReject(Integer.parseInt(loadRequestId));
		factory.close();
		
		ActionCommand command = new ViewingLoadRequestsCommand();
		page = command.execute(request); 
		
		return page;
}

}
