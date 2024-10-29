package com.practicetestautomation;

import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    private final static String CORRECT_USERNAME = "student";
    private final static String CORRECT_PASSWORD = "Password123";
    private final static String WRONG_PASSWORD = "Password12";
    private static final String WRONG_USERNAME = "student1";

    @Test
    public void test_Login_With_Success (){
        LoginPage loginPage = new LoginPage(page);
        loginPage.runLogin(CORRECT_USERNAME,CORRECT_PASSWORD);

        HomePage homePage = new HomePage(page);
        assertThat(homePage.getHeader()).hasText("Logged In Successfully");
    }

    @Test
    public void test_Login_With_Wrong_Password (){
        LoginPage loginPage = new LoginPage(page);
        loginPage.runLogin(CORRECT_USERNAME,WRONG_PASSWORD);

        HomePage homePage = new HomePage(page);
        assertThat(loginPage.getError()).hasText("Your password is invalid!");
    }

    @Test
    public void test_Login_With_Wrong_Username (){
        LoginPage loginPage = new LoginPage(page);
        loginPage.runLogin(WRONG_USERNAME,CORRECT_PASSWORD);

        HomePage homePage = new HomePage(page);
        assertThat(loginPage.getError()).hasText("Your username is invalid!");
    }
}
