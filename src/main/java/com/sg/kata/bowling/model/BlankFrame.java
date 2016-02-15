package com.sg.kata.bowling.model;

import com.sg.kata.bowling.constant.FrameConstant;

public class BlankFrame implements Frame {
	

	@Override
	public int getScore() {
		return FrameConstant.BLANK_FRAME_SCORE;
	}

	@Override
	public int getNumberOfTheNextThrowsToAddToTheScore() {
		return FrameConstant.BLANK_FRAME_NUMBER_OF_THE_NEXT_THROWS_TO_ADD_TO_THE_SCORE; 
	}

	@Override
	public int getFirstThrowPinsNumber() {
		return 0;
	}

	@Override
	public int getSecondThrowPinsNumber() {
		return 0;
	}

}
