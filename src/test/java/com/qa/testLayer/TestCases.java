package com.qa.testLayer;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class TestCases extends TestBase {

	@Test()
	public void verifyBuyProcessOfSamsungGalaxyS6() throws InterruptedException 
	{
		System.out.println("Inside method 1");
		l.info("******test case: verifyBuyProcessOfSamsungGalaxyS6******");
		h.clickOnPhone();
		h.clickOnSamsungGalaxyS6();
		u.clickOnAddToCart();
		Thread.sleep(2000);
		System.out.println(u.getPopupText());
		Assert.assertEquals("Product added", u.getPopupText());
		Thread.sleep(2000);
		u.acceptPopup();
	}
	
	//@Test(dependsOnMethods={"verifyBuyProcessOfNexus6"})
	@Test
	public void verifyBuyProcessOfNokiaLumia1520() throws InterruptedException
	{
		System.out.println("Inside method 2");
		l.info("******test case: verifyBuyProcessOfNokiaLumia1520******");
		h.clickOnPhone();
		h.clickOnNokiaLumia1520();
		u.clickOnAddToCart();
		Thread.sleep(2000);
		System.out.println(u.getPopupText());
		Assert.assertEquals("Product added", u.getPopupText());
		Thread.sleep(2000);
		u.acceptPopup();
	}
	
	//@Test(priority=2, groups= {"sanity"})
	@Test
	public void verifyBuyProcessOfNexus6() throws InterruptedException
	{
		System.out.println("Inside method 3");
		l.info("******test case: verifyBuyProcessOfNexus6******");
		h.clickOnPhone();
		h.clickOnNexus6();
		u.clickOnAddToCart();
		Thread.sleep(2000);
		u.acceptPopup();
		Assert.fail();
	}
	
}
