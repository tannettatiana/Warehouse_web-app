package ru.rsreu.antonushkinaosipova.warehouseman.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.rsreu.antonushkinaosipova.EnterRequestInformation;

public class ViewEnterRequestsDAO {

	private Connection connection;

	public ViewEnterRequestsDAO(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<EnterRequestInformation> viewEnterRequestsInformation(String sql) {
		PreparedStatement enterRequestPreparedStatement;
		ResultSet enterRequestResultSet;
		ArrayList<EnterRequestInformation> enterRequestsInformation = new ArrayList<EnterRequestInformation>();
		try {
			enterRequestPreparedStatement = connection.prepareStatement(sql);
			enterRequestResultSet = enterRequestPreparedStatement.executeQuery();
			while (enterRequestResultSet.next()) {
				EnterRequestInformation enterRequest = new EnterRequestInformation(enterRequestResultSet.getInt(1),
						enterRequestResultSet.getInt(2), enterRequestResultSet.getString(3),
						enterRequestResultSet.getString(4), enterRequestResultSet.getString(5));
				enterRequestsInformation.add(enterRequest);
			}
			enterRequestResultSet.close();
			enterRequestPreparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return enterRequestsInformation;
	}

}
