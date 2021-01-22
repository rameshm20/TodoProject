package com.todolist.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.todolist.utilities.XLUtils;
import com.todolist.pageobjects.HomePage;

public class TC_TodoTest_CompleteTask_004 extends BaseClass{
	
	@Test(dataProvider="TestData")
	public void todoTest(String message) throws IOException, InterruptedException {
		//browser initiation
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL entered");
		
		//creating and save task by clicking on button
		HomePage hp=new HomePage(driver);
		hp.clickSbmit();
		logger.info("Clicked on task button to create new task");		
		hp.inputTask(message);
		hp.clickSaveTask();		
		
		//checking the tool tip on unselected check box
		WebElement TextBox = driver.findElement(By.id("check1"));
		String tooltipText = TextBox.getAttribute("title"); 
		System.out.println("Retrieved tooltip text as :"+tooltipText);
		if(tooltipText.equalsIgnoreCase("Check if you've finished this task for today")){ 
			 System.out.println("Pass : Tooltip matching expected value");
			 Assert.assertTrue(true);
			 logger.info("tooltip is correct");
			 }
			 else{ 
			 System.out.println("Fail : Tooltip NOT matching expected value"); 
			 captureScreen(driver, "todoTest");
    			Assert.assertTrue(false);
 			logger.info("title is not correct");
			 } 
		
		hp.chkBox();
		
		
		
		//checking the tool tip on unselected check box
				WebElement TextBox1 = driver.findElement(By.id("today1"));
				String tooltipText1 = TextBox1.getAttribute("title"); 
				System.out.println("Retrieved tooltip text after selection :"+tooltipText1);
				if(tooltipText1.equalsIgnoreCase("Yes for today")){ 
					 System.out.println("Pass : Tooltip matching expected value");
					 Assert.assertTrue(true);
					 logger.info("tooltip is correct after selecting the check box ");
					 }
					 else{ 
					 System.out.println("Fail : Tooltip NOT matching expected value"); 
					 captureScreen(driver, "todoTest");
		    			Assert.assertTrue(false);
		 			logger.info("title is not correct  after selecting the check box ");
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
