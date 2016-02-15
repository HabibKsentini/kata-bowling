package com.sg.kata.bowling.util;

import java.util.HashMap;
import java.util.Map;

import com.sg.kata.bowling.BaseFrameConverter;
import com.sg.kata.bowling.BlankFrameConverter;
import com.sg.kata.bowling.SpareFrameConverter;
import com.sg.kata.bowling.StrikeFrameConverter;
import com.sg.kata.bowling.constant.FrameConstant;

public class FrameConverterUtil {

	private FrameConverterUtil() {
	}
	
	public static Map<String, Class<? extends BaseFrameConverter>> getConverterTypes() {
		Map<String, Class<? extends BaseFrameConverter>> convertersToFrameMap = new HashMap<>(3);
		convertersToFrameMap.put(FrameConstant.BLANK_FRAME_SYMBOL, BlankFrameConverter.class);
		convertersToFrameMap.put(FrameConstant.SPARE_FRAME_SYMBOL, SpareFrameConverter.class);
		convertersToFrameMap.put(FrameConstant.STRIKE_FRAME_SYMBOL, StrikeFrameConverter.class);
		return convertersToFrameMap;
	}

}
