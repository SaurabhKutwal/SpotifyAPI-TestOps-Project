package com.spotify.RunnerFile.StepDefinitions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/spotify/Features", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
