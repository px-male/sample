package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class RegistUser
 */
@WebServlet("/RegistUser")
public class RegistUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		if (action == "done") {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			RegisterUserLogic registerUserLogic = new RegisterUserLogic();
			registerUserLogic.execute();
			RequestDispatcher dispature = request.getRequestDispatcher("/WEB-INF/jsp/registerDone.jsp");
			
			
		} else if (action == null) {
			RequestDispatcher dispature = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
			dispature.forward(request, response);			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
	
		User user = new User();
		
		user.setId(loginId);
		user.setPassword(password);
		user.setName(name);
		
		HttpSession session = 	request.getSession();

		session.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		
	}

}
