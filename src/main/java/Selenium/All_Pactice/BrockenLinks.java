package Selenium.All_Pactice;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrockenLinks {
	WebDriver driver=new ChromeDriver();
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		BrockenLinks b=new BrockenLinks();
		b.link();
	}
	public void link() {
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement e:links) {
			String s=e.getAttribute("href");
			System.out.println(s);
			verify(s);
		}
	}
	public void verify(String lurl) {
		try {
			URL url=new URL(lurl);
			HttpsURLConnection hc= (HttpsURLConnection)url.openConnection();
			hc.setConnectTimeout(10000);
			hc.connect();
			
			if(hc.getResponseCode()>=400) {
				System.out.println(lurl+" "+hc.getResponseMessage()+" is Brocken.");
			}
//			else {
//				System.out.println(lurl+" "+hc.getResponseMessage());
//			}
		}
		catch(Exception e) {
			
		}
	}
}
