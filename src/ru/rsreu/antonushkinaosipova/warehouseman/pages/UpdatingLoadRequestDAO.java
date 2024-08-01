package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class UpdatingLoadRequestDAO {
	
	
	private Connection connection;

	public UpdatingLoadRequestDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void doApprove(int requestId, String productStatus) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QueryManager.getProperty("warehouseman.approve.load.request"));
			preparedStatement.setInt(1, requestId);
			preparedStatement.executeUpdate();
			PreparedStatement productStatusPreparedStatement = connection.prepareStatement(QueryManager.getProperty("change.product.status"));
			productStatusPreparedStatement.setInt(2, requestId);
			productStatusPreparedStatement.setString(1, productStatus);
			productStatusPreparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	public void doReject(int requestId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QueryManager.getProperty("warehouseman.reject.load.request"));
			preparedStatement.setInt(1, requestId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	

}
