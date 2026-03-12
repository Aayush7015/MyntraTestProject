package com.aayush.MyntraApp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest  extends BaseTest{
	 
	
	
	
  @Test
  public void f() {
	  
	  HomePagePom hp = new HomePagePom(driver);
 
	  
  }
  @BeforeClass
  public void beforeMethod() {
  }

  @AfterClass
  public void afterMethod() {
  }

}
