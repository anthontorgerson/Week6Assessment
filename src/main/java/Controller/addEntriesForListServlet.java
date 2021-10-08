package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addEntriesForListServlet
 */
@WebServlet("/addEntriesForListServlet")
public class addEntriesForListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEntriesForListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException,
    		IOException {
    		// TODO Auto-generated method stub
    		RaffleListHelper dao = new RaffleListHelper();
    		request.setAttribute("allEntries", dao.showAllEntries());
    		if(dao.showAllEntries().isEmpty()){
    		request.setAttribute("allEntries", " ");
    		}
    		getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
