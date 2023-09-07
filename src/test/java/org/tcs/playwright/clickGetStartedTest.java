package org.tcs.playwright;

import org.tcs.playwright.baseClass.BaseTest;
import org.tcs.playwright.pageObjects.LandingPage;
import org.testng.annotations.Test;


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
}
