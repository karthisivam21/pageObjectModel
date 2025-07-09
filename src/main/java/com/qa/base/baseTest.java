package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {

	protected WebDriver driver;
    protected Logger log = LogManager.getLogger(baseTest.class);

	@BeforeMethod
	public void setUp() {
		
		Properties prop = new Properties();
		
		try {
			FileInputStream fs = new FileInputStream(new File("C:\\Users\\Karthika p\\eclipse-workspace\\selenium-fw\\src\\test"
					+ "\\resources\\envval.properties"));
			prop.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		if(browser.equals("chrome"))
			driver = new ChromeDriver();
		driver.get(url);
		log.info("Launched browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.debug("it is closeed. debug");
	}
}
