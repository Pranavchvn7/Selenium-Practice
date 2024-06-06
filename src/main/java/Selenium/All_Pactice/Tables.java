package Selenium.All_Pactice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {
	WebDriver driver=new ChromeDriver();
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		Tables t=new Tables();
//		t.TablesWithTTag();
		t.TablesWithDivTag();
	}
	public void TablesWithTTag() {
		driver.get("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Printing all table data.
		WebElement table=driver.findElement(By.xpath("//table[@id=\"table1\"]"));
		List<WebElement> tr = table.findElements(By.tagName("tr"));
		for(WebElement e:tr) {
			System.out.println(e.getText()+"/t");
			System.out.println();
		}
		
		//Counting no of rows and columns
		int rowCount = tr.size();
		System.out.println("No of rows are: "+rowCount);
		List<WebElement> th = table.findElements(By.tagName("th"));
		int colCount=th.size();
		System.out.println("No of columns are: "+colCount);
		
		//Print or get value of single column from table
		List<WebElement> td = table.findElements(By.tagName("td"));//if table data has class name of data heading we can use same in xpath 
		int i=0;
		while(i<td.size()) {
			System.out.println(td.get(i).getText());
			i+=colCount;
			System.out.println();
		}
	}
	
	public void TablesWithDivTag() {
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Table column count
		List<WebElement> header = driver.findElements(By.className("rt-resizable-header-content"));
		System.out.println("No of columns: "+header.size());
		for(WebElement e:header) {
			System.out.println(e.getText());
		}
		
		//Table row count
		List<WebElement> rows = driver.findElements(By.className("rt-tr-group"));
		System.out.println("No of rows: "+rows.size());
		
		//print specific column from table
		List<WebElement> data = driver.findElements(By.xpath("//div[@class=\"rt-td\"]"));
		int i=2;
		while(i<data.size()) {
			System.out.println(data.get(i).getText()+"     ");
			i+=header.size();
		}
	}

}
