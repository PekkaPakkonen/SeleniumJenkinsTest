package org.ekfgroup.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

        driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
    }

    @Test
    public void browse() throws Exception {
             driver.get("https://ekfgroup.com/");
             Thread.sleep(5000);
             System.out.println(driver.getTitle());
             driver.findElement(By.cssSelector(".header-menu-main .nav-item:first-child")).click();
             new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://ekfgroup.com/solutions"));
    }

    @AfterTest
    public void finish() {
        
    }

}


