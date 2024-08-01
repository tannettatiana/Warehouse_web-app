package ru.rsreu.antonushkinaosipova.admin.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class UpdatingUserDAO {
	
	private Connection connection;

	public UpdatingUserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void deleteUser(String deletingLogin) throws SQLException{
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(QueryManager.getProperty("delete.user"));
		preparedStatement.setString(1, deletingLogin);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public void addUser(String addingLogin, String addingPassword, String role) throws SQLException{
		
		PreparedStatement findingUserPreparedStatement;
		findingUserPreparedStatement = connection.prepareStatement(QueryManager.getProperty("find.user.login"));
		findingUserPreparedStatement.setString(1, addingLogin);
		ResultSet loginResultSet = findingUserPreparedStatement.executeQuery();
		if (!loginResultSet.next()) {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(QueryManager.getProperty("add.user"));
			preparedStatement.setString(1, addingLogin);
			preparedStatement.setString(2, addingPassword);
			
			String roleSql = QueryManager.getProperty("get.user.role.id");
			PreparedStatement rolePrepareStatement = connection.prepareStatement(roleSql);
			ResultSet roleResultSet;
			rolePrepareStatement.setString(1, role);
			roleResultSet = rolePrepareStatement.executeQuery();
			roleResultSet.next();
			
			preparedStatement.setInt(3, roleResultSet.getInt(1));
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
	}
	
}
