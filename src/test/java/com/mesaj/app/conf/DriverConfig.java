package com.mesaj.app.conf;

import com.mesaj.app.enums.Browser;
import com.mesaj.app.util.driver.DriverFactory;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;

@Configuration
@ComponentScan(basePackages = "com.mesaj.app")
@PropertySource("classpath:/application-${enviroment:dev}.properties")
public class DriverConfig {

    @Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int webDriverWaitTimeOut;

    @Autowired
    private DriverFactory driverFactory;

    @Bean
    public WebDriver webDriver() throws MalformedURLException {

        return driverFactory.get(driverType);
    }
    @Bean
    public WebDriverWait waitFor() throws MalformedURLException {
        return new WebDriverWait (webDriver(), Duration.ofSeconds(webDriverWaitTimeOut));
    }
}
