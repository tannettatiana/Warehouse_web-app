package ru.rsreu.antonushkinaosipova.driver.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.rsreu.antonushkinaosipova.EnterRequestInformation;
import ru.rsreu.antonushkinaosipova.LoadRequestInformation;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class RequestInformationDAO {
	private Connection connection;

	public RequestInformationDAO(Connection connection) {
		this.connection = connection;

	}

	public ArrayList<EnterRequestInformation> getEnterRequestInformation(String sql, int driverId, String status) throws SQLException {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<EnterRequestInformation> requestInformation = new ArrayList<EnterRequestInformation>();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, driverId);
		preparedStatement.setString(2, status);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			EnterRequestInformation request = new EnterRequestInformation(resultSet.getInt(1), resultSet.getInt(2),
					resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			requestInformation.add(request);
		}
		resultSet.close();
		preparedStatement.close();

		return requestInformation;
	}

	public ArrayList<LoadRequestInformation> getLoadRequestInformation(String sql, int driverId, String loadType, String status)
			throws SQLException {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<LoadRequestInformation> requestInformation = new ArrayList<LoadRequestInformation>();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, driverId);
		preparedStatement.setString(2, loadType);
		preparedStatement.setString(3, status);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {

			int product = resultSet.getInt(5);
			String productSql = QueryManager.getProperty("get.request.product");
			PreparedStatement productPrepareStatement = connection.prepareStatement(productSql);
			ResultSet productResultSet;
			productPrepareStatement.setInt(1, product);
			productResultSet = productPrepareStatement.executeQuery();
			productResultSet.next();

			LoadRequestInformation request = new LoadRequestInformation(resultSet.getInt(1), resultSet.getInt(2),
					resultSet.getString(3), resultSet.getString(4), productResultSet.getString(1),
					resultSet.getString(6), resultSet.getString(7));
			requestInformation.add(request);
		}
		resultSet.close();
		preparedStatement.close();

		return requestInformation;
	}

	public ArrayList<String> getRequestFieldList(String sql) throws SQLException {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<String> requestFieldList = new ArrayList<String>();
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			requestFieldList.add(resultSet.getString(1));
		}
		resultSet.close();
		preparedStatement.close();

		return requestFieldList;
	}
}
