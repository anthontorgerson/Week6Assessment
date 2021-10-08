package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RaffleList;

/**
 * Servlet implementation class editEntryServlet
 */
@WebServlet("/editEntryServlet")
public class editEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RaffleListHelper dao = new RaffleListHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		RaffleList entryToUpdate = dao.searchForEntryById(tempId);
		entryToUpdate.setFirstName(firstName);
		entryToUpdate.setLastName(lastName);
		
		dao.updateEntry(entryToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllNamesServlet").forward(request, response);
	}

}
