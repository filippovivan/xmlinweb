package by.filippov.xmlservlet.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

import by.filippov.xmlservlet.commands.ActionCommand;

/**
 * Servlet implementation class XMLServlet
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	@Override
	public void init() throws ServletException {
		try (InputStream config = new FileInputStream(new File(
				getServletContext().getRealPath(
						"/resources/logconfig.properties")))) {
			PropertyConfigurator.configure(config);
		} catch (IOException e) {
			getServletContext().log("Cant configure logger");
		}
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		ActionFactory factory = new ActionFactory();
		ActionCommand command = factory.defineCommand(request);
		page = command.execute(request);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
