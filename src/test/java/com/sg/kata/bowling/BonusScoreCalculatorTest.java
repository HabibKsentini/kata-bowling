package com.sg.kata.bowling;

import org.junit.Assert;
import org.junit.Test;

import com.sg.kata.bowling.model.SpareFrame;
import com.sg.kata.bowling.model.StrikeFrame;


public class BonusScoreCalculatorTest {

	private BonusScoreCalculator bonusThrowsScoreCalculator;
	
	@Test
	public void calculate_should_return_spare_bonus_with_blank_throw(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new SpareFrame("5/"), "-");
		validateBonus(0);
	}
	
	@Test
	public void calculate_should_return_spare_bonus_with_strike_throw(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new SpareFrame("5/"), "X");
		validateBonus(10);
	}
	
	@Test
	public void calculate_should_return_spare_bonus_with_normal_throw(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new SpareFrame("5/"), "8");
		validateBonus(8);
	}
	
	@Test
	public void calculate_should_return_strike_bonus_with_blank_throws(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new StrikeFrame(), "--");
		validateBonus(0);
	}
	
	@Test
	public void calculate_should_return_strike_bonus_with_blank_throw_joined_to_spare_throw(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new StrikeFrame(), "-/");
		validateBonus(10);
	}
	
	@Test
	public void calculate_should_return_strike_bonus_with_normal_throw_joined_to_spare_throw(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new StrikeFrame(), "7/");
		validateBonus(10);
	}
	
	@Test
	public void calculate_should_return_strike_bonus_with_blank_throw_joined_to_strike_throw(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new StrikeFrame(), "-X");
		validateBonus(10);
	}
	
	@Test
	public void calculate_should_return_strike_bonus_with_normal_throw_joined_to_strike_throw(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new StrikeFrame(), "7X");
		validateBonus(17);
	}
	
	@Test
	public void calculate_should_return_strike_bonus_with_tow_strike_throws(){
		bonusThrowsScoreCalculator = new BonusScoreCalculator(new StrikeFrame(), "XX");
		validateBonus(20);
	}
	
	private void validateBonus(int expectedBonus){
		int bonus = bonusThrowsScoreCalculator.calculate(); 
		Assert.assertTrue(bonus == expectedBonus);
	}
	
}
