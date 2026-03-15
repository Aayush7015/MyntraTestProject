package com.aayush.MyntraApp;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest  extends BaseTest{
	 
  @Test
  public void UiTest() throws InterruptedException {
	  WebDriver driver = localWebDriver.get();
	  HomePagePom hp = new HomePagePom(driver);
	  hp.searchingBox();
	  hp.clickSearchIcon();
	  hp.clickFirstProduct();

	  Set<String> windows = driver.getWindowHandles();
	  for(String w : windows)
	  {
	      driver.switchTo().window(w);
	  }

	  hp.captureUnitPrice();   // ✅ now element exists
	  hp.selectSize();
	  hp.clickAddToBag();	
	  hp.clickaddToBagIcon();
//	  hp.captureUnitPrice();
	  hp.selectingQuantityDropdown();
	  hp.clickingQuantityCount();
	  hp.clickingQuantityCountDone();
	  hp.captureQuantityPrice(); 
  }
  
  
  @BeforeClass
  public void beforeMethod() {
	  
	  
  }

  @AfterClass
  public void afterMethod() {
	  
	  
  }

}
