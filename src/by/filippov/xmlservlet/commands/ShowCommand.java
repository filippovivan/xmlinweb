package by.filippov.xmlservlet.commands;

import javax.servlet.http.HttpServletRequest;

import by.bsu.traintask.enteties.Train;
import by.bsu.traintask.exceptions.LogicalException;
import by.bsu.traintask.exceptions.TechnicalException;
import by.bsu.traintask.parcing.TrainBuilder;
import by.bsu.traintask.parcing.TrainBuilderFactory;

public class ShowCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String parcer = request.getParameter("parcer");

		try {
			TrainBuilder builder = TrainBuilderFactory
					.create(TrainBuilderFactory.valueOf(parcer));
			builder.setPath("resources/train.xml");
			Train train = builder.createInstance();
			request.setAttribute("train", train);
			return "/jsp/main/main.jsp";
		} catch (TechnicalException | LogicalException e) {
			request.setAttribute("errorXMLParcing", "Internal error occured.");
			return "/jsp/error/error.jsp";
		}
	}

}
