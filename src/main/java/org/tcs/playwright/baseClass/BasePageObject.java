package org.tcs.playwright.baseClass;

import com.microsoft.playwright.Page;

public class BasePageObject {
    private final Page page;

    public BasePageObject(Page page){
        this.page = page;
    }

    protected Page getPage(){
        return this.page;
    }
    
}
