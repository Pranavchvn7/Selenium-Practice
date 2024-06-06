package com.qa.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case execution started :- " +result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case execution Passed :- " +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case execution Failed :- " +result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case execution Skipped :- " +result.getName());
	}

}
