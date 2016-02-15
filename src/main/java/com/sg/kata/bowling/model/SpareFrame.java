package com.sg.kata.bowling.model;

import com.sg.kata.bowling.constant.FrameConstant;
import com.sg.kata.bowling.util.StringUtil;

public class SpareFrame implements Frame {

	private String sequence;

	public SpareFrame(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public int getScore() {
		return FrameConstant.SPARE_FRAME_SCORE;
	}

	@Override
	public int getNumberOfTheNextThrowsToAddToTheScore() {
		return FrameConstant.SPARE_FRAME_NUMBER_OF_THE_NEXT_THROWS_TO_ADD_TO_THE_SCORE;
	}

	@Override
	public int getFirstThrowPinsNumber() {
		if (sequence.charAt(0) == '-') {
			return 0;
		}
		int number = StringUtil.getIntByIndex(0, sequence);
		return number;
	}

	@Override
	public int getSecondThrowPinsNumber() {
		return getScore() - getFirstThrowPinsNumber();
	}

}
