package com.aayush.MyntraApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	public Page(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT_TIME);
		  wait = new WebDriverWait(driver, Config.WAIT_TIME );
		PageFactory.initElements(driver, this);
	}

	
	 public WebElement  waitForVisibility(WebElement element ) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 

	 public WebElement  waitForElementToBeClickable(WebElement element ) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	 }

}
