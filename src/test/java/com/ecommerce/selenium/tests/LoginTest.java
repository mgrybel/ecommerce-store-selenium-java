package com.ecommerce.selenium.tests;

import com.ecommerce.selenium.base.BaseTest;
import com.ecommerce.selenium.pages.LoginPage;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test(description = "Login with valid credentials")
    void loginWithValidCredentials() {
        // Exercise
        LoginPage.getInstance().getUrl(driver);
        LoginPage.getInstance().login(driver);

        // Verify
        assertEquals(
                LoginPage.getInstance().getMyOrders(driver),
                "MY ORDERS",
                "The actual value does not match the expected value"
        );
    }
}
