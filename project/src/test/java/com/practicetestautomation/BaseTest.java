package com.practicetestautomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private static Playwright playwright;
    private static Browser browser;
    Page page;

    @BeforeAll
    public static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    public void setup(){
        page = browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterEach
    public void tearDown(){
        page.close();
    }

    @AfterAll
    public static void afterAll(){
        browser.close();
        playwright.close();
    }
}
