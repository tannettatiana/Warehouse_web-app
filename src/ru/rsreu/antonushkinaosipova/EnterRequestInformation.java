package ru.rsreu.antonushkinaosipova;

/**
 * A class of enter request entity.
 * 
 * @author Antonushkina Sofqya, Osipova Tatqyana
 * @version 1.0
 */
public class EnterRequestInformation {

	/**
	 * Enter request ID
	 */
	private int id;
	
	/**
	 * Enter request driver
	 */
	private int driver;
	
	/**
	 * Enter request car number
	 */
	private String carNumber;
	
	/**
	 * Enter request status (active/inactive/sent)
	 */
	private String status;
	
	/**
	 * Time of creating enter request
	 */
	private String time;
	
	/**
	 * Emptiness status of object
	 */
	private boolean isEmpty = true;
	
	/**
	 * Create an object of enter request entity.
	 */
	public EnterRequestInformation(int id, int driver, String carNumber, String status, String time) {
		this.id = id;
		this.driver = driver;
		this.carNumber = carNumber;
		this.status = status;
		this.time = time;
		this.isEmpty = false;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getDriver() {
		return this.driver;
	}
	
	public String getCarNumber() {
		return this.carNumber;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public boolean getIsEmpty() {
		return this.isEmpty;
	}
	
	public void setIsEmpty(boolean newEmptiness) {
		this.isEmpty = newEmptiness;
	}
}