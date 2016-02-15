package com.sg.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import com.sg.kata.bowling.exception.FrameConversionException;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.SpareFrame;

public class SpareFrameConverterTest {

	
	private SpareFrameConverter spareFrameConverter;
	private final String validSpareFrameSequence = "4/";
	private final String notValidSpareFrameSequenceWithStrikeCharacter = "7X";
	private final String notValidSpareFrameSequenceWithMoreThenTowCharacters = "7/7";

	@Before
	public void init() {
		spareFrameConverter = new SpareFrameConverter();
	}

	@Test
	public void convert_should_return_spare_frame() {
		Frame frame = spareFrameConverter.convert(validSpareFrameSequence);
		FrameConverterTestUtil.validateConversion(frame, SpareFrame.class);
	}

	@Test(expected = FrameConversionException.class)
	public void convert_should_throw_frame_conversion_exception_when_sequence_contains_invalid_character()
			throws Exception {
		FrameConverterTestUtil.validateFrameConversionExceptionMsg(notValidSpareFrameSequenceWithStrikeCharacter,
				SpareFrameConverter.class);
	}

	@Test(expected = FrameConversionException.class)
	public void convert_should_throw_frame_conversion_exception_when_sequence_contains_more_then_tow_characters()
			throws Exception {
		FrameConverterTestUtil.validateFrameConversionExceptionMsg(notValidSpareFrameSequenceWithMoreThenTowCharacters,
				SpareFrameConverter.class);
	}
	
}
