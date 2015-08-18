package by.agency.travel.web.command.client;

import by.agency.travel.web.command.ActionCommand;
import by.agency.travel.web.command.AddTourCommand;
import by.agency.travel.web.command.LoginCommand;
import by.agency.travel.web.command.LogoutCommand;
import by.agency.travel.web.command.SaveTourCommand;
import by.agency.travel.web.command.TourCommand;

public enum CommandEnum {
	LOGIN {
		@Override
		public ActionCommand getCurrentCommand() {
			return new LoginCommand();
		}
	},
	LOGOUT {
		@Override
		public ActionCommand getCurrentCommand() {
			return new LogoutCommand();
		}
	},
	ADD_TOUR {
		@Override
		public ActionCommand getCurrentCommand() {
			return new AddTourCommand();
		}
	},
	SAVE_TOUR {
		@Override
		public ActionCommand getCurrentCommand() {
			return new SaveTourCommand();
		}
	},
	TOUR {
		@Override
		public ActionCommand getCurrentCommand() {
			return new TourCommand();
		}
	};
	
	public abstract ActionCommand getCurrentCommand();
}
