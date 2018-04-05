package net.ed;

import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class YahooLogin {
	
	public static WebDriver driver;
	
	public static void launchBrowser(Visitor visitor) {
		
	// add support for chrome driver
	String key = "webdriver.chrome.driver";
	String valuex = "/Users/melocal/Applications/lib/chromedriver";
	System.setProperty(key, valuex);
	
//	WebDriver driver = new ChromeDriver();
//	driver.manage().window().maximize(); // maximize chrome browser
//		driver.manage().deleteAllCookies(); // exactly what it says
	
	// dynamic wait
	driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	System.out.println("Login " + visitor.getUsername());
	
	String url = "https://login.yahoo.com";
	driver.navigate().to(url);
//	driver.navigate().back();
	
	// sleep for a few milliseconds then click it
	try {
		Thread.sleep(500);
		driver.findElement(By.name("username")).sendKeys(""); // fill in the blanks
		Thread.sleep(500);
		driver.findElement(By.name("signin")).click();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// sleep for a few milliseconds then click it
	try {
		Thread.sleep(500);
		// the password is incorrect
		driver.findElement(By.name("password")).sendKeys("");
		Thread.sleep(500);
		driver.findElement(By.name("verifyPassword")).click();
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	}
}
