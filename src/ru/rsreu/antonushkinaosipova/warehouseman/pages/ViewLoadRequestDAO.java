package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.rsreu.antonushkinaosipova.LoadRequestInformation;
import ru.rsreu.antonushkinaosipova.resources.QueryManager;

public class ViewLoadRequestDAO {

	private Connection connection;

	public ViewLoadRequestDAO(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<LoadRequestInformation> viewLoadRequestsInformation(String sql) {
		PreparedStatement loadRequestPreparedStatement;
		ResultSet loadRequestResultSet;
		ArrayList<LoadRequestInformation> loadRequestsInformation = new ArrayList<LoadRequestInformation>();
		try {
			loadRequestPreparedStatement = connection.prepareStatement(sql);
			loadRequestResultSet = loadRequestPreparedStatement.executeQuery();
			while (loadRequestResultSet.next()) {
				
				int product = loadRequestResultSet.getInt(5);
				String productSql = QueryManager.getProperty("get.request.product");
				PreparedStatement productPrepareStatement = connection.prepareStatement(productSql);
				ResultSet productResultSet;
				productPrepareStatement.setInt(1, product);
				productResultSet = productPrepareStatement.executeQuery();
				productResultSet.next();
				
				
				LoadRequestInformation loadRequest = new LoadRequestInformation(loadRequestResultSet.getInt(1),
						loadRequestResultSet.getInt(2), loadRequestResultSet.getString(3),
						loadRequestResultSet.getString(4), productResultSet.getString(1),
						loadRequestResultSet.getString(6), loadRequestResultSet.getString(7));
				loadRequestsInformation.add(loadRequest);
			
			}
			loadRequestResultSet.close();
			loadRequestPreparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return loadRequestsInformation;
	}

}
