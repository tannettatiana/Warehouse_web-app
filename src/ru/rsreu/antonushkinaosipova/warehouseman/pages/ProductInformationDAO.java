package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductInformationDAO {
	private Connection connection;

	public ProductInformationDAO(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<ProductInformation> doView(String sql) {
		PreparedStatement productStatement;
		ResultSet productResultSet;
		ArrayList<ProductInformation> products = new ArrayList<ProductInformation>();

		try {
			productStatement = connection.prepareStatement(sql);
			productResultSet = productStatement.executeQuery();
			while (productResultSet.next()) {
				int id = productResultSet.getInt(1);
				String name = productResultSet.getString(2);
				String location = productResultSet.getString(3);
				ProductInformation product = new ProductInformation(id, name, location);
				products.add(product);
			}
			productResultSet.close();
			productStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return products;
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
