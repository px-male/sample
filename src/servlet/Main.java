package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext application = this.getServletContext();

		List<Mutter> tsubuList = (List<Mutter>) application.getAttribute("tsubuList");
		
		if (tsubuList == null) {
			tsubuList = new ArrayList<Mutter>();
			application.setAttribute("tsubuList", tsubuList);
			
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
	
		if (user != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/example");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// formのパラメータ取得
		request.setCharacterEncoding("UTF-8");
		
		String text = request.getParameter("mutter");

		if (!text.isEmpty()) {

			// Sessionスコープからパラメータ取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");

			// アプリケーションスコープからパラメータ取得
			ServletContext application = this.getServletContext();
			List<Mutter> list = (List<Mutter>)application.getAttribute("tsubuList");
		
			// Mutterインスタンス作成
			Mutter mutter = new Mutter();
			mutter.setName(user.getName());
			mutter.setString(text);
		
			// つぶやきをリストに追加
			PostMutterLogic postmutterlogic = new PostMutterLogic();
			postmutterlogic.execute(mutter, list);		
			
			// applicationスコープにlistを追加
			application.setAttribute("tsubuList", list);
		} else {
			String error = "呟きが入力されていません。";
			request.setAttribute("error", error);
		}
		
		// どこつぶの表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
		
	}

}
