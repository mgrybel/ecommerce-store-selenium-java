package com.ecommerce.selenium.pages;

import com.ecommerce.selenium.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public static LoginPage loginPage;

    // Elements
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("signIn");
    private final By myOrdersLink = By.id("orders");

    // Private constructor - Singleton Design Pattern
    private LoginPage() {}

    public static LoginPage getInstance() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    // Methods (steps)

    @Step("Visit the Sign in page")
    public void getUrl(WebDriver driver) {
        driver.get(ConfigUtils.getInstance().getBaseUrl() + "/login");
    }

    @Step("Sign in to the application")
    public void login(WebDriver driver) {
        // driver.findElement(emailInput).sendKeys("bob@test.com");
        // driver.findElement(passwordInput).sendKeys("Pass12345!");
        // driver.findElement(signInButton).click();

        enterTextIntoTextBox(driver, emailInput, "bob@test.com");
        enterTextIntoTextBox(driver, passwordInput, "Pass12345!");
        clickLinkOrBtn(driver, signInButton);
    }

    public String getMyOrders(WebDriver driver) {
        WebElement myOrders = findElementBy(driver, myOrdersLink);
        return myOrders.getText();
    }
}
