package org.ekfgroup.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumTest {

    WebDriver driver;

    @BeforeTest
    public void before() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);  // <-- headless set here
        driver = new FirefoxDriver(options);
    }

    @Test
    public void browse() throws Exception {
             driver.get("http://ekfgroup.com");
             new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header-menu-main .nav-item:first-child")));
             System.out.println(driver.getTitle());
             driver.findElement(By.cssSelector(".header-menu-main .nav-item:first-child")).click();
             new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://ekfgroup.com/solutions"));
             System.out.println(driver.getCurrentUrl());
    }

    @AfterTest
    public void finish() {
        driver.quit();
    }

}


