package com.sg.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import com.sg.kata.bowling.exception.FrameConversionException;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.StrikeFrame;

public class StrikeFrameConverterTest {

	private StrikeFrameConverter strikeFrameConverter;
	private final String validStrikeFrameSequence = "X";
	private final String notValidStrikeFrameSequenceWithMoreThenOneCharacters = "X7";

	@Before
	public void init() {
		strikeFrameConverter = new StrikeFrameConverter();
	}

	@Test
	public void convert_should_return_strike_frame() {
		Frame frame = strikeFrameConverter.convert(validStrikeFrameSequence);
		FrameConverterTestUtil.validateConversion(frame, StrikeFrame.class);
	}

	@Test(expected = FrameConversionException.class)
	public void convert_should_throw_frame_conversion_exception_when_sequence_contains_more_then_one_character()
			throws Exception {
		FrameConverterTestUtil.validateFrameConversionExceptionMsg(notValidStrikeFrameSequenceWithMoreThenOneCharacters,
				StrikeFrameConverter.class);
	}

}
