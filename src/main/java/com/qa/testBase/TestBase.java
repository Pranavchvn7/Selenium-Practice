package com.qa.testBase;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.pageLayer.HomePage;
import com.qa.utility.UtilityClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public HomePage h;
	public UtilityClass u;
	public Logger l;
	
	@BeforeClass
	public void setup(){
		l=org.apache.logging.log4j.LogManager.getLogger(this.getClass());
		l.info("******DemoBlaze Automation Framework******");
	}
	
	@AfterClass
	public void end(){
		l.info("******Framework exection stopped******");
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void start(String br) {
		
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			l.info("******Browser launched******");
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please provide correct browser name");
		}
		
		driver.get("https://demoblaze.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		l.info("******Test Case exection started******");
		h=new HomePage();
		u=new UtilityClass();
	}
	
	@AfterMethod
	public void tearDown() {
		l.info("******Test Case exection stopped******");
		driver.quit();
		l.info("******Browser closed******");
	}
}
