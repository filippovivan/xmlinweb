package by.filippov.xmlservlet.commands;

import javax.servlet.http.HttpServletRequest;

import by.bsu.traintask.enteties.Train;
import by.bsu.traintask.exceptions.LogicalException;
import by.bsu.traintask.exceptions.TechnicalException;
import by.bsu.traintask.parcing.TrainBuilder;
import by.bsu.traintask.parcing.TrainBuilderFactory;
import by.filippov.xmlservlet.utils.ConfigurationManager;
import by.filippov.xmlservlet.utils.MessageManager;

public class ShowCommand implements ActionCommand {
	private static final String RESOURCE_TRAIN = "/resources/train.xml";
	private static final String PAGE_ERROR = "path.page.error";
	private static final String MESSAGE_PARCEERROR = "message.parceerror";
	private static final String PAGE_MAIN = "path.page.main";
	private static final String PAGE_CHOISE = "path.page.choise";

	@Override
	public String execute(HttpServletRequest request) {
		String parcer = request.getParameter("parcer");
		if (parcer == null) {
			request.setAttribute("notChosen", "Choose any parcer");
			return ConfigurationManager.getProperty(PAGE_CHOISE);
		}

		try {
			TrainBuilder builder = TrainBuilderFactory
					.create(TrainBuilderFactory.valueOf(parcer));
			builder.setPath(request.getServletContext().getRealPath(
					RESOURCE_TRAIN));
			Train train = builder.createInstance();
			request.setAttribute("train", train);
			return ConfigurationManager.getProperty(PAGE_MAIN);
		} catch (TechnicalException | LogicalException e) {
			request.setAttribute("errorXMLParcing",
					MessageManager.getProperty(MESSAGE_PARCEERROR));
			return ConfigurationManager.getProperty(PAGE_ERROR);
		}
	}

}
