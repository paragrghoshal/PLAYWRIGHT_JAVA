package org.tcs.playwright;

import org.tcs.playwright.baseClass.BaseTest;
import org.tcs.playwright.pageObjects.LandingPage;
import org.tcs.playwright.utility.extentreports.ExtentTestManager;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class clickGetStartedTest extends BaseTest
{

    @Test
    public void shouldAnswerWithTrue()
    {
        launchApplication();
        LandingPage landingPage = new LandingPage(getPage());
        landingPage.assertTitle();
        landingPage.clickGenStartedButton();  
    }    

    @Test
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
