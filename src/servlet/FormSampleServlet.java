package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormSampleServlet
 */
@WebServlet("/FormSampleServlet")
public class FormSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormSampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("epoc");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("送信時刻" + "<br>");
		out.println("Time = " + name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (name.isEmpty()) {
			out.println("名前を入力してください。");
		} else if (gender == null) {
			out.println("性別を入力してください。");
		} else {
			
			if (gender.equals("0")) {
				gender = "男性";
			} else if (gender.equals("1")) {
				gender = "女性";
			}
			out.println("<html>");
			out.println("<head>");
			out.println("<title> 返事 </title>");
			out.println("<p>名前は" + name + "です。性別は" + gender + "です。");
			out.println("</p>");
			out.println("</head>");
			out.println("</html>");			
		}
	}
}

