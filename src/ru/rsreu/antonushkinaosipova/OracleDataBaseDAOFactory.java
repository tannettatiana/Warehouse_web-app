package ru.rsreu.antonushkinaosipova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;
import ru.rsreu.antonushkinaosipova.admin.pages.UpdatingUserDAO;
import ru.rsreu.antonushkinaosipova.admin.pages.UsersInformationDAO;
import ru.rsreu.antonushkinaosipova.driver.pages.RequestInformationDAO;
import ru.rsreu.antonushkinaosipova.driver.pages.UpdatingRequestDAO;
import ru.rsreu.antonushkinaosipova.moderator.pages.BlockingUserDAO;
import ru.rsreu.antonushkinaosipova.moderator.pages.UpdatingProductDAO;
import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ProductInformationDAO;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.UpdatingEnterRequestDAO;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.UpdatingLoadRequestDAO;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ViewDriversDAO;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ViewEnterRequestsDAO;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ViewLoadRequestDAO;

/**
 * 
 * A class that allows work with database and execute SQL-statement.
 * 
 * This class create objects of DAO-classes and create database-connection.
 * 
 * @author Antonushkina Sofqya, Osipova Tatqyana
 * @version 1.0
 *
 */


public class OracleDataBaseDAOFactory {
	
	/**
	 * A connection to the database.
	 */
	private Connection connection;

	private OracleDataBaseDAOFactory() {
	}

	/**
	 * Create an instance of the OracleDataBaseDAOFactory class.
	 *
	 * @return an instance of the DataAccessObject class
	 * @throws ClassNotFoundException if the database connector class is not found
	 * @throws SQLException           if a database connection can not be created
	 */
	public static OracleDataBaseDAOFactory getInstance() throws ClassNotFoundException, SQLException {
		OracleDataBaseDAOFactory factory;
		factory = new OracleDataBaseDAOFactory();
		factory.connected();
		return factory;
	}
	
	/**
	 * Close database-connection.
	 *
	 * @throws SQLException           if a database connection can not be closed
	 */
	public void close() throws SQLException {
		connection.close();
	}

	private void connected() throws ClassNotFoundException, SQLException {
		String url = ConfigurationManager.getProperty("connection.url");
		String user = ConfigurationManager.getProperty("connection.user");
		String password = ConfigurationManager.getProperty("connection.password");
		DriverManager.registerDriver(new OracleDriver());
		connection = DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * Create object of LoginLogicDAO class to provide
	 * database operations that necessary to login.
	 * 
	 * @return object of LoginLogicDAO class 
	 */
	public LoginLogicDAO getLoginLogic() {
		return new LoginLogicDAO(this.connection);
	}
	
	/**
	 * Create object of UsersInformationDAO class to provide
	 * database operations that necessary to get user information.
	 * 
	 * @return object of UsersInformationDAO class 
	 */
	public UsersInformationDAO getUsersInformation() {
		return new UsersInformationDAO(this.connection);
	}
	
	/**
	 * Create object of UpdatingUserDAO class to provide
	 * database operations that necessary to update user information.
	 * 
	 * @return object of UpdatingUserDAO class 
	 */
	public UpdatingUserDAO updateUser() {
		return new UpdatingUserDAO(this.connection);
	}
	
	/**
	 * Create object of RequestInformationDAO class to provide
	 * database operations that necessary to get request information.
	 * 
	 * @return object of RequestInformationDAO class 
	 */
	public RequestInformationDAO getRequestInformation() {
		return new RequestInformationDAO(this.connection);
	}
	
	/**
	 * Create object of UpdatingRequestDAO class to provide
	 * database operations that necessary to update request information.
	 * 
	 * @return object of UpdatingRequestDAO class 
	 */
	public UpdatingRequestDAO updateRequest() {
		return new UpdatingRequestDAO(this.connection);
	}

	/**
	 * Create object of ProductInformationDAO class to provide
	 * database operations that necessary to get product information.
	 * 
	 * @return object of ProductInformationDAO class 
	 */
	public ProductInformationDAO getProductInformaiton() {
		return new ProductInformationDAO(this.connection);
	}
	
	/**
	 * Create object of ViewEnterRequestsDAO class to provide
	 * database operations that necessary to get enter request information.
	 * 
	 * @return object of ViewEnterRequestsDAO class 
	 */
	public ViewEnterRequestsDAO getEnterRequestsInformation() {
		return new ViewEnterRequestsDAO(this.connection);
	}
	
	/**
	 * Create object of RequestInformationDAO class to provide
	 * database operations that necessary to get load request information.
	 * 
	 * @return object of RequestInformationDAO class 
	 */
	public ViewLoadRequestDAO getLoadRequestInformation() {
		return new ViewLoadRequestDAO(this.connection);
	}
	
	/**
	 * Create object of ViewDriversDAO class to provide
	 * database operations that necessary to get driver information.
	 * 
	 * @return object of ViewDriversDAO class 
	 */
	public ViewDriversDAO getDriverInformation() {
		return new ViewDriversDAO(this.connection);
	}
	
	/**
	 * Create object of UpdatingProductDAO class to provide
	 * database operations that necessary to update product information.
	 * 
	 * @return object of UpdatingProductDAO class 
	 */
	public UpdatingProductDAO updateProduct() {
		return new UpdatingProductDAO(this.connection);
	}
	
	/**
	 * Create object of UpdatingUserDAO class to provide
	 * database operations that necessary to update user information.
	 * 
	 * @return object of UpdatingUserDAO class 
	 */
	public BlockingUserDAO blockUser() {
		return new BlockingUserDAO(this.connection);
	}
	
	public UpdatingEnterRequestDAO updateEnterRequest() {
		return new UpdatingEnterRequestDAO(this.connection);
	}
	
	public UpdatingLoadRequestDAO updateLoadRequest() {
		return new UpdatingLoadRequestDAO(this.connection);
	}
	
}
