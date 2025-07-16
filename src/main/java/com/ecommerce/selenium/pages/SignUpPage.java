package com.ecommerce.selenium.pages;

import com.ecommerce.selenium.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    public static SignUpPage signUpPage;

    //Elements
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By signUpButton = By.cssSelector("button[type='submit']");
    private final By positiveSignInNotification = By.id("1");
    private final By emailAlreadyTakenNotification = By.id("email-helper-text");

    // Private constructor - Singleton Design Pattern
    private SignUpPage() {super();}

    // Methods
    public static SignUpPage getInstance() {
        if (signUpPage == null) {
            signUpPage = new SignUpPage();
        }
        return signUpPage;
    }

    @Step("Visit the sign up page")
    public void getUrl(WebDriver driver) { driver.get(ConfigUtils.getInstance().getBaseUrl() + "/register"); }

    @Step("Sign up new account to the application")
    public void signUp(WebDriver driver, String email, String password) {
        System.out.println("""
                LOGIN DATA
                Email:\s""" + email + """
                \nPassword:\s""" + password + """
                \n---------------------------""");

        enterTextIntoTextBox(driver, emailInput, email);
        enterTextIntoTextBox(driver, passwordInput, password);

        if(ifSignUpButtonActive(driver)) clickLinkOrBtn(driver, signUpButton);
    }

    public boolean ifSignUpNotificationPopUp(WebDriver driver){
        return findElementBy(driver, positiveSignInNotification).isEnabled();
    }

    public boolean ifSignUpButtonActive(WebDriver driver){
        try {
            clickLinkOrBtn(driver, signUpButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean ifEmailTaken(WebDriver driver) {
        return findElementBy(driver, emailAlreadyTakenNotification).isDisplayed();
    }
}
