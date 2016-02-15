package com.sg.kata.bowling.stepdefs;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/sg/kata/bowling/feature/BowlingGameScoreCalculation.feature")
public class RunCukesTest {
}
