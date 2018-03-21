package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerSample implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO 自動生成されたメソッド・スタブ
		
		ServletContext application = sce.getServletContext();
		Integer count = 10;
		application.setAttribute("count", count);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
