package com.todolist.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.todolist.utilities.XLUtils;
import com.todolist.pageobjects.HomePage;

public class TC_TodoTest_CreateTask_001 extends BaseClass{
	
	@Test(dataProvider="TestData")
	public void todoTest(String message) throws IOException {
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL entered");
		
		
		if (driver.findElement(By.linkText("DailyTodo.org")).getText().contains("DailyTodo")) {
			Assert.assertTrue(true);
			logger.info("page logo is correct");
		}else {
			captureScreen(driver, "todoTest");
			Assert.assertTrue(false);
			logger.info("Page logo is not correct");
		}
		 
		HomePage hp=new HomePage(driver);
		hp.clickSbmit();
		logger.info("Clicked on task button to create new task");		
		hp.inputTask(message);
		hp.clickSaveTask();		
		
		
		
		if(driver.findElement(By.xpath("//*[@id=\"t1\"]")).getText().contains(message)) {
			Assert.assertTrue(true);
			logger.info("task is correctly dosplayed");
		}else {
			captureScreen(driver, "todoTest");
			Assert.assertTrue(false);
			logger.info("task is not correctly dosplayed");
		}
		 
	}	
	
	@DataProvider(name="TestData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/todolist/testdata/TestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String testdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				testdata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return testdata;
	}
	
}
