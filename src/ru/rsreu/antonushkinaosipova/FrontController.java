package ru.rsreu.antonushkinaosipova;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.rsreu.antonushkinaosipova.action.command.ActionCommand;
import ru.rsreu.antonushkinaosipova.action.command.ActionFactory;
import ru.rsreu.antonushkinaosipova.resources.MessageManager;

/**
 * 
 * Servlet that processes all the requests from client
 * and execute necessary commands.
 *
 * @author Antonushkina Sofqya, Osipova Tatqyana
 * @version 1.0
 *
 */

public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Processes the GET-request.
	 *
	 * @param request  The HttpServletRequest that contains the GET-request.
	 * @param response The HttpServletResponse that contains the response.
	 * 
	 * @throws ServletException If the processing of the request encounters an exception.
	 * @throws IOException      If an I/O exception occurs.
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Processes the POST-request.
	 *
	 * @param request  The HttpServletRequest that contains the POST-request.
	 * @param response The HttpServletResponse that contains the response.
	 * 
	 * @throws ServletException If the processing of the request encounters an exception.
	 * @throws IOException      If an I/O exception occurs.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean getIsLogout(HttpServletRequest request) {
		boolean isLogout = false;
		if (request.getAttribute("isLogout") != null) {
			isLogout = (boolean)request.getAttribute("isLogout");
		}
		return isLogout;
	}
	
	private boolean getIsLogin(HttpServletRequest request) {
		boolean isLogin = false;
		if (request.getAttribute("isLogin") != null) {
			isLogin = (boolean)request.getAttribute("isLogin");
		}
		return isLogin;
	}
	
	private User getUser(HttpSession session) {
		User user = null;
		if (session.getAttribute("user") != null) {
			user = (User)session.getAttribute("user");
		}
		return user;
	}
	
	private boolean isBlocked(int id, User user, HttpServletRequest request) throws ClassNotFoundException, SQLException{
		User newStatusUser = new User();
		if (user != null) {
			OracleDataBaseDAOFactory factory = OracleDataBaseDAOFactory.getInstance();
			LoginLogicDAO loginLogic = factory.getLoginLogic();
			newStatusUser = loginLogic.getBlocked(user.getId());
			factory.close();
		}
		return newStatusUser.getBlockStatus();
	}
	
	private void directToPage(HttpServletRequest request, HttpServletResponse response, String page, User user, boolean isLogout, boolean isLogin) throws IOException, ServletException, ClassNotFoundException, SQLException {
		
		if (page != null && (user != null || isLogout || isLogin)) {
			if (user == null) {
				user = new User();
			}
			if (!isBlocked(user.getId(), user, request)){
				request.getSession().removeAttribute("nullPage");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror.blocked"));
				response.sendRedirect(request.getContextPath());
				
			}
		} else {
			if (user == null) {
				request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.session.disabled"));
			} else {
				request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			}
			response.sendRedirect(request.getContextPath());
		}
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {
		
		request.getSession().removeAttribute("nullPage");
		
		String page = null;
		User user = null;
		
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(30 * 60);
		
		try {
			page = command.execute(request);
			user = getUser(session);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		boolean isLogout = getIsLogout(request);
		boolean isLogin = getIsLogin(request);

		directToPage(request, response, page, user, isLogout, isLogin);
	}
}
