package com.sg.kata.bowling;

import org.junit.Assert;

import com.sg.kata.bowling.BaseFrameConverter;
import com.sg.kata.bowling.exception.FrameConversionException;
import com.sg.kata.bowling.model.Frame;

public class FrameConverterTestUtil {

	public static void validateFrameConversionExceptionMsg(String frameSequence, Class <? extends BaseFrameConverter> frameConverterClass) throws Exception {
		String expectedErrorMsg = getExpectedErrorMsg(frameConverterClass, frameSequence);
		try {
			frameConverterClass.newInstance().convert(frameSequence);
		} catch (FrameConversionException e) {
			Assert.assertEquals(expectedErrorMsg, e.getMessage());
			throw e;
		}
	}

	public static void validateConversion(Frame frame, Class<?> frameClass) {
		Assert.assertNotNull(frame);
		Assert.assertTrue(frame.getClass() == frameClass);
	}

	public static String getExpectedErrorMsg(Class <? extends BaseFrameConverter> frameConverterClass,
			String frameSequence) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
		.append("Error occured during the conversion of: ")
		.append(frameSequence)
		.append(" by: ")
		.append(frameConverterClass.getSimpleName());
		return stringBuilder.toString();
	}
}
