package com.sg.kata.bowling.stepdefs;

import org.junit.Assert;

import com.sg.kata.bowling.model.BowlingGame;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Step Definition for Bowling game score calculation
 * (BowlingGameScoreCalculation.feature)
 */
public class BowlingGameScoreCalculationStepDefs {

	private BowlingGame bowlingGame; 
	
	@Given("^I have a game results sequence \"(.*?)\"$")
	public void i_have_a_game_results_sequence(String gameResultsSequence) throws Throwable {
		bowlingGame = new BowlingGame(gameResultsSequence);
	}

	@When("^I calculate the score$")
	public void i_calculate_the_score() throws Throwable {
		bowlingGame.calculateScore(); 
	}

	@Then("^the score should be (\\d+)$")
	public void the_score_should_be(int score) throws Throwable {
		Assert.assertTrue(bowlingGame.getScore() == score);
	}

}
