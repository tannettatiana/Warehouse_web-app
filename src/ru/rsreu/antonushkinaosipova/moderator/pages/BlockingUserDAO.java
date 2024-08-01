package ru.rsreu.antonushkinaosipova.moderator.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class BlockingUserDAO {
	
	private Connection connection;
	public BlockingUserDAO(Connection connection) {
		this.connection = connection;
	}

	public void doBlock(int userId) {
		try {
			PreparedStatement blockingStatusPreperedStatement = connection.prepareStatement(QueryManager.getProperty("moder.block.user"));
			blockingStatusPreperedStatement.setInt(1, 1);
			blockingStatusPreperedStatement.setInt(2, userId);
			blockingStatusPreperedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void doUnblock(int userId) {
		try {
			PreparedStatement blockingStatusPreperedStatement = connection.prepareStatement(QueryManager.getProperty("moder.block.user"));
			blockingStatusPreperedStatement.setInt(1, 0);
			blockingStatusPreperedStatement.setInt(2, userId);
			blockingStatusPreperedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
}
