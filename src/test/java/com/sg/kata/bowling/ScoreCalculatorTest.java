package com.sg.kata.bowling;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sg.kata.bowling.model.BlankFrame;
import com.sg.kata.bowling.model.BonusFrame;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.NormalFrame;
import com.sg.kata.bowling.model.SpareFrame;
import com.sg.kata.bowling.model.StrikeFrame;

public class ScoreCalculatorTest {
	private ScoreCalculator scoreCalculator;

	@Test
	public void calculate_should_return_score_of_blank_frames_sequence() {
		List<Frame> frames = getBlankFrames();
		validateScore(frames, 0);
	}

	@Test
	public void calculate_should_return_score_of_normal_frames_sequence() {
		List<Frame> frames = getNormalFrames();
		validateScore(frames, 21);
	}

	@Test
	public void calculate_should_return_score_of_blank_frames_joined_to_spare_frame_that_contains_blank_throw() {
		List<Frame> frames = getBlankFramesJoinedToSpareFrameThatContainsBlankThrow();
		validateScore(frames, 10);
	}

	@Test
	public void calculate_should_return_score_of_blank_frames_joined_to_spare_frame_that_contains_normal_throw() {
		List<Frame> frames = getBlankFramesJoinedToSpareFrameThatContainsNormalThrow();
		validateScore(frames, 10);
	}

	@Test
	public void calculate_should_return_score_of_blank_frames_joined_to_spare_frames() {
		List<Frame> frames = getBlankFramesJoinedToSpareFrames();
		validateScore(frames, 20);
	}

	@Test
	public void calculate_should_return_score_of_blanks_frames_joined_to_strike_frame() {
		List<Frame> frames = getBlankFramesJoinedToStrikeFrame();
		validateScore(frames, 10);
	}

	@Test
	public void calculate_should_return_score_of_blanks_frames_joined_to_strike_frames() {
		List<Frame> frames = getBlankFramesJoinedToStrikeFrames();
		validateScore(frames, 30);
	}

	@Test
	public void calculate_should_return_score_of_blanks_frames_joined_to_strike_frame_joined_to_spare_frames() {
		List<Frame> frames = getBlankFramesJoinedToStrikeFrameJoinedToSpareFrame();
		validateScore(frames, 30);
	}
	
	@Test
	public void calculate_should_return_score_of_spare_frames_with_one_throw_as_bonus() {
		List<Frame> frames = getSpareFramesWithBonusThrow();
		validateScore(frames, 150);
	}
	
	@Test
	public void calculate_should_return_score_of_strike_frames_with_tow_throws_as_bonus() {
		List<Frame> frames = getStrikeFramesWithBonusThrows();
		validateScore(frames, 300);
	}

	private void validateScore(List<Frame> frames, int expectedScore) {
		scoreCalculator = new ScoreCalculator(frames);
		int score = scoreCalculator.calculate();
		Assert.assertTrue(score == expectedScore);
	}

	/*
	 * sequence: --------------------
	 */
	private List<Frame> getBlankFrames() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			frames.add(new BlankFrame());
		}
		return frames;
	}

	/*
	 * sequence: 11111121111111111111
	 */
	private List<Frame> getNormalFrames() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			frames.add(new NormalFrame("11"));
		}
		frames.add(3, new NormalFrame("21"));
		return frames;
	}

	/*
	 * sequence: -------/------------
	 */
	private List<Frame> getBlankFramesJoinedToSpareFrameThatContainsBlankThrow() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			frames.add(new BlankFrame());
		}
		frames.add(3, new SpareFrame("-/"));
		return frames;
	}

	/*
	 * sequence: ------4/------------
	 */
	private List<Frame> getBlankFramesJoinedToSpareFrameThatContainsNormalThrow() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			frames.add(new BlankFrame());
		}
		frames.add(3, new SpareFrame("4/"));
		return frames;
	}

	/*
	 * sequence:------4/-----/------
	 */
	private List<Frame> getBlankFramesJoinedToSpareFrames() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			frames.add(new BlankFrame());
		}
		frames.add(3, new SpareFrame("4/"));
		frames.add(6, new SpareFrame("-/"));
		return frames;
	}

	/*
	 * sequence:--------X----------
	 */
	private List<Frame> getBlankFramesJoinedToStrikeFrame() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			frames.add(new BlankFrame());
		}
		frames.add(4, new StrikeFrame());
		return frames;
	}

	/*
	 * sequence:------XX----------
	 */
	private List<Frame> getBlankFramesJoinedToStrikeFrames() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			frames.add(new BlankFrame());
		}
		frames.add(3, new StrikeFrame());
		frames.add(4, new StrikeFrame());
		return frames;
	}

	/*
	 * sequence:--------4/X--------
	 */
	private List<Frame> getBlankFramesJoinedToStrikeFrameJoinedToSpareFrame() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			frames.add(new BlankFrame());
		}
		frames.add(3, new SpareFrame("4/"));
		frames.add(4, new StrikeFrame());
		return frames;
	}

	/*
	 * sequence: 5/5/5/5/5/5/5/5/5/5/5
	 */
	private List<Frame> getSpareFramesWithBonusThrow() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			frames.add(new SpareFrame("5/"));
		}
		frames.add(new BonusFrame("5"));
		return frames;
	}
	
	private List<Frame> getStrikeFramesWithBonusThrows() {
		List<Frame> frames = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			frames.add(new StrikeFrame());
		}
		frames.add(new BonusFrame("XX"));
		return frames;
	}
}
