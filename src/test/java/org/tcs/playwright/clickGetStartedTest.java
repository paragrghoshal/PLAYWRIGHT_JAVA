package org.tcs.playwright;

// import static org.junit.Assert.fail;

import org.junit.Assert;
import org.tcs.playwright.baseClass.BaseTest;
import org.tcs.playwright.listeners.Retry;
import org.tcs.playwright.pageObjects.LandingPage;
import org.tcs.playwright.utility.extentreports.ExtentTestManager;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class clickGetStartedTest extends BaseTest
{
int i =1;
    @Test(retryAnalyzer = Retry.class)
    public void TestOne()
    {
        launchApplication();
        LandingPage landingPage = new LandingPage(getPage());
        landingPage.assertTitle();
        landingPage.clickGenStartedButton();
        
        
        if ( i<=1){
         Assert.fail("FAILED HAI :"+i);
        }
        i++;
        
    }    

    @Test(retryAnalyzer = Retry.class)
    public void TestTwo()
    {
        launchApplication();
        ExtentTestManager.writeToReport(LogStatus.INFO,"This is not going to be fun");
        LandingPage landingPage = new LandingPage(getPage());
        landingPage.assertTitle();
        ExtentTestManager.writeToReport(LogStatus.PASS, getPage(),"Step1", "PARAG GHOSHAL JEE");
        landingPage.clickGenStartedButton();        
    } 
}
