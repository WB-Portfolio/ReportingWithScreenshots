package com.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"Steps"},
        features = ".",
        plugin = {"json:target/reports/cucumber.json"},
        tags = {"@Scénario1"}
)

public class Tests {

}
