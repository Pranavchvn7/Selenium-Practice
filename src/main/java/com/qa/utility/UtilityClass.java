package com.qa.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class UtilityClass extends TestBase {

	public UtilityClass() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	private WebElement add_to_cart;
	
	public void clickOnAddToCart()
	{
		add_to_cart.click();
	}
	
	public void acceptPopup()
	{
		driver.switchTo().alert().accept();
	}
	
	public String getPopupText() {
		return driver.switchTo().alert().getText();
	}
	
	public static String takeScreenShot(String name)
	{
		String des="C:\\Users\\Win-10\\Desktop\\R\\SELENIUM\\All_Pactice\\ScreenShots\\"+ name + System.currentTimeMillis()+".png";
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File fdes = new File(des);
			FileHandler.copy(src, fdes);
		} 
		catch (IOException e) 
		{
			System.out.println("File not found");
			e.printStackTrace();
		}
		return des;
	}
	
}
