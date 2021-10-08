/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Sep 30, 2021
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RaffleList;

/**
 * Servlet implementation class addNameServlet
 */
@WebServlet("/addNameServlet")
public class addNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		RaffleList raffleList = new RaffleList(firstName, lastName);
		RaffleListHelper dao = new RaffleListHelper();
		dao.insertEntry(raffleList);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
