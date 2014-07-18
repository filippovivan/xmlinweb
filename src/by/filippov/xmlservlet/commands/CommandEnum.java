package by.filippov.xmlservlet.commands;


public enum CommandEnum {
	SHOW {
		{
			this.command = new ShowCommand();
		}
	},
	RETURN {
		{
			this.command = new ReturnCommand();
		}
	};
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}