package net.ed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Servlet implementation class StockControllerServlet
 */
@WebServlet("/StockControllerServlet")
public class StockControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	public static WebDriver driver;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
//		PrintWriter output = response.getWriter();
//		output.println("text/html bla bla bla bla bleep");
		
		// temporary - add form handling after
		String username = "edev42@yahoo.com";
		String password = "incorrect42";
		
		Visitor visitor = new Visitor();
		visitor.setUsername(username);
		visitor.setPassword(password);
		
		YahooLogin yahooLogin = new YahooLogin(visitor);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
