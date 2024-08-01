package ru.rsreu.antonushkinaosipova;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.UpdatingEnterRequestDAO;

public class SessionListener implements HttpSessionListener{
	public void sessionCreated(HttpSessionEvent se) {
		
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		User user = (User)se.getSession().getAttribute("user");
		if (user != null) {
			try {
				OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
				if (user.getRole().getName().equals("driver")) {
					UpdatingEnterRequestDAO updatingRequest = factory.updateEnterRequest();
					updatingRequest.makeInactive(user.getId());
				}
				LoginLogicDAO loginLogic = factory.getLoginLogic();
				loginLogic.doLogout(user.getId());
				factory.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
