package com.framework.webdriver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.framework.reports.ReportsClass;
import com.framework.utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass extends ReportsClass {
	
	public static WebDriver driver = null;
	public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	@BeforeMethod(alwaysRun= true)
	@Parameters (value="browser") 
	public void setupBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
				
	    }else if(browser.equalsIgnoreCase("edge")) {
		     WebDriverManager.edgedriver().setup();
		     driver= new EdgeDriver();
	}else {
		Assert.fail("Invalid Browser selectedfrombrowser");
	}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		setDriver(driver);

	}
	@AfterMethod(alwaysRun = true)
	public void tearDownBrowser() {
		driver.quit();
	}
	public static synchronized void setDriver(WebDriver driver) {
		thread.set(driver);
	}
	
	public static synchronized WebDriver getDriver() {
		return thread.get();
	}
	
	
	
	
	@DataProvider(name="loginData")
	public String [][] testdata(){
		String [][] data =ReadExcel.readData("TestData.xlsx", "Sheet1");
		return data;
	}

}
	
	

