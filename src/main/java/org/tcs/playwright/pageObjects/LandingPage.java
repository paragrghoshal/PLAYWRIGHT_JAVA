package org.tcs.playwright.pageObjects;

import java.util.regex.Pattern;

import org.tcs.playwright.baseClass.BasePageObject;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LandingPage extends BasePageObject{
    private String getSratedLocator = ".getStarted_Sjon";
    
    public LandingPage(Page page){
        super(page);
    }
    
    public void assertTitle(){
        assertThat(getPage()).hasTitle(Pattern.compile("Playwright"));
        //System.out.println
    }

    public void clickGenStartedButton(){
        getPage().click(getSratedLocator);
    } 
}
