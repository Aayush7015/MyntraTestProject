package com.aayush.MyntraApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePom  extends Page {

	public HomePagePom(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath  = "//input[@placeholder='Search for products, brands and more']")
	WebElement searchBox;
	
	@FindBy(xpath = "//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")
	WebElement searchBoxIcon;
	
	@FindBy(xpath = "//img[@title='HRX by Hrithik Roshan Unisex Back To School Shoes']")
	WebElement firstProduct;
	
	@FindBy(xpath = "//div[@id='sizeButtonsContainer']//div[5]")
	WebElement size;
	
	@FindBy(xpath = "//span[contains(@class,'pdp-price')]")
	WebElement unitPrice;
	
	@FindBy(xpath = "//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")
     WebElement 	addToBag;
	
	@FindBy(xpath = "//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")
	WebElement addToBagICon;
	
	@FindBy(xpath = "//div[contains(@class,'itemComponents-base-quantity')]")
	WebElement quantityDropdown;

	@FindBy(xpath = "//div[contains(@class,'dialogs-base-display')][normalize-space()='10']")
	WebElement quantityCount;
	
	@FindBy(xpath = "//div[normalize-space()='DONE']")
	WebElement quantityCountDone;
	
//	@FindBy(xpath = "//div[contains(@class,'itemComponents-base-price itemComponents-base-bold')]//div[1]")
//	WebElement unitPrice;
	
	@FindBy(xpath = "//div[contains(@class,'itemComponents-base-price itemComponents-base-bold')]")
	WebElement QuantityPrice;
	
	

	public void searchingBox() throws InterruptedException{
		searchBox.sendKeys("Women's Sneaker");
	}
	
	public void clickSearchIcon() {
		searchBoxIcon.click();
	}
	
	public void clickFirstProduct() {
		firstProduct.click();
	}
	
	public void captureUnitPrice() {
		System.out.println(unitPrice.getText());
	}
	
	public void selectSize() {
		size.click();
	}
	
	public void clickAddToBag() {
		addToBag.click();
	} 
	
	public void clickaddToBagIcon() {
		addToBagICon.click();
	}

//	public void captureUnitPrice() {
//		System.out.println(unitPrice.getText());
//	}
	
	public void selectingQuantityDropdown() {
		
//      wait = new WebDriverWait(driver, Config.WAIT_TIME );
//		wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown));

		waitForElementToBeClickable(quantityDropdown);
		quantityDropdown.click();
	}
	
	public void clickingQuantityCount() {
		
		
//	    wait = new WebDriverWait(driver, Config.WAIT_TIME );
//		wait.until(ExpectedConditions.elementToBeClickable(quantityCount));

		waitForElementToBeClickable(quantityCount);
		quantityCount.click();
	}
	
	public void clickingQuantityCountDone() {

//		 wait = new WebDriverWait(driver, Config.WAIT_TIME ); 
//		wait.until(ExpectedConditions.elementToBeClickable(quantityCountDone));
		
		waitForElementToBeClickable(quantityCountDone);
		quantityCountDone.click();
	}
	public void captureQuantityPrice() {
		waitForVisibility(QuantityPrice);
		System.out.println(QuantityPrice.getText());
	}
}

