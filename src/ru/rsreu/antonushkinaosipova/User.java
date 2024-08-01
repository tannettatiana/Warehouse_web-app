package ru.rsreu.antonushkinaosipova;

/**
 * 
 * A class of authorizing user entity.
 *
 * @author Antonushkina Sofqya, Osipova Tatqyana
 * @version 1.0
 *
*/
public class User {
	
	/**
	 * ID of authorized user
	 */
	private int id = -1;
	
	/**
	 * Role of authorized user
	 */
	private UserRoleEnum role = null;
	
	/**
	 * Blocking status of authorized user
	 */
	private boolean isBlocked = false;
	
	/**
	 * Emptiness of user object
	 */
	private boolean isEmpty = true;
	
	/**
	 * Login of authorized user
	 */
	private String login = "";
	
	/**
	 * 
	 * @return user ID
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * 
	 * @return user role
	 */
	public UserRoleEnum getRole() {
		return this.role;
	}
	
	/**
	 * 
	 * @return emptiness of object
	 */
	public boolean getEmptiness() {
		return this.isEmpty;
	}
	
	/**
	 * 
	 * @return user block status
	 */
	public boolean getBlockStatus() {
		return this.isBlocked;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	/**
	 * 
	 * @param newId New user ID
	 */
	public void setId(int newId) {
		this.id = newId;
	}
	
	/**
	 * 
	 * @param newRole New user role
	 */
	public void setRole(UserRoleEnum newRole) {
		this.role = newRole;
	}
	
	/**
	 * 
	 * @param newEmptiness New object emptiness status
	 */
	public void setEmptiness(boolean newEmptiness) {
		this.isEmpty = newEmptiness;
	}
	
	/**
	 * 
	 * @param newBlockStatus New user block status
	 */
	public void setBlockStatus(boolean newBlockStatus) {
		this.isBlocked = newBlockStatus;
	}
	
	public void setLogin(String newLogin) {
		this.login = newLogin;
	}
	
	public String toString() {
		return String.valueOf(this.getId());
	}
}
