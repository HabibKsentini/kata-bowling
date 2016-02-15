package com.sg.kata.bowling;

import java.util.ArrayList;
import java.util.List;

import com.sg.kata.bowling.constant.FrameConstant;
import com.sg.kata.bowling.exception.FrameConversionException;
import com.sg.kata.bowling.model.BonusFrame;
import com.sg.kata.bowling.model.BowlingGame;
import com.sg.kata.bowling.model.Frame;
import com.sg.kata.bowling.util.FrameConverterUtil;

public class GameResultsSequenceToFramesConverter {

	private int currentFrameIndex;
	private final String gameResultsSequence;
	private List<Frame> frames;

	public GameResultsSequenceToFramesConverter(String gameResultsSequence) {
		this.gameResultsSequence = gameResultsSequence;
		this.frames = new ArrayList<>();
	}

	
	public List<Frame> convert() {
		while (isCurrentFrameIndexLessThenTheGameSequenceLength() && isFramesSizeLessThenTheGameFramesNumber()) {
			String frameSequence = getCurrentFrameSequence();
			Frame frame = convertToFrame(frameSequence);
			frames.add(frame);
		}
		addBonusFrameIfExists();
		return frames;
	}
	
	private boolean isFramesSizeLessThenTheGameFramesNumber(){
		return frames.size()< BowlingGame.NUMBER_OF_FRAMES;
	}
	
	private boolean isCurrentFrameIndexLessThenTheGameSequenceLength(){
		return currentFrameIndex < gameResultsSequence.length();
	}
	

	private String getCurrentFrameSequence() {
		String frameSequence;
		if (isFrameSequenceOfStrike()) {
			frameSequence = getFrameSequenceOfStrike();
		} else {
			frameSequence = getFrameSequence();
			currentFrameIndex++;
		}
		currentFrameIndex++;
		return frameSequence;
	}

	private Frame convertToFrame(String frameSequence) {
		Class<? extends BaseFrameConverter> frameConverter = getFrameConverter(frameSequence);
		Frame frame = null;
		if (frameConverter != null) {
			try {
				frame = frameConverter.newInstance().convert(frameSequence);
			} catch (InstantiationException | IllegalAccessException e) {
				throw new FrameConversionException(e); 
			}
		}
		return frame;
	}

	private boolean isFrameSequenceOfStrike() {
		String frameSequence = getFrameSequenceOfStrike();
		return frameSequence.equals(FrameConstant.STRIKE_FRAME_SYMBOL);
	}

	private String getFrameSequenceOfStrike() {
		int endIndex = currentFrameIndex + 1; 
		String frameSequence = this.gameResultsSequence.substring(currentFrameIndex, endIndex);
		return frameSequence;
	}

	private String getFrameSequence() {
		int endIndex = currentFrameIndex + 2;
		String frameSequence = this.gameResultsSequence.substring(currentFrameIndex, endIndex);
		return frameSequence;
	}

	private Class<? extends BaseFrameConverter> getFrameConverter(final String frameSequence) {
		String key = prepareKey(frameSequence);
		Class<? extends BaseFrameConverter> frameConverter = FrameConverterUtil.getConverterTypes().get(key);
		if (frameConverter == null) {
			frameConverter = NormalFrameConverter.class;
		}
		return frameConverter;
	}

	private String prepareKey(String frameSequence) {
		if (isSecondCharacterASpareCharacter(frameSequence)) {
			return FrameConstant.SPARE_FRAME_SYMBOL;
		}
		return frameSequence;
	}

	private boolean isSecondCharacterASpareCharacter(String frameSequence) {
		String secondChar = frameSequence.substring(1);
		return secondChar.equals(FrameConstant.SPARE_FRAME_SYMBOL);
	}
	
	private void addBonusFrameIfExists(){
		if(! isCurrentFrameIndexLessThenTheGameSequenceLength()){
			return;
		}
		String bonusSequence = gameResultsSequence.substring(currentFrameIndex);
		Frame frame =  new BonusFrame(bonusSequence);
		frames.add(frame);
	}

}
