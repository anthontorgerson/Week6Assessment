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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editListDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RaffleDetailHelper dao = new RaffleDetailHelper();
		RaffleListHelper lih = new RaffleListHelper();
		DrawingHostHelper sh = new DrawingHostHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		RaffleDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String hostName = request.getParameter("hostName");
		//find our add the new shopper
		DrawingHost drawingHost = sh.findHost(hostName);
		LocalDate ld;
		try {
		ld = LocalDate.of(Integer.parseInt(year),
		Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
		ld = LocalDate.now();
		}
		try {
		//items are selected in list to add
		String[] selectedItems = request.getParameterValues("allEntriesToAdd");
		List<RaffleList> selectedItemsInList = new ArrayList<RaffleList>();
		for (int i = 0; i < selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		RaffleList c =lih.searchForEntryById(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(c);
		}
		listToUpdate.setListOfNames(selectedItemsInList);
		} catch (NullPointerException ex) {
		// no items selected in list - set to an empty list
		List<RaffleList> selectedItemsInList = new ArrayList<RaffleList>();
		listToUpdate.setListOfNames(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setRaffleDate(ld);
		listToUpdate.setDrawingHost(drawingHost);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
}


