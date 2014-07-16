package by.filippov.xmlservlet.commands;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = "/jsp/main/choise.jsp";
		return page;
	}
}