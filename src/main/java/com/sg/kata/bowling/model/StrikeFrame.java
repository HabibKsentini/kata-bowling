package com.sg.kata.bowling.model;

import com.sg.kata.bowling.constant.FrameConstant;

public class StrikeFrame implements Frame {

	@Override
	public int getScore() {
	 return FrameConstant.STRIKE_FRAME_SCORE;
	}

	@Override
	public int getNumberOfTheNextThrowsToAddToTheScore() {
		return FrameConstant.STRIKE_FRAME_NUMBER_OF_THE_NEXT_THROWS_TO_ADD_TO_THE_SCORE;
	}

	@Override
	public int getFirstThrowPinsNumber() {
		return getScore();
	}

	@Override
	public int getSecondThrowPinsNumber() {
		return 0;
	}
	@Override
	public boolean isOneCharacterFrame(){
		return true;
	}

}
