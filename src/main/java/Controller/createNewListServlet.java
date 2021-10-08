package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DrawingHost;
import Model.RaffleDetails;
import Model.RaffleList;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createNewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RaffleListHelper lih = new RaffleListHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String hostName = request.getParameter("hostName");
		LocalDate ld;
		try {
		ld = LocalDate.of(Integer.parseInt(year),
		Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
		ld = LocalDate.now();
		}
		String[] selectedItems = request.getParameterValues("allEntriesToAdd");
		List<RaffleList> selectedItemsInList = new ArrayList<RaffleList>();

		if (selectedItems != null && selectedItems.length > 0)
		{
		for(int i = 0; i<selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		RaffleList c = lih.searchForEntryById(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(c);
		}
		}
		DrawingHost drawingHost = new DrawingHost(hostName);
		RaffleDetails sld = new RaffleDetails(listName, ld, drawingHost);

		sld.setListOfNames(selectedItemsInList);
		RaffleDetailHelper slh = new RaffleDetailHelper();
		slh.insertNewRaffleDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
