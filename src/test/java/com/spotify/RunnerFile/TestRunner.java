package com.spotify.RunnerFile;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/com/spotify/Features", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
