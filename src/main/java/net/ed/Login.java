package net.ed;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public static void launchBrowser(WebDriver driver, Visitor visitor) {
	
	// add support for chrome driver
	String key = "webdriver.chrome.driver";
	String valuex = "/Users/melocal/Applications/lib/chromedriver";
	System.setProperty(key, valuex);
	
	driver = new ChromeDriver();
	driver.manage().window().maximize(); // maximize chrome browser
//		driver.manage().deleteAllCookies(); // exactly what it says
	
	// dynamic wait
	driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	System.out.println("Login " + visitor.getUsername());
	
	String url = "https://login.yahoo.com";
	driver.get(url);
	}
}
