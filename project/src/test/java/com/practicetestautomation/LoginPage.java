package com.practicetestautomation;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    Page page;

    public LoginPage(Page page){
        this.page=page;
    }

    private Locator getInputUsername(){
        return page.locator("#username");
    }

    private Locator getInputPassword(){
        return page.locator("#password");
    }

    private Locator getLoginButton(){
        return page.locator("#submit");
    }

    public Locator getLoginStatus(){
        return page.locator("#login-status");
    }

    public void informUsername(String username){
        getInputUsername().fill(username);
    }

    public void informPassword(String password){
        getInputPassword().fill(password);
    }

    public void clickLogin(){
        getLoginButton().click();
    }

    public String getLoginStatusMessage(){
        return getLoginStatus().innerText();
    }

    public void runLogin(String username, String password){
        informUsername(username);
        informPassword(password);
        clickLogin();
    }

    public Locator getError () {
        return page.locator("#error");
    }
}
