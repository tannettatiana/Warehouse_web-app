package ru.rsreu.antonushkinaosipova;

import ru.rsreu.antonushkinaosipova.resources.ConfigurationManager;

public enum UserRoleEnum {
	ADMIN {
		{
			this.page = ConfigurationManager.getProperty("path.page.main.admin");
			this.name = "admin";
		}
	},
	MODERATOR {
		{
			this.page = ConfigurationManager.getProperty("path.page.main.moderator");
			this.name = "moderator";
		}
	},
	DRIVER {
		{
			this.page = ConfigurationManager.getProperty("path.page.main.driver");
			this.name = "driver";
		}
	},
	WAREHOUSEMAN {
		{
			this.page = ConfigurationManager.getProperty("path.page.main.warehouseman");
			this.name = "warehouseman";
		}
	};
	
	String page;
	String name;
	
	public String getMainPage() {
		return page;
	}
	
	public String getName() {
		return name;
	}
}
