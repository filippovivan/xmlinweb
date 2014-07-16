package by.filippov.xmlservlet.commands;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.bsu.traintask.enteties.Train;
import by.bsu.traintask.exceptions.LogicalException;
import by.bsu.traintask.exceptions.TechnicalException;
import by.bsu.traintask.parcing.TrainBuilder;
import by.bsu.traintask.parcing.TrainBuilderFactory;
import by.filippov.xmlservlet.utils.ConfigurationManager;
import by.filippov.xmlservlet.utils.MessageManager;

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
			return ConfigurationManager.getProperty("path.page.main");
		} catch (TechnicalException | LogicalException e) {
			request.setAttribute("errorXMLParcing",
					MessageManager.getProperty("message.parceerror"));
			return ConfigurationManager.getProperty("path.page.error");
		}
	}

}
