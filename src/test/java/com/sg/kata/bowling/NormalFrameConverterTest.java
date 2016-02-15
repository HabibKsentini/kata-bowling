package com.sg.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import com.sg.kata.bowling.exception.FrameConversionException;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.NormalFrame;

public class NormalFrameConverterTest {

	private NormalFrameConverter normalFrameConverter;
	private final String validNormalFrameSequence = "77";
	private final String validNormalFrameSequenceWithBlankCharacter = "7-";
	private final String notValidNormalFrameSequenceWithSpareCharacter = "7/";
	private final String notValidNormalFrameSequenceWithMoreThenTowCharacters = "777";

	@Before
	public void init() {
		normalFrameConverter = new NormalFrameConverter();
	}

	@Test
	public void convert_should_return_normal_frame() {
		Frame frame = normalFrameConverter.convert(validNormalFrameSequence);
		validateConversion(frame);
	}

	@Test
	public void convert_should_return_normal_frame_when_sequence_contains_blank_character() {
		Frame frame = normalFrameConverter.convert(validNormalFrameSequenceWithBlankCharacter);
		validateConversion(frame);
	}

	private void validateConversion(Frame frame) {
		FrameConverterTestUtil.validateConversion(frame, NormalFrame.class);
	}

	@Test(expected = FrameConversionException.class)
	public void convert_should_throw_frame_conversion_exception_when_sequence_contains_invalid_character()
			throws Exception {
		FrameConverterTestUtil.validateFrameConversionExceptionMsg(notValidNormalFrameSequenceWithMoreThenTowCharacters,
				NormalFrameConverter.class);
	}

	@Test(expected = FrameConversionException.class)
	public void convert_should_throw_frame_conversion_exception_when_sequence_contains_more_then_tow_characters()
			throws Exception {
		FrameConverterTestUtil.validateFrameConversionExceptionMsg(notValidNormalFrameSequenceWithSpareCharacter,
				NormalFrameConverter.class);
	}

}
