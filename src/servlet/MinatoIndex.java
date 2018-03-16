package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

/**
 * Servlet implementation class MinatoIndex
 */
@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
    

	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinatoIndex() {
        super();
        // TODO Auto-generated constructor stub
                        
    }

   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String param = request.getParameter("action");
		
	    ServletContext application = this.getServletContext();

		SiteEV site = (SiteEV)application.getAttribute("site");

		if (site == null ) {
			site = new SiteEV();
		}
		
	    SiteEVLogic siteEvLogic = new SiteEVLogic();
		


	    
		if(param == null) {
			
			application.setAttribute("site", site);

		} else if (param.equals("like")) {
			
			
			siteEvLogic.addLike(site);
			
			application.setAttribute("site", site);

			
		} else if (param.equals("dislike")) {
			

			siteEvLogic.addDisLike(site);
			
			application.setAttribute("site", site);

		}

		
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/minatoIndex.jsp");
		dispatch.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
