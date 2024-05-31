package com.saucedemo.base;

import com.saucedemo.constants.TestConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;

    public static Properties properties;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to load properties file");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public int getIntProperty(String key) {
        String value = properties.getProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Failed to convert property value to int: " + value);
        }
    }

    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }

    public void setUp () throws Exception {
        String browser = getProperty("driver");
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new Exception("Incorrect Browser");
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestConstants.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestConstants.PAGELOAD_TIMEOUT));
        driver.get(getProperty("url"));
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
