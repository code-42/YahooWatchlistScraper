package net.ed;

import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooLogin {
	
//	public static WebDriver driver;
	
	public static void launchBrowser(Visitor visitor) {
		
		final WebDriver driver;
		WebElement element;
			
		// add support for chrome driver
		String key = "webdriver.chrome.driver";
		String valuex = "/Users/melocal/Applications/lib/chromedriver";
		System.setProperty(key, valuex);
		
		driver = new ChromeDriver();
	//	driver.manage().window().maximize(); // maximize chrome browser
	//		driver.manage().deleteAllCookies(); // exactly what it says
		
		// dynamic wait
	//	driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		System.out.println("Login " + visitor.getUsername());
		
		String url = "https://login.yahoo.com";
		driver.navigate().to(url);
	//	driver.navigate().back();
		
		// sleep for a few milliseconds then click it
		try {
			Thread.sleep(400);
//			driver.findElement(By.name("username")).sendKeys(""); // fill in the blanks
//			element = driver.findElement(By.name("username"));
			element = driver.findElement(By.xpath("//*[@id=\'login-username\']"));
			element.sendKeys(visitor.getUsername());
			System.out.println("47. " + visitor.getUsername());
			Thread.sleep(100);
			element.findElement(By.xpath("//*[@id='login-signin']")).click();
			
//			element.submit();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sleep for a few milliseconds then click it
		try {
			Thread.sleep(400);
			// the password is incorrect
//			driver.findElement(By.name("password")).sendKeys("");
//			element = driver.findElement(By.name("password"));
			element = driver.findElement(By.xpath("//*[@id=\'login-passwd\']"));
			element.sendKeys(visitor.getPassword());
			System.out.println("64. " + visitor.getPassword());
			Thread.sleep(100);
//			element.findElement(By.name("verifyPassword")).click();
			element.findElement(By.xpath("//*[@id=\'login-signin\']")).click();
//			element.submit();
			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String URL = "https://finance.yahoo.com/portfolio/p_0/view/v1";
		driver.navigate().to(URL);
		// xpath for popup close //*[@id="__dialog"]/section/button/svg
	
	}
}
