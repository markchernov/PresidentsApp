package web;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/choiceServlet")
public class choiceServlet extends HttpServlet {

	// fields
	private Integer choice;
	
	Set<President> presidentsHashSet;
	
	private HttpSession session;

	private President latestChoiceFromSession;

	private String answer;

	private String choiceString;

	private Integer latestChoiceNumber;

	PresidentsDAO myPresidentDAO;

	// init loads up DAO

	@Override
	public void init() throws ServletException {
		myPresidentDAO = new PresidentsFileDAO(getServletContext());
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// method to populate the choice.jsp

		session = req.getSession();

		// local object coming from session

		// President localChoosenPresident = (President)
		// session.getAttribute("choosenSessionPresident");

		// this parameter is coming from the link on the select.jsp
		// if link was clicked I am getting a value test1 and execute the if
		// statement

		answer = " " + req.getParameter("answerParameter");

		choiceString = " " + req.getParameter("choice");

		// display president from the session

		if(answer.equals(" presidentsList")) {
			// method to populate the select.jsp

			req.setAttribute("allPresidents", myPresidentDAO.getAllPresidents());
			req.getRequestDispatcher("/select.jsp").forward(req, resp);
//			return;
		}
		if (answer.equals(" test1")) {

			System.out.println("in test1 if statement");

			// session.setAttribute("choosenSessionPresident",
			// localChoosenPresident);

			latestChoiceFromSession = (President) (session.getAttribute("choosenSessionPresident"));

			req.setAttribute("onePresident", latestChoiceFromSession);

			req.getRequestDispatcher("/choice.jsp").forward(req, resp);
		}

		System.out.println(myPresidentDAO);

		System.out.println(answer);

		// just display number one

		if (answer.equals(" test2")) {

			req.setAttribute("onePresident", myPresidentDAO.getPresident(1));

			session.setAttribute("choosenSessionPresident", myPresidentDAO.getPresident(1));

			req.getRequestDispatcher("/choice.jsp").forward(req, resp);

		}

		if (choiceString.equals(" Next")) {

			System.out.println("in next");

			latestChoiceFromSession = (President) session.getAttribute("choosenSessionPresident");

			latestChoiceNumber = latestChoiceFromSession.getNumber();

			if (latestChoiceNumber < 44) {

				req.setAttribute("onePresident", myPresidentDAO.getPresident(latestChoiceNumber + 1));

				session.setAttribute("choosenSessionPresident", myPresidentDAO.getPresident(latestChoiceNumber + 1));

				req.getRequestDispatcher("/choice.jsp").forward(req, resp);
			}

			else {
				req.setAttribute("onePresident", myPresidentDAO.getPresident(1));
				session.setAttribute("choosenSessionPresident", myPresidentDAO.getPresident(1));
				req.getRequestDispatcher("/choice.jsp").forward(req, resp);

			}

		} // end if next

		if (choiceString.equals(" Prev")) {

			latestChoiceFromSession = (President) (session.getAttribute("choosenSessionPresident"));

			latestChoiceNumber = latestChoiceFromSession.getNumber();

			if (latestChoiceNumber > 1) {

				req.setAttribute("onePresident", myPresidentDAO.getPresident(latestChoiceNumber - 1));

				session.setAttribute("choosenSessionPresident", myPresidentDAO.getPresident(latestChoiceNumber - 1));

				req.getRequestDispatcher("/choice.jsp").forward(req, resp);
			}

			else {
				req.setAttribute("onePresident", myPresidentDAO.getPresident(44));
				session.setAttribute("choosenSessionPresident", myPresidentDAO.getPresident(44));
				req.getRequestDispatcher("/choice.jsp").forward(req, resp);
			} // end else

		} // end if prev
	} // end get method
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("number")!=null )
		choice = Integer.parseInt((req.getParameter("number")).trim());
		else choice = null;
		System.out.println(choice + "  my number choice of president ");

		
		
		
		
		// here I am reaching out to my DAO and calling a method with my choice
		// of a
		// president from select.jsp

		President myChoicePresident = myPresidentDAO.getPresident(choice);

		System.out.println(myChoicePresident);

		// creating my session , calling it sessionPresident and setting up a
		// HashSet to store my presidents Objects

		session = req.getSession(); // every time we call Post
												// method we reassign same
												// session ID to local variable

		if (session.getAttribute("sessionPresidents") == null) {

			session.setAttribute("sessionPresidents", new HashSet<President>());
		}

		// getting HashSet from session storage and pointing my local new
		// presidentsHashSet variable to the session
		// adding up myChoicePresident to a HashSet in the session
		// and dispatch updated req to results.jsp

		if (myChoicePresident != null) {

			presidentsHashSet = (Set<President>) session.getAttribute("sessionPresidents");
			System.out.println("adding president object to session");
			presidentsHashSet.add(myChoicePresident);
		

			req.setAttribute("choosenPresident", myChoicePresident);

			req.getRequestDispatcher("/results.jsp").forward(req, resp);
			//req.getRequestDispatcher("/choice.jsp").forward(req, resp);

		}
		if (myChoicePresident == null){
			req.setAttribute("choosenPresident", myChoicePresident);

			req.getRequestDispatcher("/error.jsp").forward(req, resp);
			
		}

		// save my latest choice of a president to a session
		
		session.setAttribute("choosenSessionPresident", myChoicePresident);
		
	}
} // end class