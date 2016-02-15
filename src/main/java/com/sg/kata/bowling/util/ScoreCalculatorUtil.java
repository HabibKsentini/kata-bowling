package com.sg.kata.bowling.util;

import java.util.HashMap;
import java.util.Map;

import com.sg.kata.bowling.constant.FrameConstant;

public class ScoreCalculatorUtil {

	private ScoreCalculatorUtil() {
	}

	public static int getScoreByCharacter(String throwCharcter) {
		Integer bonuScore = fillThrowCharacterScoreMap().get(throwCharcter);
		if (bonuScore == null) {
			bonuScore = Integer.valueOf(throwCharcter);
		}
		return bonuScore;
	}

	private static Map<String, Integer> fillThrowCharacterScoreMap() {
		Map<String, Integer> throwCharacterScoreMap = new HashMap<>();
		throwCharacterScoreMap.put(FrameConstant.STRIKE_FRAME_SYMBOL, FrameConstant.STRIKE_FRAME_SCORE);
		throwCharacterScoreMap.put(FrameConstant.BLANK_THROW_SYMBOL, FrameConstant.BLANK_FRAME_SCORE);
		return throwCharacterScoreMap;
	}

}
