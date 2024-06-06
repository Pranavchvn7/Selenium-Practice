package Selenium.All_Pactice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUpload_Download {
	WebDriver driver=new ChromeDriver();
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		FileUpload_Download f=new FileUpload_Download();
		//f.upload();
		f.robotupload();
		//f.download();
	}

	public void upload() {
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement up = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
		up.sendKeys("C:\\Users\\Win-10\\Downloads\\Preview.png");
		driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();
	}
	
	public void robotupload() throws AWTException, InterruptedException {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]/div/div[1]/span[1]")).click();
		Thread.sleep(2000);
		
		//Copying file path to clipboard 
		StringSelection str=new StringSelection("C:\\Users\\Win-10\\Pictures\\Screenshots\\Screenshot.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		//Creating Robot class
		Robot r=new Robot();
		
		//press ctrl+v for pasting
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		//release ctrl+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		//press and release Enter.
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]/div/div[1]/button[1]")).click();
	}
	
	public void download() {
		//Change default download path for Chrome browser
		Map<String, Object> p=new HashMap<String, Object>();
		p.put("download.default_directory", "C:\\Users\\Win-10\\Desktop\\R\\SELENIUM");
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", p);
		ChromeDriver driver1=new ChromeDriver(options);
		
		driver1.get("https://demo.automationtesting.in/FileDownload.html");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("argument[0].scrollIntoView(true);",e);
		
		driver1.findElement(By.xpath("//a[text()='Download']")).click();
	}
}