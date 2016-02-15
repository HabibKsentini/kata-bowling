package com.sg.kata.bowling;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sg.kata.bowling.GameResultsSequenceToFramesConverter;
import com.sg.kata.bowling.model.BlankFrame;
import com.sg.kata.bowling.model.BonusFrame;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.NormalFrame;
import com.sg.kata.bowling.model.SpareFrame;
import com.sg.kata.bowling.model.StrikeFrame;

public class GameResultsSequenceToFramesConverterTest {

	private final String blankFrameSequence = "--";
	private final String normalFrameSequence = "78";
	private final String spareFrameSequence = "7/";
	private final String strikeFrameSequence = "X";
	private final String gameResultsSequence = "78X7/--";
	private final String gameResultsSequenceWithSpareBonusThrow = "5/5/5/5/5/5/5/5/5/5/5";
	private final String gameResultsSequenceWithStrikeBonusThrow = "XXXXXXXXXXXX";

	@Test
	public void convert_should_return_blank_frame() {
		validateConversion(blankFrameSequence, BlankFrame.class);
	}

	@Test
	public void convert_should_return_normal_frame() {
		validateConversion(normalFrameSequence, NormalFrame.class);
	}

	@Test
	public void convert_should_return_spare_frame() {
		validateConversion(spareFrameSequence, SpareFrame.class);
	}

	@Test
	public void convert_should_return_strike_frame() {
		validateConversion(strikeFrameSequence, StrikeFrame.class);
	}

	@Test
	public void convert_should_return_all_types_of_frame() {
		GameResultsSequenceToFramesConverter gameResultsSequenceToFramesConverter = new GameResultsSequenceToFramesConverter(
				gameResultsSequence);
		List<Frame> frames = gameResultsSequenceToFramesConverter.convert();
		Assert.assertTrue(frames.size() == 4);
		Assert.assertTrue(frames.get(0).getClass() == NormalFrame.class);
		Assert.assertTrue(frames.get(1).getClass() == StrikeFrame.class);
		Assert.assertTrue(frames.get(2).getClass() == SpareFrame.class);
		Assert.assertTrue(frames.get(3).getClass() == BlankFrame.class);
	}

	@Test
	public void convert_should_return_bonus_frame_when_last_frame_is_spare_frame() {
		GameResultsSequenceToFramesConverter gameResultsSequenceToFramesConverter = new GameResultsSequenceToFramesConverter(
				gameResultsSequenceWithSpareBonusThrow);
		List<Frame> frames = gameResultsSequenceToFramesConverter.convert();
		Assert.assertTrue(frames.size() == 11);
		Assert.assertTrue(frames.get(10).getClass() == BonusFrame.class);
		BonusFrame bonusFrame = (BonusFrame) frames.get(10);
		Assert.assertTrue(bonusFrame.getSequence().equals("5"));
	}
	
	@Test
	public void convert_should_return_bonus_frame_when_last_frame_is_strike_frame() {
		GameResultsSequenceToFramesConverter gameResultsSequenceToFramesConverter = new GameResultsSequenceToFramesConverter(
				gameResultsSequenceWithStrikeBonusThrow);
		List<Frame> frames = gameResultsSequenceToFramesConverter.convert();
		Assert.assertTrue(frames.size() == 11);
		Assert.assertTrue(frames.get(10).getClass() == BonusFrame.class);
		BonusFrame bonusFrame = (BonusFrame) frames.get(10);
		Assert.assertTrue(bonusFrame.getSequence().equals("XX"));
	}

	private void validateConversion(String frameSequence, Class<?> frameClass) {
		GameResultsSequenceToFramesConverter gameResultsSequenceToFramesConverter = new GameResultsSequenceToFramesConverter(
				frameSequence);
		List<Frame> frames = gameResultsSequenceToFramesConverter.convert();
		Frame resultFrame = frames.get(0);
		Assert.assertTrue(frames.size() == 1);
		Assert.assertTrue(resultFrame.getClass() == frameClass);
	}

}
