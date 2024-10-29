package com.practicetestautomation;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    Page page;
    public HomePage(Page page){
        this.page = page;
    }

    public Locator getHeader(){
        return page.locator(".post-title");
    }

    public String getHeaderPageText(){
        return getHeader().innerText();
    }
}
