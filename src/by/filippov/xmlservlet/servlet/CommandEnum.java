package by.filippov.xmlservlet.servlet;

import by.filippov.xmlservlet.commands.ActionCommand;
import by.filippov.xmlservlet.commands.ReturnCommand;
import by.filippov.xmlservlet.commands.ShowCommand;

public enum CommandEnum {
	SHOW {
		{
			this.command = new ShowCommand();
		}
	},
	RETURN_TO_CHOSE {
		{
			this.command = new ReturnCommand();
		}
	};
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}