package com.mesaj.app.util.driver.reporting;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import java.util.UUID;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class PhotograherHook {
  @Autowired
  private WebDriver webDriver;

  @Value("${take.screenshot.condition}")
  private TakeScreenshotCondition takeScreenshotCondition;

  @After
  public void takeScreenShotAfterScenario(Scenario scenario)
  {
  if (TakeScreenshotCondition.everyStep == takeScreenshotCondition)
    takeScreenshot(scenario);

    }
  @AfterStep
  public void takeScreenShotAfterEveryStep(Scenario scenario)
  {
    if (TakeScreenshotCondition.everyStep == takeScreenshotCondition)
      takeScreenshot(scenario);

  }
  @After
  public void takeScreenShotAfterFailedScenario(Scenario scenario)
  {
    if (scenario.isFailed() && TakeScreenshotCondition.failingScenario == takeScreenshotCondition)
      takeScreenshot(scenario);

  }
    private void takeScreenshot(Scenario scenario)
    {
      try {
        if (scenario.isFailed()
        ) {
          final  byte[] screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
          scenario.embed(screenshot,"image/png", UUID.randomUUID().toString());
        }

      }
      catch (WebDriverException wde)
      {
        System.out.println("There was an error taking the screenshot:"+ wde.getMessage());
      }
    }
  }

