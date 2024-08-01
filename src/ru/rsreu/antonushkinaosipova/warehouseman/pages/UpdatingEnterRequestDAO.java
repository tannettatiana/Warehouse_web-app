package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class UpdatingEnterRequestDAO {

	private Connection connection;

	public UpdatingEnterRequestDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void doApprove(int requestId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QueryManager.getProperty("warehouseman.approve.enter.request"));
			preparedStatement.setInt(1, requestId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	public void doReject(int requestId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QueryManager.getProperty("warehouseman.reject.enter.request"));
			preparedStatement.setInt(1, requestId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void makeInactive(int driver) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QueryManager.getProperty("warehouseman.disactive.enter.request"));
			preparedStatement.setInt(1, driver);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
}
