package presidents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PresidentsServlet extends HttpServlet {
	President[] presi = new President[44];
	public int currentTerm = 0;
	private final static String presFileName = "WEB-INF/presidents.csv";

	public PresidentsServlet() {
	}

	@Override
	public void init() throws ServletException {
		try {
			BufferedReader buf = new BufferedReader(
					new InputStreamReader(this.getServletContext().getResourceAsStream(presFileName)));

			String line;

			for (int k = 0; k < 44; k++) {
				if ((line = buf.readLine()) != null) {
					presi[k] = new President();
					String[] words = new String[(line.split(",").length)];
					words = line.split(",");

					presi[k].setTermNumber(Integer.parseInt(words[0]));
					presi[k].setFirstName(words[1].trim());
					presi[k].setMiddleName(words[2].trim());
					presi[k].setLastName(words[3].trim());
					presi[k].setStartDate(Integer.parseInt(words[4].trim().substring(0, 4)));
					presi[k].setEndDate(Integer.parseInt(words[4].trim().substring(5, 9)));
					presi[k].setParty(words[5].trim());
					//presi[k].setFunFact(words[6].trim());
					presi[k].setFunFact((words[6].replaceAll("$", ",")).trim());
					presi[k].setPhoto(words[7].trim());
					ServletContext context = this.getServletContext();
					context.setAttribute("presidents", presi);
				}
			}
			buf.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ArrayIndexOutOfBoundsException {
		ServletContext context = this.getServletContext();

		String operation = request.getParameter("operation");
		String termNumber = request.getParameter("currentTerm");
		String term = request.getParameter("termNumber");

		if (operation == null) {
			if(term == null) setCurrentTerm(0);
			else setCurrentTerm((Integer.parseInt(term))-1);
		} else if (operation.equals("Previous")) {
			setCurrentTerm(--currentTerm);
		} else if (operation.equals("Home")) {
			setCurrentTerm(0);
		} else if (operation.equals("Next")) {
			setCurrentTerm(++currentTerm);
		}

		context.setAttribute("currentTerm", currentTerm);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/presidents.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	public int getCurrentTerm() {
		return currentTerm;
	}

	public void setCurrentTerm(int currentTerm) {
		if(currentTerm < 0) this.currentTerm = presi.length-1;
		else if(currentTerm > 43) this.currentTerm = 0; 
		else this.currentTerm = currentTerm;
	}

}
