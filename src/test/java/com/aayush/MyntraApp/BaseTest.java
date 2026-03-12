package com.aayush.MyntraApp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	
	public  WebDriver driver;


  @BeforeClass
  public void beforeClass() {
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.myntra.com/");
  }
  
  @Test
  void test() {
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
	  
  }

}
