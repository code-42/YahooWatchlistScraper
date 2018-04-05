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
	
	public static WebDriver driver;

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
		
		YahooLogin.launchBrowser(visitor);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void launchBrowser(Visitor visitor) {
		
	// add support for chrome driver
	String keyC = "webdriver.chrome.driver";
	String valueC = "/Users/melocal/Java_Projects/GAEProjects/YahooWatchlistScraper/src/main/webapp/WEB-INF/lib/chromedriver";
//	System.setProperty(keyC, valueC);

	// add support for firefox driver
	String keyF = "webdriver.gecko.driver";
	String valueF = "/Users/melocal/Java_Projects/GAEProjects/YahooWatchlistScraper/src/main/webapp/WEB-INF/lib/geckodriver";
	System.setProperty(keyF, valueF);
	
//	driver = new ChromeDriver();
//	driver = new FirefoxDriver();
//	driver.manage().window().maximize(); // maximize chrome browser
//		driver.manage().deleteAllCookies(); // exactly what it says
	
	// dynamic wait
	driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	System.out.println("77. Login " + visitor.getUsername());
	
	String URL = "https://login.yahoo.com";
	driver.navigate().to(URL);
	driver.navigate().back();
	
	driver.quit();
	}
	
}
