package com.qa.tests;

import java.time.Duration;

import org.testng.annotations.Test;

import com.qa.base.baseTest;
import com.qa.pages.homePage;

public class homeTest extends baseTest{
	
	@Test
	public void homeTestpage() throws InterruptedException
	{
		homePage hp = new homePage(driver,log);
		hp.rejectCookiesPopUp();
		hp.numberOfMatches();
	}

}
