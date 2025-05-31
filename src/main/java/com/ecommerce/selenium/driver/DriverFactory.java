package com.ecommerce.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    WebDriver driver;

    public WebDriver initializeDriver() {
        String browser = System.getProperty("browser", "CHROME");
        switch (browser) {
            case "CHROME" -> {
                driver = new ChromeDriver();
            }
            case "FIREFOX" -> {
                driver = new FirefoxDriver();
            }
            default -> {
                throw new RuntimeException("Browser is not supported.");
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
}
