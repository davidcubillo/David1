package com.mesaj.app.util.driver;

import com.mesaj.app.enums.Browser;
import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {
    @Value("${grid.url}")
    private String gridUrl;

    @Value("${remote.execution}")
    private boolean remoteExecution;

    public  WebDriver get (Browser browser) throws MalformedURLException {
        if(remoteExecution){
            getRemoteWebDriver(browser);
        }

        if(Browser.chrome == browser)
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver2");
            return new ChromeDriver();
        }
        if(Browser.firefox == browser)
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/windows/geckodriver.exe");
            return new FirefoxDriver();
        }
        throw new IllegalArgumentException("Driver Not found for browser");
    }

    private RemoteWebDriver getRemoteWebDriver(Browser browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.name());
        return new RemoteWebDriver(URI.create(gridUrl).toURL(),capabilities);
    }
}
