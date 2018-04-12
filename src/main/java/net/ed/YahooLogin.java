package net.ed;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YahooLogin {
	
	WebDriver chromeDriver;
	
	YahooLogin(Visitor visitor) {
		
		System.out.println("19. in YahooLogin constructor " + visitor.getUsername());
	}

//	
	public static void launchBrowser(Visitor visitor) {
	
//		WebDriver driver;
		WebElement element = null;
			
		// add support for chrome driver
		String keyC = "webdriver.chrome.driver";
		String valueC = "/Users/melocal/Java_Projects/GAEProjects/YahooWatchlistScraper/src/main/webapp/WEB-INF/lib/chromedriver";
		System.setProperty(keyC, valueC);

		// add support for firefox driver
		String keyF = "webdriver.gecko.driver";
		String valueF = "/Users/melocal/Java_Projects/GAEProjects/YahooWatchlistScraper/src/main/webapp/WEB-INF/lib/geckodriver";
//		System.setProperty(keyF, valueF);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-javascript");
		options.addArguments("--remote-debugging=port=9222");
		chromeDriver = new ChromeDriver(options);
		
		
//		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
	//	driver.manage().window().maximize(); // maximize chrome browser
	//		driver.manage().deleteAllCookies(); // exactly what it says
		
		// dynamic wait
	//	driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		String url = "https://login.yahoo.com";
		chromeDriver.navigate().to(url);
//		chromeDriver.navigate().back();
		
		System.out.println("58. " + chromeDriver.getTitle());
		// sleep for a few milliseconds then click it
		try {
			Thread.sleep(1000);
//			driver.findElement(By.name("username")).sendKeys(""); // fill in the blanks
//			element = driver.findElement(By.name("username"));
			element = chromeDriver.findElement(By.xpath("//*[@id=\'login-username\']"));
			element.sendKeys(visitor.getUsername());
			System.out.println("66. " + visitor.getUsername());
			Thread.sleep(100);
			element.findElement(By.xpath("//*[@id='login-signin']")).click();
			
//			element.submit();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sleep for a few milliseconds then click it
		try {
			Thread.sleep(500);
			// the password is incorrect
//			driver.findElement(By.name("password")).sendKeys("");
//			element = driver.findElement(By.name("password"));
			element = chromeDriver.findElement(By.xpath("//*[@id=\'login-passwd\']"));
			element.sendKeys(visitor.getPassword());
			System.out.println("85. " + visitor.getPassword());
			Thread.sleep(500);
//			element.findElement(By.name("verifyPassword")).click();
			element.findElement(By.xpath("//*[@id=\'login-signin\']")).click();
//			element.submit();
			Thread.sleep(500);
			


		String URL = "https://finance.yahoo.com/portfolio/p_0/view/v1";
		chromeDriver.navigate().to(URL);
		System.out.println("96. " + chromeDriver.getTitle());
		
		// xpath for popup close //*[@id="__dialog"]/section/button/svg
		// xpath for popup close //*[@id="__dialog"]/section/button/svg/path
		
		
		// dismiss popup ad
//		element.findElement(By.xpath("//*[@id=\'__dialog\']/section/button/svg/path")).click();
//		element.findElement(By.xpath("//html/body/dialog/section/button")).click();
//		element.sendKeys(Keys.ESCAPE);
		
//		chromeDriver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		chromeDriver.navigate().back();
		
		try {
			System.out.println("114. about to .quit()");
			Thread.sleep(10000);
			chromeDriver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
