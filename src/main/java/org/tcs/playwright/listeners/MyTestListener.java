package org.tcs.playwright.listeners;

import org.tcs.playwright.utility.extentreports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class MyTestListener implements ITestListener {
   

@Override
public void onFinish(ITestContext contextFinish) {

}

@Override
public void onStart(ITestContext contextStart) {

}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

}

@Override
public void onTestFailure(ITestResult result) {
    String message = " is failed";
    ExtentTestManager.writeToReport(LogStatus.FAIL,"Test " + result.getName() + message);
}

@Override
public void onTestSkipped(ITestResult result) {
    String message = " is failed and will be re-executed.";
    ExtentTestManager.writeToReport(LogStatus.SKIP,"Test " + result.getName() + message);
}

@Override
public void onTestStart(ITestResult result) {
    ExtentTestManager.startTest(result.getName());
}

@Override
public void onTestSuccess(ITestResult result) {
    String message = " is passed.";
    ExtentTestManager.writeToReport(LogStatus.PASS,"Test " + result.getName() + message);
}


    
}
