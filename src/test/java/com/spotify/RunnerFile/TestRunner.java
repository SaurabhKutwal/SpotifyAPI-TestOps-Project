package com.spotify.RunnerFile;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/com/spotify/Features", monochrome = true,
plugin = {"html:Outputs/Reports/htmlReport.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
