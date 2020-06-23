

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DictionaryDao;
import beans.WordBean;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session= request.getSession();
		String eng=(String)session.getAttribute("eng");
		if(eng==null) {
			eng=new String();
		}
		WordBean wd=(WordBean)session.getAttribute("wd");
		if(wd==null) {
			wd=new WordBean();
		}
		
		
		String english=request.getParameter("english");
		String japanese=request.getParameter("japanese");
		if(english!=null) {
			String nextPage;
			if(DictionaryDao.delete(english)) {
				session.setAttribute("eng",english);
				nextPage="deleteResult.jsp";
			}else {
				session.setAttribute("eng",english);
				nextPage="deleteError.jsp";
			}
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request,response);
			
		}else {
			String nextPage;
			WordBean word=new WordBean(japanese);
			if(DictionaryDao.delete(word)) {
				session.setAttribute("wd",word);
				nextPage="deleteResult.jsp";
			}else {
				session.setAttribute("wd",word);
				nextPage="deleteError.jsp";
			}
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request,response);
			
		}
		
		
		
		
		
		
		
	}

}
