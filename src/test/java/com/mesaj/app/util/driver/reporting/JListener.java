package com.mesaj.app.util.driver.reporting;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestStep;
import io.cucumber.plugin.event.TestStepFinished;

public class JListener implements ConcurrentEventListener {

  public void onTestCaseStarted(TestCaseStarted event)
  {
    TestCase testCase = event.getTestCase();
    System.out.println("Starting "+ testCase.getName());
  }
  private void onTestStepFinished(final TestCaseFinished event)
  {
    TestCase finishTest = event.getTestCase();
    System.out.println("Finished "+ finishTest.getName());
    Result result = event.getResult();
    if (result.getStatus() == Status.FAILED)
    {
      final Throwable error = result.getError();
      error.printStackTrace();
    }
  }
  @Override
  public void setEventPublisher(EventPublisher publisher) {
    publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
    publisher.registerHandlerFor(TestCaseFinished.class, this::onTestStepFinished);
  }
}
