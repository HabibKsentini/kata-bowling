package com.sg.kata.bowling;

import java.util.function.Predicate;

import com.sg.kata.bowling.constant.FrameConstant;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.StrikeFrame;

public class StrikeFrameConverter extends BaseFrameConverter {

	@Override
	public Predicate<String> getConverterPredicate() {
		return frameSequence -> frameSequence.equals(FrameConstant.STRIKE_FRAME_SYMBOL); 
	}

	@Override
	public Frame getFrame(String frameSequence) {
		return new StrikeFrame(); 
	}

}
