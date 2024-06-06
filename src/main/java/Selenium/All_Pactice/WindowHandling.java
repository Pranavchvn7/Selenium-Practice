package Selenium.All_Pactice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	WebDriver driver=new ChromeDriver();
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		WindowHandling w=new WindowHandling();
		w.Handler();
	}

	public void Handler() throws InterruptedException, AWTException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/links");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		
		WebElement button = driver.findElement(By.xpath("//a[@id=\"simpleLink\"]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", button);
		button.click();
		Set<String> all = driver.getWindowHandles();
		for(String s:all) {
			if(!parent.equals(s)) {
				driver.switchTo().window(s);
				System.out.println("Switched to child window...");
				System.out.println(driver.getTitle());
				Thread.sleep(2000);
				//code to close browser tab ctrl+w
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_W);
				r.keyRelease(KeyEvent.VK_W);
				r.keyRelease(KeyEvent.VK_CONTROL);
				
			}
		}
		driver.switchTo().parentFrame();
		System.out.println("Back to main page...");
	}
}
