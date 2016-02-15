package com.sg.kata.bowling;

import java.util.function.Predicate;

import com.sg.kata.bowling.constant.FrameConstant;
import com.sg.kata.bowling.model.BlankFrame;
import com.sg.kata.bowling.model.Frame;

public class BlankFrameConverter extends BaseFrameConverter {
	
	@Override
	public Predicate<String> getConverterPredicate() {
		return frameSequence -> frameSequence.equals(FrameConstant.BLANK_FRAME_SYMBOL) ; 
	}

	@Override
	public Frame getFrame(String frameSequence) {
		return new BlankFrame();
	} 

}
