package ru.rsreu.antonushkinaosipova.warehouseman.pages;

public class DriverInformation {
	private int driver;
	private String carNumber;
	private String login;
	
	public DriverInformation(int driver, String carNumber, String login)
	{
		this.setDriver(driver);
		this.setCarNumber(carNumber);
		this.setLogin(login);
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	

}
