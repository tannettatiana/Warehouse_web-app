package ru.rsreu.antonushkinaosipova.driver.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class UpdatingRequestDAO {
	private Connection connection;

	public UpdatingRequestDAO(Connection connection) {
		this.connection = connection;
	}

	public boolean addEnterRequest(int driver, String carNumber) throws SQLException {
		PreparedStatement sentEnterRequestPreparedStstement;
		sentEnterRequestPreparedStstement = connection
				.prepareStatement(QueryManager.getProperty("find.sent.enter.request"));
		sentEnterRequestPreparedStstement.setInt(1, driver);
		ResultSet findedSentRequestsResultSet = sentEnterRequestPreparedStstement.executeQuery();

		PreparedStatement requestPreparedStatement;
		requestPreparedStatement = connection.prepareStatement(QueryManager.getProperty("find.enter.request"));
		requestPreparedStatement.setInt(1, driver);
		requestPreparedStatement.setString(2, carNumber);
		requestPreparedStatement.setString(3, "sent");
		ResultSet findedRequestsResultSet = requestPreparedStatement.executeQuery();

		if ((!findedRequestsResultSet.next()) && (!findedSentRequestsResultSet.next())) {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(QueryManager.getProperty("add.enter.request"));
			preparedStatement.setInt(1, driver);
			preparedStatement.setString(2, carNumber);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		}
		return false;
	}

	public void addLoadRequest(int driver, String carNumber, String product, String loadType) throws SQLException {

		String productSql = QueryManager.getProperty("get.product.id");
		PreparedStatement productPrepareStatement = connection.prepareStatement(productSql);
		ResultSet productResultSet;
		productPrepareStatement.setString(1, product);
		productResultSet = productPrepareStatement.executeQuery();
		productResultSet.next();
		int productId = productResultSet.getInt(1);

		PreparedStatement requestPreparedStatement;
		requestPreparedStatement = connection.prepareStatement(QueryManager.getProperty("find.load.request"));
		requestPreparedStatement.setInt(1, driver);
		requestPreparedStatement.setString(2, carNumber);
		requestPreparedStatement.setInt(3, productId);
		requestPreparedStatement.setString(4, "sent");
		ResultSet findedRequestsResultSet = requestPreparedStatement.executeQuery();

		if (!findedRequestsResultSet.next()) {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(QueryManager.getProperty("add.load.request"));
			preparedStatement.setInt(1, driver);
			preparedStatement.setString(2, carNumber);

			preparedStatement.setInt(3, productId);
			preparedStatement.setString(4, loadType);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
	}
}
