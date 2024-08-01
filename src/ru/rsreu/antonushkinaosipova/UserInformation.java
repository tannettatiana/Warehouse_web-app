package ru.rsreu.antonushkinaosipova;

/**
 * A class that contains user information to display.
 * 
 * @author Antonushkina Sofqya, Osipova Tatqyana
 * @version 1.0
 */
public class UserInformation {
	
	/**
	 * User ID
	 */
	private int id;
	
	/**
	 * User login
	 */
	private String login;
	
	/**
	 * User password
	 */
	private String password;
	
	/**
	 * User role
	 */
	private String role;
	
	/**
	 * User blocking status
	 */
	private String isBlocked;
	
	/**
	 * User authorizing status
	 */
	private String isAuthorized;
	
	/**
	 * Emptiness of object
	 */
	private boolean isEmpty = true;
	
	/**
	 * Create new object of user information entity.
	 */
	public UserInformation(int id, String login, String password, String role, String isBlocked, String isAuthorized) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
		this.isBlocked = isBlocked;
		this.isAuthorized = isAuthorized;
		this.isEmpty = false;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getIsBlocked() {
		return this.isBlocked;
	}
	
	public String getIsAuthorized() {
		return this.isAuthorized;
	}
	
	public boolean getIsEmpty() {
		return this.isEmpty;
	}
	
	public void setIsEmpty(boolean newEmptiness) {
		this.isEmpty = newEmptiness;
	}
}
