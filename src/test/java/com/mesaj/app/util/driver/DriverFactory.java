package com.mesaj.app.util.driver;

import com.mesaj.app.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver get (Browser browser)
    {
        if(Browser.chrome == browser)
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver86.exe");
            return new ChromeDriver();
        }
        if(Browser.firefox == browser)
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/windows/geckodriver.exe");
            return new FirefoxDriver();
        }
        throw new IllegalArgumentException("Driver Not found for browser");
    }
}
