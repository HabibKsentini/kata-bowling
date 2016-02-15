package com.sg.kata.bowling.model;

import java.util.List;

import com.sg.kata.bowling.GameResultsSequenceToFramesConverter;
import com.sg.kata.bowling.ScoreCalculator;

public class BowlingGame {

	public static int NUMBER_OF_FRAMES = 10;
	private String gameResultsSequence;
	private int score; 

	public BowlingGame(String gameResultsSequence) {
		this.gameResultsSequence = gameResultsSequence;
	}

	public int calculateScore() {
		GameResultsSequenceToFramesConverter gameResultsSequenceToFramesConverter = new GameResultsSequenceToFramesConverter(
				gameResultsSequence);
		List<Frame> frames = gameResultsSequenceToFramesConverter.convert();
		ScoreCalculator scoreCalculator = new ScoreCalculator(frames);
		score = scoreCalculator.calculate();
		return score;
	}
	
	public int getScore(){
		return this.score;
	}

}
