package com.sg.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import com.sg.kata.bowling.exception.FrameConversionException;
import com.sg.kata.bowling.model.BlankFrame;
import com.sg.kata.bowling.model.Frame;

public class BlankFrameConverterTest {

	private BlankFrameConverter blankFrameConverter;
	private final String validBlankFrameSequence = "--";
	private final String notValidBlankFrameSequence = "9-";
	private final String notValidBlankFrameSequenceWithMoreThenTowCharacters = "---";

	@Before
	public void init() {
		blankFrameConverter = new BlankFrameConverter();
	}

	@Test
	public void convert_should_return_blank_frame() {
		Frame frame = blankFrameConverter.convert(validBlankFrameSequence);
		FrameConverterTestUtil.validateConversion(frame, BlankFrame.class);
	}

	@Test(expected = FrameConversionException.class)
	public void convert_should_throw_frame_conversion_exception_when_sequence_contains_invalid_character()
			throws Exception {
		FrameConverterTestUtil.validateFrameConversionExceptionMsg(notValidBlankFrameSequence, BlankFrameConverter.class);
	}

	@Test(expected = FrameConversionException.class)
	public void convert_should_throw_frame_conversion_exception_when_sequence_contains_more_then_tow_characters()
			throws Exception {
		FrameConverterTestUtil.validateFrameConversionExceptionMsg(notValidBlankFrameSequenceWithMoreThenTowCharacters,
				BlankFrameConverter.class);
	}
}
