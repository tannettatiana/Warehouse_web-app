package ru.rsreu.antonushkinaosipova.admin.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.rsreu.antonushkinaosipova.UserInformation;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class UsersInformationDAO {
	private Connection connection;

	public UsersInformationDAO(Connection connection) {
		this.connection = connection;

	}
	
	public ArrayList<UserInformation> getUsersInformation(String sql) throws SQLException {
		PreparedStatement usersPreparedStatement;
		ResultSet usersResultSet;
		ArrayList<UserInformation> usersInformation = new ArrayList<UserInformation>();
		usersPreparedStatement = connection.prepareStatement(sql);
		usersResultSet = usersPreparedStatement.executeQuery();
		while (usersResultSet.next()) {
			String blockingStatus;
			if (usersResultSet.getInt(5) == 0) {
				blockingStatus = "No";
			} else {
				blockingStatus = "Yes";
			}
				
			String authorizingStatus;
			if (usersResultSet.getInt(6) == 0) {
				authorizingStatus = "No";
			} else {
				authorizingStatus = "Yes";
			}
				
			int role = usersResultSet.getInt(4);
			String roleSql = QueryManager.getProperty("get.user.role");
			PreparedStatement rolePrepareStatement = connection.prepareStatement(roleSql);
			ResultSet roleResultSet;
			rolePrepareStatement.setInt(1, role);
			roleResultSet = rolePrepareStatement.executeQuery();
			roleResultSet.next();
				
			UserInformation user = new UserInformation(usersResultSet.getInt(1), usersResultSet.getString(2), usersResultSet.getString(3), roleResultSet.getString(1), blockingStatus, authorizingStatus);
			usersInformation.add(user);
		}
		usersResultSet.close();
		usersPreparedStatement.close();
		
		return usersInformation;
	}
	
	public ArrayList<String> getStringList(String sql) throws SQLException{
		PreparedStatement loginsPreparedStatement;
		ResultSet loginsResultSet;
		ArrayList<String> logins = new ArrayList<String>();
		loginsPreparedStatement = connection.prepareStatement(sql);
		loginsResultSet = loginsPreparedStatement.executeQuery();
		while (loginsResultSet.next()) {
			logins.add(loginsResultSet.getString(1));
		}
		loginsResultSet.close();
		loginsPreparedStatement.close();
		
		return logins;
	}
}
