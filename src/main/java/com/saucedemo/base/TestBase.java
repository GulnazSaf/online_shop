package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;

    public static Properties properties;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    public 

    public void setUp () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void logTestStart (Method m, Object[] p) {
        logger.info("Start test " + m.getName() + "with parameters" + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestEnd (Method m) {
        logger.info("End test " + m.getName());
    }



}
