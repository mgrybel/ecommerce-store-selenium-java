package com.ecommerce.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebElement findElementBy(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            throw new TimeoutException();
        }
    }

    public void enterTextIntoTextBox(WebDriver driver, By by, String text) {
        WebElement textBox = findElementBy(driver, by);
        textBox.clear();
        textBox.sendKeys(text);
    }

    public void clickLinkOrBtn(WebDriver driver, By by) {
        WebElement linkOrBtn = findElementBy(driver, by);
        linkOrBtn.click();
    }
}
