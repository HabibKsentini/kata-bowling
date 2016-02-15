package com.sg.kata.bowling;

import java.util.function.Predicate;

import com.sg.kata.bowling.constant.FrameConstant;
import com.sg.kata.bowling.exception.FrameConversionException;
import com.sg.kata.bowling.model.Frame;

public abstract class BaseFrameConverter {

	public Frame convert(String frameSequence){
		Frame frame = null;
		if (getConverterPredicate().test(frameSequence)) {
			frame = getFrame(frameSequence);
			return frame;
		}
		String errorMsg = getErrorMsg(frameSequence);
		throw new FrameConversionException(errorMsg);
	}
	
	protected final boolean isSecondCharacterASpareSymbol(String frameSequence){
		return frameSequence.substring(1).equals(FrameConstant.SPARE_FRAME_SYMBOL); 
	}

	private String getErrorMsg(String frameSequence) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
		.append("Error occured during the conversion of: ")
		.append(frameSequence)
		.append(" by: ")
		.append(this.getClass().getSimpleName());
		return stringBuilder.toString();
	}

	public abstract Predicate<String> getConverterPredicate();

	public abstract Frame getFrame(String frameSequence);

}
