package org.tcs.playwright.utility;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;

public class UtilityClass {

    public String getdateTimeStamp(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        return timeStamp;
    }
    public String getScreenshot(Page page){
        //String pathValue = System.getProperty("user.dir")+"/reports/screens/";
        String pathValue = "./reports/screens/";
        String fileName = "screenshot-"+getdateTimeStamp()+ ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(pathValue + fileName)));
        //return (Paths.get(filePath).toAbsolutePath()).toString();
        return ("./screens/"+fileName).toString();
    }
    
}
