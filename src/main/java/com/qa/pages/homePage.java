package com.qa.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class homePage {
	
	private WebDriver driver;
	private Logger log;
	@FindBy(xpath="//ul[@id='leagues']/li")
	List<WebElement> matches; 
	
	@FindBy(xpath="//div[@class='banner-actions-container']//button[text()='Reject All']")
	WebElement rejectCookies;

	
	public homePage(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
		PageFactory.initElements(driver, this);
	}
	
	
	public void isAlertPresnt()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try
		{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		al.accept();
		}catch(NoAlertPresentException e)
		{
			e.printStackTrace();
		}
	}
	
	public void rejectCookiesPopUp()
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));		
		wait.until(ExpectedConditions.elementToBeClickable(rejectCookies));
		rejectCookies.click();
		log.warn("Cookie pop up is displayed");
	}
	
	public void numberOfMatches() {
		
		System.out.println(matches.size());
		for(int i = 0; i< matches.size(); i++)
		{
			System.out.println( matches.get(i).findElement(By.tagName("h2")).getText());
		}
		log.info("Printed the mathes of this week");
	}
	
	public void printMethod()
	{
		System.out.println("Hello");
	}
	
	
}
