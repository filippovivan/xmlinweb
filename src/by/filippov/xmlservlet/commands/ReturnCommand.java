package by.filippov.xmlservlet.commands;

import javax.servlet.http.HttpServletRequest;

import by.filippov.xmlservlet.utils.ConfigurationManager;

public class ReturnCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String command = ConfigurationManager.getProperty("path.page.choice");
		return command;
	}

}
