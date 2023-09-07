package org.tcs.playwright.factoryClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageFactory {
    public Playwright playwright;
    public Browser browser;
    public BrowserContext browserContext;
    public Page page;

    public Page getPage(String browserName) {
        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(!true));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(!true));
                break;
            default:
                System.out.println("Please pass the right browser name...");
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        return page;
    }
}
