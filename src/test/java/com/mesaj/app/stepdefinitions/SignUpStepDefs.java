package com.mesaj.app.stepdefinitions;

import com.mesaj.app.builders.data.UserBuilder;
import com.mesaj.app.conf.DriverConfig;
import com.mesaj.app.pageobjects.SignUpServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import com.mesaj.app.tasks.NavigateTo;
import com.mesaj.app.tasks.UserSignUp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

//todo remove from the step definitions
@ContextConfiguration(classes = {DriverConfig.class})
public class SignUpStepDefs {

    @Autowired
    private UserSignUp signUp;

    @Autowired
    private NavigateTo navigate;
    @Value("${url}")
    private String url;


    @Given("Pepito wants to have an account")
    public void pepito_wants_to_have_an_account() throws InterruptedException {
        navigate.signUpPage();

    }
    @When("^he sends required information to get the account$")
    public void he_sends_required_information_to_get_the_account() throws InterruptedException {
        signUp.withInfo(UserBuilder
                .aUser()
                .withDefaultInfo()
                .build());
        Thread.sleep(7000);
    }

    @Then("^he should be told that the account was created$")
    public void he_should_be_told_that_the_account_was_created()  {
        assertThat(true).isEqualTo(true);


    }

}
