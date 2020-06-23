

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DictionaryDao;
import beans.WordBean;

/**
 * Servlet implementation class SearchSevlet
 */
@WebServlet("/SearchSevlet")
public class SearchSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String english=request.getParameter("english");
		WordBean word=DictionaryDao.search(english);
		
		String nextPage;
		if(word!=null) {
			request.setAttribute("word",word);
			nextPage="searchResult.jsp";
		}else {
			request.setAttribute("english",english);
			nextPage="searchError.jsp";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(nextPage);
		rd.forward(request,response);
		
		
	}

}
