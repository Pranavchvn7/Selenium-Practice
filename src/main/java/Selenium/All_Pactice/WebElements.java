package Selenium.All_Pactice;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElements {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win-10\\Desktop\\Java\\Eclipse\\chromedriver.exe");
		driver=new ChromeDriver();
		WebElements w=new WebElements();
//		w.TextBoxs();
//		w.Buttons();
//		w.CheckBoxes();
		w.RedioButtons();
//		w.ButtonDropDowns();
//		w.DropDowns();
//		w.FullWebForm();
		
		//Get all web elements
		List<WebElement> elements = driver.findElements(By.xpath("//*"));
		for(WebElement e:elements) {
			System.out.println(e.getTagName()+" "+" "+e.getText());
		}
	}
	
	public void TextBoxs() {
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id=\"userName\"]")).sendKeys("Pranav Chavan");
		driver.findElement(By.xpath("//input[@id=\"userEmail\"]")).sendKeys("anv@gmail.com");
		WebElement textarea1 = driver.findElement(By.xpath("//textarea[@id=\"currentAddress\"]"));
		textarea1.sendKeys("Nagavara");
		textarea1.sendKeys(Keys.ENTER);
		textarea1.sendKeys("Bangalore");
		WebElement textarea2=driver.findElement(By.xpath("//textarea[@id=\"permanentAddress\"]"));
		textarea2.sendKeys("Anand Niwas");
		textarea2.sendKeys(Keys.ENTER);
		textarea2.sendKeys("Sangli Wadi");
		WebElement button=driver.findElement(By.xpath("//Button[@id=\"submit\"]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", button);
		button.click();
	}
	
	public void Buttons() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/buttons");
		driver.manage().window().maximize();
		
		System.out.println("Buttons________________");
		driver.findElement(By.xpath("//button[text()='Primary']")).click();
		System.out.println("Primary Button Clicked.");
		
		driver.findElement(By.xpath("//button[@id=\"btnGroupDrop1\"]")).click();
		Thread.sleep(4000);
		WebElement drop1 = driver.findElement(By.xpath("//a[text()='Dropdown link 1']"));
		System.out.println(drop1.getText()+" clicked");
		drop1.click();
		
	}
	
	public void CheckBoxes() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/checkbox");
		driver.manage().window().maximize();
		
		System.out.println("CheckBox___________________________");
		WebElement c1=driver.findElement(By.xpath("//input[@id='checkbox-1']"));
		WebElement c2=driver.findElement(By.xpath("//input[@id='checkbox-2']"));
		WebElement c3=driver.findElement(By.xpath("//input[@id='checkbox-3']"));
		
		c1.click();
		Thread.sleep(2000);
		c3.click();
		System.out.println(c1.isSelected());
		System.out.println(c2.isSelected());
		System.out.println(c3.isSelected());
		Thread.sleep(2000);
		c1.click();
		c3.click();
		Thread.sleep(2000);
		System.out.println(c1.isSelected());
		System.out.println(c2.isSelected());
		System.out.println(c3.isSelected());
	}
	
	public void RedioButtons() throws InterruptedException {
//		driver.get("https://formy-project.herokuapp.com/radiobutton");
//		driver.manage().window().maximize();
//		
//		System.out.println("RedioButtons____________________________");
//		WebElement r1=driver.findElement(By.xpath("//input[@id=\"radio-button-1\"]"));
//		WebElement r2=driver.findElement(By.xpath("//input[@value=\"option2\"]"));
//		WebElement r3=driver.findElement(By.xpath("//input[@value=\"option3\"]"));
//		r1.click();
//		System.out.println(r1.isSelected());
//		System.out.println(r2.isSelected());
//		System.out.println(r3.isSelected());
//		Thread.sleep(2000);
//		r2.click();
//		System.out.println(r1.isSelected());
//		System.out.println(r2.isSelected());
//		System.out.println(r3.isSelected());
		
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//label[@for=\"yesRadio\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//label[@for=\"noRadio\"]")).isEnabled());
	}
	
	public void ButtonDropDowns() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/dropdown");
		driver.manage().window().maximize();
		
		//Button drop down without select method
		WebElement drop=driver.findElement(By.xpath("//button[@id=\"dropdownMenuButton\"]"));
		drop.click();
		Thread.sleep(2000);

		List<WebElement> alloptions = driver.findElements(By.tagName("a"));
		for(WebElement e:alloptions) {
			System.out.println(e.getText());
		}
	}
	
	public void DropDowns() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.manage().window().maximize();
		
		WebElement drop=driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
		Select s=new Select(drop);
		
		List<WebElement> alloptions = s.getOptions();
		for(WebElement e:alloptions) {
			System.out.println(e.getText());
		}
		
		System.out.println(s.isMultiple());
		s.selectByIndex(1);
		Thread.sleep(2000);
		//s.deselectByIndex(1);//deselect options are valid only multiple select option is available
	}
	
	public void FullWebForm() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/form");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("Pranav");
		driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("Chavan");
		driver.findElement(By.xpath("//input[@id=\"job-title\"]")).sendKeys("Software Test Engineer");
		driver.findElement(By.xpath("//input[@id=\"radio-button-2\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"checkbox-1\"]")).click();
		WebElement drop = driver.findElement(By.xpath("//select[@id=\"select-menu\"]"));
		Select s=new Select(drop);
		s.selectByIndex(3);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("02/24/2000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class=\"btn btn-lg btn-primary\"]")).click();
	}
}
