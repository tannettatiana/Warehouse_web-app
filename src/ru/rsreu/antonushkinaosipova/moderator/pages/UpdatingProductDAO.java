package ru.rsreu.antonushkinaosipova.moderator.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class UpdatingProductDAO {

	private Connection connection;

	public UpdatingProductDAO(Connection connection) {
		this.connection = connection;
	}

	public boolean addProduct(String addingName) throws SQLException {
		PreparedStatement findingProductPreparedStatement;
		findingProductPreparedStatement = connection.prepareStatement(QueryManager.getProperty("find.product.name"));
		findingProductPreparedStatement.setString(1, addingName);
		ResultSet nameResultSet = findingProductPreparedStatement.executeQuery();
		if (!nameResultSet.next()) {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(QueryManager.getProperty("warehouseman.add.product"));
			preparedStatement.setString(1, addingName);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		}
		return false;
	}

	public boolean deleteProduct(String deletingName) throws SQLException {

		PreparedStatement requestPreparedStatement = connection
				.prepareStatement(QueryManager.getProperty("get.request.by.product"));
		requestPreparedStatement.setString(1, deletingName);
		ResultSet resultSet = requestPreparedStatement.executeQuery();
		if (!resultSet.next()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement(QueryManager.getProperty("moder.delete.product"));
			preparedStatement.setString(1, deletingName);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		}
		return false;
	}

}