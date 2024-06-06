package Selenium.All_Pactice;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introduction_and_Cookiess {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https:\\www.amazon.in");
		//driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		Point p=new Point(100,100);
		driver.manage().window().setPosition(p);
		System.out.println(driver.manage().window().getPosition());
		Thread.sleep(2000);
		Dimension d=new Dimension(500,500);
		driver.manage().window().setSize(d);
		System.out.println(driver.manage().window().getSize());
		Thread.sleep(2000);
		
		
		//get all cookies
		Set<Cookie> cookiess = driver.manage().getCookies();
		System.out.println("All Cookies: ");
		for(Cookie e:cookiess) {
			System.out.println(e.getName()+" "+e.getValue());
		}
		
		//get specific cookie
		System.out.println(driver.manage().getCookieNamed("session-id-time"));
		
		//delete all cookies
		driver.manage().deleteAllCookies();
		
		driver.quit();
	}

}
