package org.tcs.playwright.baseClass;

import org.tcs.playwright.factoryClass.PageFactory;
import org.tcs.playwright.utility.UtilityClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Page;
//import com.saucelabs.saucebindings.testng.SauceBaseTest;

public class BaseTest {
    Page page;
    PageFactory pageFactory = new PageFactory();
    protected static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        page = pageFactory.getPage("chromium");
        threadLocalPage.set(page);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

    }

    public Page getPage() {
        return threadLocalPage.get();
    }

    public void launchApplication() {
        getPage().navigate("http://playwright.dev");
        UtilityClass.getScreenshot(getPage());
    }

}
