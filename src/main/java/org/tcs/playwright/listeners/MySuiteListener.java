package org.tcs.playwright.listeners;

import org.tcs.playwright.utility.extentreports.ExtentTestManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentTestManager.endTest();
    }

    
}
