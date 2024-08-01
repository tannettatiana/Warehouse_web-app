package ru.rsreu.antonushkinaosipova;

/**
 * A class of load request entity.
 * 
 * @author Antonushkina Sofqya, Osipova Tatqyana
 * @version 1.0
 */

public class LoadRequestInformation {
	/**
	 * Load request ID
	 */
	private int id;
	
	/**
	 * Load request driver
	 */
	private int driver;
	
	/**
	 * Load request car number
	 */
	private String carNumber;
	
	/**
	 * Load request status (approved/not approved/sent)
	 */
	private String status;
	
	/**
	 * Product to load
	 */
	private String product;
	
	/**
	 * Load request type (loading/unloading)
	 */
	private String loadType;
	
	/**
	 * Time of creating load request
	 */
	private String time;
	
	/**
	 * Emptiness status of object
	 */
	private boolean isEmpty = true;

	/**
	 * Create an object of load request entity.
	 */
	public LoadRequestInformation(int id, int driver, String carNumber, String status, String product, String loadType,
			String time) {
		this.id = id;
		this.driver = driver;
		this.carNumber = carNumber;
		this.status = status;
		this.product = product;
		this.loadType = loadType;
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

	public String getProduct() {
		return this.product;
	}

	public String getLoadType() {
		return this.loadType;
	}

	public boolean getIsEmpty() {
		return this.isEmpty;
	}

	public void setIsEmpty(boolean newEmptiness) {
		this.isEmpty = newEmptiness;
	}
}
