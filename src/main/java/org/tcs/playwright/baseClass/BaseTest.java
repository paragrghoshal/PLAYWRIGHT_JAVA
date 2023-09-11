package org.tcs.playwright.baseClass;

import java.lang.reflect.Method;

import org.tcs.playwright.factoryClass.PageFactory;
import org.tcs.playwright.listeners.Retry;
import org.tcs.playwright.utility.UtilityClass;
import org.tcs.playwright.utility.extentreports.ExtentTestManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(org.tcs.playwright.listeners.ExtentReporterTestNG.class)
@Listeners(org.tcs.playwright.listeners.MyTestListener.class)
public class BaseTest {
    Page page;
    PageFactory pageFactory = new PageFactory();
    protected static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();
    protected ExtentReports extentreports;
    protected ExtentTest reporterTest;
    protected UtilityClass utils = new UtilityClass();

    @BeforeSuite
    public void initiateExtentReport(){
    }

    @AfterSuite
    public void endExtentReport(){
     ExtentTestManager.endTest(); 
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {
        page = pageFactory.getPage("chromium");
        threadLocalPage.set(page);
        reporterTest = ExtentTestManager.startTest(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
    if(result.getStatus()==result.SUCCESS){
        ExtentTestManager.writeToReport(reporterTest,LogStatus.PASS,"Test Passed");
    } else if (result.getStatus()==result.FAILURE) {
        ExtentTestManager.writeToReport(reporterTest,LogStatus.FAIL,"Test Failed: "+ result.getThrowable());
    }

    }

    public Page getPage() {
        return threadLocalPage.get();
    }

    public void launchApplication() {
        getPage().navigate("http://playwright.dev");
    }

}
