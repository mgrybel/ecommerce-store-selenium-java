package com.ecommerce.selenium.base;

import com.ecommerce.selenium.driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void testInit() {
        driver = new DriverFactory().initializeDriver();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void testCleanup(ITestResult result) {
        String testCaseName = result.getMethod().getMethodName();
        File destinationFile = new File(
                "target"
                        + File.separator
                        + "screenshots"
                        + File.separator
                        + testCaseName
                        + ".png"
        );
        takeScreenshot(destinationFile);
        driver.quit();
    }

    public void takeScreenshot(File destinationFile) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destinationFile);
            InputStream inputStream = new FileInputStream(destinationFile);
            Allure.addAttachment("screenshot", inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
