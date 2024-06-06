package Selenium.All_Pactice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
//		Thread.sleep(5000);
//		driver.findElement(By.name("pass")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("email")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.className("_8esh")).click();
//		Thread.sleep(4000);
//		driver.navigate().back();
//		Thread.sleep(4000);
//		driver.findElement(By.linkText("Create a Page")).click();
//		Thread.sleep(4000);
//		driver.navigate().back();
//		Thread.sleep(4000);
//		driver.findElement(By.partialLinkText("Page")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.tagName("button")).click();
		
//		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input")).sendKeys("Vasim"); //single slash absolute xpath
//		driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys("abc@gmail.com"); //relative xpath //tagnm[@att='value']
//		driver.findElement(By.xpath("//button[@class=\"_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy\"][@name=\"login\"]")).click(); //relative xpath multiple attributes
//		driver.findElement(By.xpath("//button[@class=\"_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy\" and @name=\"login\"]")).click(); //relative xpath using and
//		driver.findElement(By.xpath("//button[@class=\"_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy\" or @name=\"login\"]")).click(); //relative xpath using or
//		driver.findElement(By.xpath("//button[contains(@name,'login')]")).click(); //relative xpath using contains //tagnm[contains(@att,value)] //tagnm[contains(text(),'value')]
//		driver.findElement(By.xpath("//a[text()=\"Forgotten password?\"]")).click(); //using relative xpath text() function //tagnm[text()="text"]
		By pass = RelativeLocator.with(By.tagName("input")).below(By.id("email"));//creating By value using RelativeLocator from selenium 4
		driver.findElement(pass).sendKeys("Pranav"); //using RelativeLocator in findElement
	}

}
