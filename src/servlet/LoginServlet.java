package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		request.setCharacterEncoding("UTF-8");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		
		//Parameter取得
		String name = request.getParameter("userId");
		String pass = request.getParameter("passWord");
		
		//Loginのオプジェクト作成
		Login login = new Login(name, pass);
		
		//LoginLogic呼び出し
		LoginLogic ll = new LoginLogic();
		Boolean result = ll.execute(login);
		
		//成功したらOK表示、失敗したら再ログイン
		if(result){
			HttpSession session = request.getSession();
			session.setAttribute("userId", name);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/loginOk.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("/example/LoginServlet");
			response.encodeRedirectURL("UTF-8");

		}
		
	}

	
	
}
