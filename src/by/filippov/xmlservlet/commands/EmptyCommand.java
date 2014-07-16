package by.filippov.xmlservlet.commands;

import javax.servlet.http.HttpServletRequest;

import by.filippov.xmlservlet.utils.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.choise");
		return page;
	}
}