package utils;

import io.cucumber.java.After;

import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() throws IOException {

        testContextSetup.testBase.WebDriverManager().close();
    }
}
