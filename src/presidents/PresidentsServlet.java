package presidents;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
	public President currentPres;
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
					presi[k].setFunFact(words[6].trim());
					presi[k].setPhoto(words[7].trim());
					// System.out.println(presi[k]);
					ServletContext context = this.getServletContext();
					context.setAttribute("presidents", presi);
					// context.setAttribute("presidents.termNumber", 6);
					// int termNum =
					// Integer.parseInt((String)context.getAttribute("termNum"));
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
		System.out.println(operation);
		
		if (operation.equals("Previous")) {
			try {
				setCurrentTerm(--currentTerm);
			} catch (ArrayIndexOutOfBoundsException ex) {
				System.out.println("--index out of bounds exception caught");
				setCurrentTerm(43);
			}
		} else if (operation.equals("Home")) {
			setCurrentTerm(0);
		} else if (operation.equals("Next")) {
			try {
				setCurrentTerm(++currentTerm);
			} catch (ArrayIndexOutOfBoundsException ex) {
				System.out.println("++index out of bounds exception caught");
				setCurrentTerm(0);
			}
		}
		System.out.println(currentTerm);
		
		
		context.setAttribute("currentTerm", presi[currentTerm].getTermNumber());
		
		// int nextTerm = 0;
		// int currentTerm = Integer.parseInt(request.getParameter("termNum"));

		// switch (operation) {
		// case "Previous": break;
		// case "Home": break;
		// case "Next": break;
		// default: break;
		// }
		
		currentPres = presi[currentTerm];
		System.out.println(currentPres.getPhoto());

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
		this.currentTerm = currentTerm;
	}

}
