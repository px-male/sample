package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

/**
 * Servlet implementation class HealthCheck !!
 */
@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HealthCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("hello!");
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/healthCheck.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
		// 空文字かどうか確認して、空文字ならエラー表示する。
		if (height.isEmpty() || weight.isEmpty()) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("身長と体重を入力して下さい。");
		}
		double double_height = Double.parseDouble(height);
		double double_weight = Double.parseDouble(weight);
		
		
		
		
		
		HealthCheckLogic hcLogic = new HealthCheckLogic();

		double bmi = hcLogic.calculateBmi(double_height, double_weight);
		
		String bodyType = "";
		
		if (bmi < 18.5) {
			bodyType = "痩せ型";
		} else if (bmi >= 18.5 && bmi < 25) {
			bodyType = "普通";
		} else if (bmi >= 25){
			bodyType = "肥満";
		}
		
		Health health = new Health();
		health.setHeight(double_height);
		health.setWeight(double_weight);
		health.setBmi(bmi);
		health.setBodytype(bodyType);
		
		//リクエストスコープに保存
		request.setAttribute("health", health);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthCheckResult.jsp");
		dispatcher.forward(request, response);
	}

}
