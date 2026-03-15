package com.aayush.MyntraApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
//	public  WebDriver driver;
//  @BeforeClass
//  public void beforeClass() {
//	  driver = new ChromeDriver();
//	  driver.manage().window().maximize();
//	  driver.get("https://www.myntra.com/");
//  }
//  @Test
//  void test() {
//  
//  }
//  @AfterClass
//  public void afterClass() {
//	  driver.quit();
//	  
//	  
//  }
  
  
//	 protected WebDriver driver;
	    protected ExtentTest test;

	    private static ExtentReports extent;
	    public ThreadLocal<ExtentTest>  localTest = new ThreadLocal<>();
	    public ThreadLocal<WebDriver> localWebDriver = new ThreadLocal<WebDriver>();

	    @BeforeSuite
	    public void initReport() {
	        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/Report.html");
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	    }

	    @BeforeMethod
	    public void setUp(java.lang.reflect.Method method) {
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.myntra.com/");
	        localWebDriver.set(driver);
	        test = extent.createTest(method.getName());
	        localTest.set(test);
	    }

	    @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            // Capture screenshot
	            File src = ((TakesScreenshot) localWebDriver.get()).getScreenshotAs(OutputType.FILE);
	            String path = "test-output/screenshots/" + result.getName() + ".png";
	            Files.createDirectories(Paths.get("test-output/screenshots/"));
	            Files.copy(src.toPath(), Paths.get(path),StandardCopyOption.REPLACE_EXISTING);

	            // Log failure + attach screenshot
	          //  test.fail(result.getThrowable());
	            localTest.get().fail(result.getThrowable());
	          localTest.get().addScreenCaptureFromPath("screenshots/" + result.getName() + ".png");

	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	            localTest.get().pass("Test passed");
	        } else {
	        	 localTest.get().skip("Test skipped");
	        }
	      localWebDriver.get().quit();
	      //  driver.quit();
	    }
	    @AfterSuite
	    public void flushReport() {
	        extent.flush();
	    }
  
  
  

}
