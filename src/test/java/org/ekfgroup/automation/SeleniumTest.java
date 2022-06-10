package org.ekfgroup.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
             Assert.assertEquals(driver.getTitle(),"kek");
    }

    @AfterTest
    public void finish() {
        
    }

}


