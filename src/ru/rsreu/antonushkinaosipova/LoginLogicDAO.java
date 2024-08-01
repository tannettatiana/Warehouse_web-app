package ru.rsreu.antonushkinaosipova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class LoginLogicDAO{
	
	private Connection connection;

	public LoginLogicDAO(Connection connection) {
		this.connection = connection;

	}
	
	private ResultSet findUser(String name, String password) throws SQLException {
		PreparedStatement userPrepareStatement;
		ResultSet userResultSet;
		userPrepareStatement = connection.prepareStatement(QueryManager.getProperty("get.user"));
		userPrepareStatement.setString(1, name);
		userPrepareStatement.setString(2, password);
		userResultSet = userPrepareStatement.executeQuery();
		return userResultSet;
	}
	
	private ResultSet findUserToCheckBlockingStatus(int id) throws SQLException {
		PreparedStatement userPrepareStatement;
		ResultSet userResultSet;
		userPrepareStatement = connection.prepareStatement(QueryManager.getProperty("get.user.blocking.status"));
		userPrepareStatement.setInt(1, id);
		userResultSet = userPrepareStatement.executeQuery();
		return userResultSet;
	}
	
	private User setUser(int id, UserRoleEnum role, boolean blockStatus, String login) {
		User user = new User();
		user.setEmptiness(false);
		user.setId(id);
		user.setRole(role);
		user.setBlockStatus(blockStatus);
		user.setLogin(login);
		return user;
	}
	
	private void setAuthorizingStatus(User user) throws SQLException {
		PreparedStatement authorizingStatusPreperedStatement = connection.prepareStatement(QueryManager.getProperty("set.authorizing.status"));
		authorizingStatusPreperedStatement.setInt(1, 1);
		authorizingStatusPreperedStatement.setInt(2, user.getId());
		authorizingStatusPreperedStatement.executeUpdate();
	}
	
	public User doLogin(String name, String password){
		User user = new User();
		try {
			ResultSet userResultSet = findUser(name, password);
			if (userResultSet.next()) {
				user = setUser(userResultSet.getInt(1), UserRoleEnum.valueOf(userResultSet.getString(2).toUpperCase()), userResultSet.getBoolean(3), userResultSet.getString(4));
				setAuthorizingStatus(user);
			}
			userResultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getBlocked(int id) {
		User user = new User();
		try {
			ResultSet userResultSet = findUserToCheckBlockingStatus(id);
			if (userResultSet.next()) {
				user = setUser(userResultSet.getInt(1), UserRoleEnum.valueOf(userResultSet.getString(2).toUpperCase()), userResultSet.getBoolean(3), userResultSet.getString(4));
			}
			userResultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void doLogout(int userId){
		try {
			PreparedStatement authorizingStatusPreperedStatement = connection.prepareStatement(QueryManager.getProperty("set.authorizing.status"));
			authorizingStatusPreperedStatement.setInt(1, 0);
			authorizingStatusPreperedStatement.setInt(2, userId);
			authorizingStatusPreperedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
