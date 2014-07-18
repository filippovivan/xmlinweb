package by.filippov.xmlservlet.servlet;

import javax.servlet.http.HttpServletRequest;

import by.filippov.xmlservlet.commands.ActionCommand;
import by.filippov.xmlservlet.commands.CommandEnum;
import by.filippov.xmlservlet.utils.MessageManager;

public class ActionFactory {
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = null;
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			return current;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction",
					action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
