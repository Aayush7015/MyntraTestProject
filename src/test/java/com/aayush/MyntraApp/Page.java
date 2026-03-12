package com.aayush.MyntraApp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	public Page(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}


	
	
	
}
