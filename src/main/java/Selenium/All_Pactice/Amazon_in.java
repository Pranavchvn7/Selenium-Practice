package Selenium.All_Pactice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazon_in {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	//@Test(priority=1)
	public void testOrderPlacement() throws InterruptedException {
		WebElement search=driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		search.sendKeys("iphone 15");
		Thread.sleep(2000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement phone=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", phone);
		Thread.sleep(2000);
		phone.click();
		Thread.sleep(5000);
		String main=driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		for(String s:all) {
			if(!(s.equals(main))) {
				driver.switchTo().window(s);
//				Thread.sleep(8000);
//				System.out.println(s);
//				js.executeScript("location.reload();");
				WebElement cart=driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[8]/div[8]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span"));
				Thread.sleep(8000);
				js.executeScript("arguments[0].scrollIntoView(true);", cart);
				cart.click();
				Thread.sleep(5000);
			}
		}
	}
	
	//@Test(priority=2)
	public void testCategoriesSelect() throws InterruptedException {
		WebElement clist=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		Select s=new Select(clist);
		List<WebElement> all = s.getOptions();
		for(WebElement e: all) {
			System.out.println(e.getText());
		}
		Thread.sleep(2000);
		s.selectByIndex(2);
		Thread.sleep(2000);
	}

	@Test(priority=3)
	public void testLoginAndOrderHistory() throws InterruptedException {
		WebElement nav=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
		nav.click();
		Thread.sleep(2000);
		WebElement user=driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		user.sendKeys("prnvchavan7@gmail.com");
		user.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement pass=driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		pass.sendKeys("Corona@2019");
		pass.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("location.reload();");
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[2]/h2")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
