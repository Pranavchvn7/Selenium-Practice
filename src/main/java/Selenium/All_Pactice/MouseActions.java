package Selenium.All_Pactice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	WebDriver driver=new ChromeDriver();
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		MouseActions m=new MouseActions();
		m.DoubleClick();
		m.ContextClick();
		m.DragAndDrop();
		m.Hover();
	}
	
	public void DoubleClick() throws InterruptedException {
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement e = driver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));
		Actions actions=new Actions(driver);
		actions.doubleClick(e).perform();
		Thread.sleep(2000);
	}
	public void ContextClick() {
		driver.get("https://the-internet.herokuapp.com/context_menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action=new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//div[@id=\"hot-spot\"]"));
		action.contextClick(e).perform();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//h3")).click();
	}
	
	public void DragAndDrop(){
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action=new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath("//div[@id=\"column-a\"]"));
		WebElement ele2 = driver.findElement(By.xpath("//div[@id=\"column-b\"]"));
		action.clickAndHold(ele1).moveToElement(ele2).release().build().perform();
		
		action.dragAndDrop(ele2, ele1).build().perform();
	}
	public void Hover() throws InterruptedException{
		driver.get("https://the-internet.herokuapp.com/hovers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img"));
		WebElement ele2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/img"));
		WebElement ele3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/img"));
		
		Actions action=new Actions(driver);
		action.moveToElement(ele1).perform();
		Thread.sleep(2000);
		action.moveToElement(ele2).perform();
		Thread.sleep(2000);
		action.moveToElement(ele3).perform();
	}

}
