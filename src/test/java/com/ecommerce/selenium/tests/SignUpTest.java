package com.ecommerce.selenium.tests;

import com.ecommerce.selenium.base.BaseTest;
import com.ecommerce.selenium.pages.SignUpPage;
import com.ecommerce.selenium.utils.TestDataFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(description = "Positive sign up")
    void positiveSignUp(){
        // Exercise
        SignUpPage.getInstance().getUrl(driver);
        SignUpPage.getInstance().signUp(driver, TestDataFactory.positiveEmail, TestDataFactory.password);

        // Verify
        Assert.assertTrue(
                SignUpPage.getInstance().ifSignUpNotificationPopUp(driver),
                "The positive sign up notification didn't enabled"
        );
    }

    @Test(description = "Negative sign up")
    void negativeSignUp(){
        // Exercise
        SignUpPage.getInstance().getUrl(driver);
        SignUpPage.getInstance().signUp(driver, TestDataFactory.negativeEmail, TestDataFactory.password);

        // Verify
        Assert.assertFalse(
                SignUpPage.getInstance().ifSignUpButtonActive(driver),
                "The positive sign up notification displayed"
        );
    }

    @Test(description = "Sign up with an already taken email")
    void signUpWithAlreadyTakenEmail() {
        //Exercise
        SignUpPage.getInstance().getUrl(driver);
        SignUpPage.getInstance().signUp(driver, TestDataFactory.positiveEmail, TestDataFactory.password);

        //Verify
        Assert.assertTrue(
                SignUpPage.getInstance().ifEmailTaken(driver),
                "This email address is already taken"
        );
    }
}
