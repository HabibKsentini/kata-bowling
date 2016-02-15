package com.sg.kata.bowling;

import java.util.function.Predicate;

import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.NormalFrame;

public class NormalFrameConverter extends BaseFrameConverter {

	@Override
	public Predicate<String> getConverterPredicate() {
		return frameSequence -> frameSequence.length() == 2 && !isSecondCharacterASpareSymbol(frameSequence); 
	}

	@Override
	public Frame getFrame(String frameSequence) {
		return new NormalFrame(frameSequence); 
	}
	
	
	

	
	
}
