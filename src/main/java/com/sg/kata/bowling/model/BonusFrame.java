package com.sg.kata.bowling.model;

import com.sg.kata.bowling.util.ScoreCalculatorUtil;

public class BonusFrame implements Frame {

	private final String sequence;

	public BonusFrame(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public int getNumberOfTheNextThrowsToAddToTheScore() {
		return 0;
	}

	@Override
	public int getFirstThrowPinsNumber() {
		String firstThrowCharacter = sequence.substring(0, 1);
		return ScoreCalculatorUtil.getScoreByCharacter(firstThrowCharacter);
	}

	@Override
	public int getSecondThrowPinsNumber() {
		return 0;
	}

	public String getSequence() {
		return this.sequence;
	}

}
