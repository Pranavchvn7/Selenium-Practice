package Selenium.All_Pactice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOption {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("platformName","Windows 10");
		m.put("acceptInsecureCerts", true);
		options.setExperimentalOption("prefs", m);
		
		//start browser maximized
		options.addArguments("--start-maximized");
		
		//disable images on web page
		options.addArguments("--blink-settings=imagesEnabled=false");
		
		//headless mode
		 //options.addArguments("--headless");

		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.google.com/search?q=city&sca_esv=013f07408305043b&hl=en&source=hp&biw=1366&bih=607&ei=NZ4_ZraCNriG4-EP9p2z0A4&iflsig=AL9hbdgAAAAAZj-sRZhr7ghNzFPWz1CIIPRsXAJk6R0b&ved=0ahUKEwj28Obeg4aGAxU4wzgGHfbODOoQ4dUDCAc&uact=5&oq=city&gs_lp=EgNpbWciBGNpdHkyCBAAGIAEGLEDMggQABiABBixAzIIEAAYgAQYsQMyCBAAGIAEGLEDMgUQABiABDIIEAAYgAQYsQMyCBAAGIAEGLEDMggQABiABBixAzIIEAAYgAQYsQMyCxAAGIAEGLEDGIMBSMIIUABYwAZwAHgAkAEAmAFtoAGkA6oBAzAuNLgBA8gBAPgBAYoCC2d3cy13aXotaW1nmAIEoALHA8ICBBAAGAOYAwCSBwMwLjSgB8MS&sclient=img&udm=2");
	}

}
