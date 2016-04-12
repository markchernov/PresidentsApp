//package web;
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.swing.plaf.synth.SynthStyleFactory;
//
//@WebServlet("/PresidentsServlet")
//public class PresidentsServlet extends HttpServlet {
//
//	// fields
//
//	 Integer choice;
//	
//	 Set<President> presidentsHashSet;
//	
//	 PresidentsDAO myPresidentDAO;
//
//	// init loads up DAO
//
//	@Override
//	public void init() throws ServletException {
//		myPresidentDAO = new PresidentsFileDAO(getServletContext());
//	}
//
//	// doGet creates a reference "allPresidents" and sends presidents list to
//	// select.jsp
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		// method to populate the select.jsp
//
//		req.setAttribute("allPresidents", myPresidentDAO.getAllPresidents());
//		req.getRequestDispatcher("/select.jsp").forward(req, resp);
//		//req.getRequestDispatcher("/choice.jsp").forward(req, resp);
//	}
//
//	// doPost receives the choice from the form
//
//	@Override
//	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		choice = Integer.parseInt((req.getParameter("number")).trim());
//		
//		System.out.println(choice + "  my number choice of president ");
//
//		
//		
//		
//		
//		// here I am reaching out to my DAO and calling a method with my choice
//		// of a
//		// president from select.jsp
//
//		President myChoicePresident = myPresidentDAO.getPresident(choice);
//
//		System.out.println(myChoicePresident);
//
//		// creating my session , calling it sessionPresident and setting up a
//		// HashSet to store my presidents Objects
//
//		HttpSession session = req.getSession(); // every time we call Post
//												// method we reassign same
//												// session ID to local variable
//
//		if (session.getAttribute("sessionPresidents") == null) {
//
//			session.setAttribute("sessionPresidents", new HashSet<President>());
//		}
//
//		// getting HashSet from session storage and pointing my local new
//		// presidentsHashSet variable to the session
//		// adding up myChoicePresident to a HashSet in the session
//		// and dispatch updated req to results.jsp
//
//		if (myChoicePresident != null) {
//
//			presidentsHashSet = (Set<President>) session.getAttribute("sessionPresidents");
//			System.out.println("adding president object to session");
//			presidentsHashSet.add(myChoicePresident);
//
//			req.setAttribute("choosenPresident", myChoicePresident);
//
//			req.getRequestDispatcher("/results.jsp").forward(req, resp);
//			//req.getRequestDispatcher("/choice.jsp").forward(req, resp);
//
//		}
//
//		// save my latest choice of a president to a session
//		
//		session.setAttribute("choosenSessionPresident", myChoicePresident);
//		
//	}
//}