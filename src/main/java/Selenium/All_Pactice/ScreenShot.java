package Selenium.All_Pactice;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		int date=(int) new Date().getTime();
		System.out.println(date);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\Win-10\\Desktop\\R\\SELENIUM\\All_Pactice\\ScreenShots\\new"+date+".png";
		File des=new File(path);
		FileHandler.copy(src, des);
		Thread.sleep(4000);
		
		WebElement img=driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		File src1=img.getScreenshotAs(OutputType.FILE);
		String path1="C:\\Users\\Win-10\\Desktop\\R\\SELENIUM\\All_Pactice\\ScreenShots\\sub"+date+".png";
		File des1=new File(path1);
		FileHandler.copy(src1, des1);
		driver.quit();
	}

}
