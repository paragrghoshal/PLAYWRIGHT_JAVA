package org.tcs.playwright.utility.extentreports;

import java.util.HashMap;
import java.util.Map;

import org.tcs.playwright.utility.UtilityClass;

import com.microsoft.playwright.Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTestManager {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();
    static UtilityClass utils = new UtilityClass();

	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.startTest(testName);//.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

	public static ExtentReports getExtentReportsInstance(){
		return extent;
	}

    public static void writeToReport(ExtentTest test, LogStatus logStatus, Page page,String expectedString ,String actualString){
        test.log(logStatus,expectedString,test.addScreenCapture(utils.getScreenshot(page))+actualString);
    }

    public static void writeToReport(ExtentTest test, LogStatus logStatus, String expectedString ,String actualString){
        test.log(logStatus,expectedString,actualString);
    }

	public static void writeToReport(ExtentTest test, LogStatus logStatus,String actualString){
		writeToReport(test,logStatus,"",actualString);
    }
    
}
