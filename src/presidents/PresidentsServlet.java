package presidents;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("/PresidentsServlet")
public class PresidentsServlet extends HttpServlet {
	President[] pres = new President[44];
	private static String presFileName = "WEB-INF/presidents.csv";
	// private static final long serialVersionUID = 1L;

	public void init() {
		pres = parseFile(pres);
	}

	public President[] parseFile(President[] presi) {
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
					presi[k].setParty(words[6].trim());
					presi[k].setFunFact(words[5].trim());
					presi[k].setPhoto(words[7].trim());
					System.out.println(presi[k]);
				}
			}
			buf.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return presi;


	}



	public PresidentsServlet() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		String termNum = request.getParameter("termNum");

		switch(operation){
		case "Previous": break;
		case "Home": break;
		case "Next": break;
		default: break;
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
