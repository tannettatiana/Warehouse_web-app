package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewDriversDAO {

	private Connection connection;

	public ViewDriversDAO(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<DriverInformation> viewDriverInformation(String sql) {
		PreparedStatement driverPreparedStatement;
		ResultSet driverRequestResultSet;
		ArrayList<DriverInformation> driverRequestsInformation = new ArrayList<DriverInformation>();
		try {
			driverPreparedStatement = connection.prepareStatement(sql);
			driverRequestResultSet = driverPreparedStatement.executeQuery();
			while (driverRequestResultSet.next()) {
				DriverInformation driverRequest = new DriverInformation(driverRequestResultSet.getInt(1),
						driverRequestResultSet.getString(2), driverRequestResultSet.getString(3));
				driverRequestsInformation.add(driverRequest);
			}
			driverRequestResultSet.close();
			driverPreparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return driverRequestsInformation;
	}

}
