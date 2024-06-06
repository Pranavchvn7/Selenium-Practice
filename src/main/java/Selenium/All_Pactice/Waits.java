package Selenium.All_Pactice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	WebDriver driver=new ChromeDriver();
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		Waits w=new Waits();
		w.ExplisitWait();
		w.FluentWait();
	}
	
	public void ExplisitWait() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Implicit Wait
		
		//Explicit Wait
		WebElement checkbox = driver.findElement(By.xpath("//input[contains(@type,'checkbox')]	"));
		checkbox.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click(); //remove button clicked
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id=\"message\"]"))));//wait till label is visible
		WebElement label = driver.findElement(By.xpath("//p[@id=\"message\"]"));//get label details
		System.out.println(label.getText());//print
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();//proceed click add
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id=\"message\"]"))));//wait till label is visible
		driver.findElement(By.xpath("//input[contains(@type,'checkbox')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//p[@id=\"message\"]")).getText());
	}
	
	public void FluentWait() {
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//Implicit wait
		
		//Fluent Wait
		driver.findElement(By.xpath("//button[contains(text(),\"Enable\")]")).click();
		Wait<WebDriver> fw=new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))//Fluent wait defined
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		fw.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type=\"text\"]"))));//wait for element visibility
		System.out.println(driver.findElement(By.xpath("//p[@id=\"message\"]")).getText());//proceed
	}
}
