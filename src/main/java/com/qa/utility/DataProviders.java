package com.qa.utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {
		String path=System.getProperty("user.dir")+"//testData//userData.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rowCount=xl.getRowCount("Sheet1");
		int colCount=xl.getColCount("Sheet1", 1);
		
		String xldata[][]=new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				xldata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return xldata;
	}
}
