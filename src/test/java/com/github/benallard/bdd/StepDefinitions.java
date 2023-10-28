package com.github.benallard.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    private int counter;
    private int previousValue;

    @Given("a counter")
    public void a_counter() {
    }
    @Given("the counter has any integral value")
    public void the_counter_has_any_integral_value() {
        counter = new Random().nextInt();
        previousValue = counter;
    }
    @When("the user increases the counter")
    public void the_user_increases_the_counter() {
        counter++;
    }
    @Then("the value of the counter must be {int} greater than previous value")
    public void the_value_of_the_counter_must_be_greater_than_previous_value(Integer delta) {
        assertEquals(delta, counter - previousValue);
    }
}