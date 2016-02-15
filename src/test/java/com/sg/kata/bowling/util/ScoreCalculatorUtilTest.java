package com.sg.kata.bowling.util;

import org.junit.Assert;
import org.junit.Test;

public class ScoreCalculatorUtilTest {

	private final String blankThrowSymbol = "-";
	private final String numberThrowCharacter = "7";
	private final String strikeSymbol = "X";
	
	@Test
	public void getScoreByCharacter_should_return_0(){
		validateScore(blankThrowSymbol, 0);
	}
	
	@Test
	public void getScoreByCharacter_should_return_number(){
		validateScore(numberThrowCharacter, 7);
	}
	
	@Test
	public void getScoreByCharacter_should_return_strike_score(){
		validateScore(strikeSymbol, 10);
	}
	
	
	private void validateScore(String throwCharcter,int expectedScore){
		int score =ScoreCalculatorUtil.getScoreByCharacter(throwCharcter);
		Assert.assertTrue(score == expectedScore);
	}
	
}
