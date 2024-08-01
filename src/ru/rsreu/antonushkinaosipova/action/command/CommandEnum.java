package ru.rsreu.antonushkinaosipova.action.command;

import ru.rsreu.antonushkinaosipova.LoginCommand;
import ru.rsreu.antonushkinaosipova.LogoutCommand;
import ru.rsreu.antonushkinaosipova.admin.pages.AddingUserCommand;
import ru.rsreu.antonushkinaosipova.admin.pages.AddingUserPageCommand;
import ru.rsreu.antonushkinaosipova.admin.pages.DeletingUserCommand;
import ru.rsreu.antonushkinaosipova.admin.pages.DeletingUserPageCommand;
import ru.rsreu.antonushkinaosipova.admin.pages.ViewingAuthorizedUsersPageCommand;
import ru.rsreu.antonushkinaosipova.admin.pages.ViewingUsersPageCommand;
import ru.rsreu.antonushkinaosipova.driver.pages.MakingEnterRequestPageCommand;
import ru.rsreu.antonushkinaosipova.driver.pages.MakingLoadRequestPageCommand;
import ru.rsreu.antonushkinaosipova.driver.pages.SendingEnterRequestCommand;
import ru.rsreu.antonushkinaosipova.driver.pages.SendingLoadRequestCommand;
import ru.rsreu.antonushkinaosipova.driver.pages.ViewingDriverEnterRequestsCommand;
import ru.rsreu.antonushkinaosipova.driver.pages.ViewingDriverLoadRequestsCommand;
import ru.rsreu.antonushkinaosipova.moderator.pages.AddingGoodCommand;
import ru.rsreu.antonushkinaosipova.moderator.pages.AddingGoodsPageCommand;
import ru.rsreu.antonushkinaosipova.moderator.pages.BlockingUserCommand;
import ru.rsreu.antonushkinaosipova.moderator.pages.DeletingGoodCommand;
import ru.rsreu.antonushkinaosipova.moderator.pages.UnblockingUserCommand;
import ru.rsreu.antonushkinaosipova.moderator.pages.ViewingGoodsCommand;
import ru.rsreu.antonushkinaosipova.moderator.pages.ViewingUsersStatusCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ApprovingEnterRequestCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ApprovingLoadRequestCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ApprovingUnloadRequestCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.RejectingEnterRequestCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.RejectingLoadRequestCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.RejectingUnloadRequestCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ViewingDriversCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ViewingEnterRequestsCommand;
import ru.rsreu.antonushkinaosipova.warehouseman.pages.ViewingLoadRequestsCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},

	VIEWINGUSERS {
		{
			this.command = new ViewingUsersPageCommand();
		}
	},
	VIEWINGAUTHORIZEDUSERS {
		{
			this.command = new ViewingAuthorizedUsersPageCommand();
		}
	},
	DELETINGUSER {
		{
			this.command = new DeletingUserPageCommand();
		}
	},
	ADDINGUSER {
		{
			this.command = new AddingUserPageCommand();
		}
	},
	VIEWINGENTERREQUESTS {
		{
			this.command = new ViewingEnterRequestsCommand();
		}
	},
	VIEWINGLOADREQUESTS {
		{
			this.command = new ViewingLoadRequestsCommand();
		}
	},
	VIEWINGDRIVERS {
		{
			this.command = new ViewingDriversCommand();
		}
	},
	VIEWINGUSERSSTATUS {
		{
			this.command = new ViewingUsersStatusCommand();
		}
	},
	VIEWINGGOODS {
		{
			this.command = new ViewingGoodsCommand();
		}
	},
	ADDINGGOODSPAGE {
		{
			this.command = new AddingGoodsPageCommand();
		}
	},
	MAKINGENTERREQUEST{
		{
			this.command = new MakingEnterRequestPageCommand();
		}
	},
	MAKINGLOADREQUEST {
		{
			this.command = new MakingLoadRequestPageCommand();
		}
	},
	VIEWINGDRIVERENTERREQUESTS {
		{
			this.command = new ViewingDriverEnterRequestsCommand();
		}
	},
	VIEWINGDRIVERLOADREQUESTS {
		{
			this.command = new ViewingDriverLoadRequestsCommand();
		}
	},
	DELETINGUSERS {
		{
			this.command = new DeletingUserCommand();
		}
	},
	ADDINGUSERS {
		{
			this.command = new AddingUserCommand();
		}
	},
	SENDINGENTERREQUEST {
		{
			this.command = new SendingEnterRequestCommand();
		}
	}, 
	SENDINGLOADREQUEST {
		{
			this.command = new SendingLoadRequestCommand();
		}
	},
	ADDINGGOODS {
		{
			this.command = new AddingGoodCommand();
		}
	},
	DELETEGOOD {
		{
			this.command = new DeletingGoodCommand();
		}
	},
	
	BLOCK {
		{
			this.command = new BlockingUserCommand();
		}
	},
	
	UNBLOCK {
		{
			this.command = new UnblockingUserCommand();
		}
	},
	
	APPROVEENTERREQUEST {
		{
			this.command = new ApprovingEnterRequestCommand();
			}
	},
	
	REJECTENTERREQUEST {
		{
			this.command = new RejectingEnterRequestCommand();
		}
	},
	
	APPROVELOADREQUEST {
		{
			this.command = new ApprovingLoadRequestCommand();
		}
	},
	
	REJECTLOADREQUEST {
		{
			this.command = new RejectingLoadRequestCommand();
		}
	},
	
	APPROVEUNLOADREQUEST {
		{
			this.command = new ApprovingUnloadRequestCommand();
		}
	},
	
	REJECTUNLOADREQUEST {
		{
			this.command = new RejectingUnloadRequestCommand();
		}
	}
	;
	
	
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
	
}
