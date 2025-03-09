package com.spotify.RunnerFile.StepDefinitions.Hooks;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestHooks {

    private static final Logger logger = LogManager.getLogger(TestHooks.class);

    @BeforeAll
    public static void beforeAll(){
        logger.info("***** ---- Starting execution of test suite ---- *****");
    }

    @AfterAll
    public static void afterAll(){
        logger.info("***** ---- Execution ended for test suite ---- *****");
    }

    @Before
    public static void beforeScenario(Scenario scenario){
        logger.info("<--- Starting execution of test scenario : {}", scenario.getName());
    }

    @After
    public static void afterScenario(Scenario scenario){
        logger.info("<--- Execution Done of test scenario : {}", scenario.getName());
    }
}
