package org.tcs.playwright;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.tcs.playwright.baseClass.BaseTest;
import org.tcs.playwright.listeners.Retry;
import org.tcs.playwright.pageObjects.LandingPage;
import org.tcs.playwright.utility.extentreports.ExtentTestManager;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class clickGetStartedTest extends BaseTest
{

    @Test(retryAnalyzer = Retry.class)
    public void shouldAnswerWithTrue()
    {
        launchApplication();
        LandingPage landingPage = new LandingPage(getPage());
        landingPage.assertTitle();
        landingPage.clickGenStartedButton();
        //Assert.fail("FAILED HAI"); 
    }    

    @Test(retryAnalyzer = Retry.class)
    public void shouldAnswerWithFalse()
    {
        launchApplication();
        ExtentTestManager.writeToReport(reporterTest, LogStatus.INFO,"This is not going to be fun");
        LandingPage landingPage = new LandingPage(getPage());
        landingPage.assertTitle();
        ExtentTestManager.writeToReport(reporterTest, LogStatus.PASS, getPage(),"Step1", "PARAG GHOSHAL JEE");
        landingPage.clickGenStartedButton();        
    } 
}
