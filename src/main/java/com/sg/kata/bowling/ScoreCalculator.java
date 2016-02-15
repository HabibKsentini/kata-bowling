package com.sg.kata.bowling;

import java.util.List;

import com.sg.kata.bowling.model.BonusFrame;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.model.BowlingGame;

public class ScoreCalculator {

	private final List<Frame> frames;
	private int currentFrameIndex;
	private int score;

	public ScoreCalculator(List<Frame> frames) {
		this.frames = frames;
	}

	public int calculate() {
		calculateScoreOfTheFirstNineFrame();
		calculateScoreOfTheTenthFrame();
		calculateBonusScore();
		return score;
	}

	private int calculateScoreOfTheFirstNineFrame() {
		while (currentFrameIndex < 9) {
			score += getScoreOfCurrentFrame();
			currentFrameIndex++;
		}
		return score;
	}

	private int calculateScoreOfTheTenthFrame() {
		score += getTenthFrame().getScore();
		return score;
	}

	private int calculateBonusScore() {
		if (isBonusFrameExist()) {
			String bonusSequence = getBonusFrame().getSequence();
			BonusScoreCalculator bonusScoreCalculator = new BonusScoreCalculator(getTenthFrame(), bonusSequence);
			score += bonusScoreCalculator.calculate();
		}
		return score;
	}

	private boolean isBonusFrameExist() {
		return frames.size() > BowlingGame.NUMBER_OF_FRAMES;
	}

	private int getScoreOfCurrentFrame() {
		int score = 0;
		Frame frame = getCurrentFrame();
		score = frame.getScore();
		score += calculateNextFramesScore();
		return score;
	}

	private int calculateNextFramesScore() {
		int score = 0;
		Frame frame = getCurrentFrame();
		score += calculateNextScore(frame);
		return score;
	}

	private int calculateNextScore(Frame frame) {
		int numberOfTheNextThrowsToAddToTheScore = frame.getNumberOfTheNextThrowsToAddToTheScore();
		int score = 0;
		if (numberOfTheNextThrowsToAddToTheScore == 1) {
			score += getNextFrame().getFirstThrowPinsNumber();
		} else if (numberOfTheNextThrowsToAddToTheScore == 2) {
			Frame nextFrame = getNextFrame();
			if (nextFrame.isOneCharacterFrame()) {
				score += nextFrame.getFirstThrowPinsNumber();
				Frame secondNextFrame = getSecondNextFrame();
				score += secondNextFrame.getFirstThrowPinsNumber();
			} else {
				score += nextFrame.getFirstThrowPinsNumber() + nextFrame.getSecondThrowPinsNumber();
			}
		}
		return score;
	}

	private BonusFrame getBonusFrame() {
		BonusFrame bonusFrame = (BonusFrame) frames.get(10);
		return bonusFrame;
	}

	private Frame getTenthFrame() {
		Frame frame = frames.get(9);
		return frame;
	}

	private Frame getCurrentFrame() {
		return frames.get(currentFrameIndex);
	}

	private Frame getNextFrame() {
		return frames.get(currentFrameIndex + 1);
	}

	private Frame getSecondNextFrame() {
		return frames.get(currentFrameIndex + 2);
	}

}
