package com.qa.testLayer;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utility.DataProviders;

public class DDTestCases extends TestBase {

	@Test(dataProvider="Data", dataProviderClass=DataProviders.class)
	public void contactFormTesting(String Email, String Name) throws InterruptedException {
		h.clickOnContact();
		Thread.sleep(2000);
		System.out.println(Email+" = "+Name);
		driver.findElement(By.xpath("//input[@id='recipient-email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@id='recipient-name']")).sendKeys(Name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Send message']")).click();
		Thread.sleep(2000);
		u.acceptPopup();
	}

}
