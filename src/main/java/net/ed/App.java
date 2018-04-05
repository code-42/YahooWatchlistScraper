package net.ed;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		Visitor visitor = (Visitor)context.getBean("visitor");
		String username = "edev42@yahoo.com";
		String password = "incorrect42";
		visitor.setUsername(username);
		visitor.setPassword(password);

		System.out.println("main() " + username);
		
		((FileSystemXmlApplicationContext) context).close();

	}


}
