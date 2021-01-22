package com.todolist.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath=("//*[@value='Create your Daily Todo list']"))
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(name="tasks")
	@CacheLookup
	WebElement inputTask;
	
	@FindBy(xpath=("//*[@value='Save tasks']"))
	@CacheLookup
	WebElement btnSaveTask;
	
	@FindBy(xpath=("//*[@id=\"t1\"]"))
	@CacheLookup
	WebElement taskActualVal;
	
	@FindBy(tagName="a")
	@CacheLookup
	WebElement btnCancel;
	
	@FindBy(xpath=("//*[@id=\"headline\"]/a"))
	@CacheLookup
	WebElement btnEdit;
	
	@FindBy(xpath=("//*[@id=\"check1\"]"))
	@CacheLookup
	WebElement chkBox;
	
	@FindBy(xpath=("//*[@id=\"today1\"]"))
	@CacheLookup
	WebElement rdbtn;
	
	
	
	
	public void clickSbmit() {
		btnSubmit.click();
	}
	
	public void clickSaveTask() {
		btnSaveTask.click();
	}
	
	public void clickCancel() {
		btnCancel.click();
	}
	
	public void clickEdit() {
		btnEdit.click();
	}
	public void inputTask(String message) {
		inputTask.sendKeys(message);
	}
	
	public void taskActualVal() {
		taskActualVal.getText();
	}
	
	public void chkBox() {
		chkBox.click();
	}
	
	public void rdbtn() {
		rdbtn.click();
	}


}
