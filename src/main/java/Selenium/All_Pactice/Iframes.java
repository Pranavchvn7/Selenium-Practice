package Selenium.All_Pactice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Iframes {
	WebDriver driver=new ChromeDriver();
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		Iframes i=new Iframes();
		
		//i.frames();
		i.frame();
	}
	public void frames() throws InterruptedException {
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id=\"a077aa5e\"]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", frame);
		Thread.sleep(2000);
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/a/img")).click();
		
	}
	
	public void frame() {
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement frame = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/iframe"));
		driver.switchTo().frame(frame); //You can use index and name or id of the Frame.
		driver.findElement(By.xpath("/html/body/p")).sendKeys("Pranav Chavan");
		driver.switchTo().defaultContent();//switch focus to main page
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[1]/button[1]/span")).click();
	}

}
