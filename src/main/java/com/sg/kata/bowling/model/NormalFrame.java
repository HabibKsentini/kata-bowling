package com.sg.kata.bowling.model;


import com.sg.kata.bowling.constant.FrameConstant;
import com.sg.kata.bowling.util.StringUtil;

public class NormalFrame implements Frame {

	private String sequence;

	public NormalFrame(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public int getScore() {
		int score = 0;
		score += getFirstThrowPinsNumber();
		score += getSecondThrowPinsNumber();
		return score;
	}

	@Override
	public int getNumberOfTheNextThrowsToAddToTheScore() {
		return FrameConstant.NORMAL_FRAME_NUMBER_OF_THE_NEXT_THROWS_TO_ADD_TO_THE_SCORE;
	}

	@Override
	public int getFirstThrowPinsNumber() {
		return getThrowPinsNumber(0, sequence);
	}

	@Override
	public int getSecondThrowPinsNumber() {
		return getThrowPinsNumber(1, sequence);
	}

	private int getThrowPinsNumber(int charIndex, String sequence) {
		if (sequence.charAt(charIndex) == '-') {
			return 0;
		}
		return StringUtil.getIntByIndex(charIndex, sequence);
	}

}
