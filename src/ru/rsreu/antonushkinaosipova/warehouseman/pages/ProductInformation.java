package ru.rsreu.antonushkinaosipova.warehouseman.pages;

public class ProductInformation {
	private int id;
	private String name;
	private String location;
	
	public ProductInformation(int id, String name, String location) {
		this.setId(id);
		this.setName(name);
		this.setLocation(location);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
