package com.github.benallard.bdd;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterSteps {
    private int counter;
    private int previousValue;

    @Given("a counter")
    public void aCounter() {
    }

    @Given("the counter has any integral value")
    public void counterHasAnyIntegralValue() {
        counter = new Random().nextInt();
        previousValue = counter;
    }

    @When("the user increases the counter")
    public void increasesTheCounter() {
        counter++;
    }

    @When("the user decreases the counter")
    public void decreasesTheCounter() {
        --counter;
    }

    @Then("the value of the counter must be $delta greater than previous value")
    public void theValueOfTheCounterMustBe1Greater(int delta) {
        assertEquals(delta, counter - previousValue);
    }

    @Then("the value of the counter must be $delta less than previous value")
    public void theValueOfTheCounterMustBe1Less(int delta) {
        assertEquals(delta, previousValue - counter);
    }
}