package org.tcs.playwright.utility;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;

public class UtilityClass {

    public static String getdateTimeStamp(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return timeStamp;
    }
    public static void getScreenshot(Page page){
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screens/screenshot-"+getdateTimeStamp()+ ".png")));
    }
    
}
