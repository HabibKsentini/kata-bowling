package com.sg.kata.bowling;

import com.sg.kata.bowling.constant.FrameConstant;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.SpareFrame;
import com.sg.kata.bowling.model.StrikeFrame;
import com.sg.kata.bowling.util.ScoreCalculatorUtil;

public class BonusScoreCalculator {

	private Frame tenthFrame;
	private String bonusSequence;
	private int score; 

	public BonusScoreCalculator(Frame tenthFrame, String bonusSequence) {
		this.tenthFrame = tenthFrame;
		this.bonusSequence = bonusSequence;
	}

	public int calculate() {
		if (tenthFrame.getClass() == SpareFrame.class) {
			score += calculateBonusOfSpare();
		} else if (tenthFrame.getClass() == StrikeFrame.class) {
			score += calculateBonusOfStrike();
		}
		return score;
	}

	private int calculateBonusOfSpare() {
		return getBonusFromThrowCharacter(bonusSequence);
	}

	private int calculateBonusOfStrike() {
		String secondThrowCharacter = bonusSequence.substring(1, 2);
		if (secondThrowCharacter.equals(FrameConstant.SPARE_FRAME_SYMBOL)) {
			return FrameConstant.SPARE_FRAME_SCORE;
		}
		String firstThrowCharacter = bonusSequence.substring(0, 1);
		return getBonusFromThrowCharacter(firstThrowCharacter) + getBonusFromThrowCharacter(secondThrowCharacter);

	}

	private int getBonusFromThrowCharacter(String throwCharcter) {
		return ScoreCalculatorUtil.getScoreByCharacter(throwCharcter); 
	}
	
	public int getScore(){
		return this.score; 
	}

}
