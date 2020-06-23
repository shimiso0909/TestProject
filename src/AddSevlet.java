

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
 * Servlet implementation class AddSevlet
 */
@WebServlet("/AddSevlet")
public class AddSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		WordBean dictionary=(WordBean)session.getAttribute("dictionary");
		if(dictionary==null) {
			dictionary=new WordBean();
		}
		
		String english=request.getParameter("english");
		String japanese=request.getParameter("japanese");
		WordBean word=new WordBean(english,japanese);
		String nextPage;
		if(DictionaryDao.insert(word)==true&& english!="" && japanese!="") {
			session.setAttribute("dictionary",word);
			nextPage="addResult.jsp";
		}else if(DictionaryDao.insert(word)==false|| english=="" || japanese==""){
			session.setAttribute("dictionary",word);
			nextPage="addError.jsp";
		}else {
			nextPage="addError.jsp";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(nextPage);
		rd.forward(request,response);
		
	}

}
