package org.ekfgroup.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

    WebDriver driver;

    @BeforeTest
    public void before() {
        driver = new FirefoxDriver();
    }

    @Test
    public void browse() {
             driver.get("https://ekfgroup.com/");
    }

    @AfterTest
    public void finish() {
        
    }

}


