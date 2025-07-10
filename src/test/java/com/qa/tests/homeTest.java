package com.qa.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.baseTest;
import com.qa.pages.homePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

	public class homeTest extends baseTest{
	
	@Test(description="Launching the espn website")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Launching the espn website and getting games on the top")
	@Story("This week Game")
	public void homeTestpage() throws InterruptedException
	{
		homePage hp = new homePage(driver,log);
		hp.rejectCookiesPopUp();
		hp.numberOfMatches();
	    Assert.assertTrue(hp.noOfMatches() > 0, "Expected some matches to be listed");

	}

}
