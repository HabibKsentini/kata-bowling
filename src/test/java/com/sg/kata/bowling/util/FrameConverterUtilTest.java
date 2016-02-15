package com.sg.kata.bowling.util;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.sg.kata.bowling.BaseFrameConverter;
import com.sg.kata.bowling.BlankFrameConverter;
import com.sg.kata.bowling.SpareFrameConverter;
import com.sg.kata.bowling.StrikeFrameConverter;
import com.sg.kata.bowling.constant.FrameConstant;

public class FrameConverterUtilTest {
	
	@Test
	public void getConverterTypes_should_return_frame_converters(){
		Map<String, Class<? extends BaseFrameConverter>>  convertersToFrameMap = FrameConverterUtil.getConverterTypes(); 
		Assert.assertNotNull(convertersToFrameMap);
		Assert.assertTrue(convertersToFrameMap.size() == 3);
		Assert.assertTrue(convertersToFrameMap.get(FrameConstant.BLANK_FRAME_SYMBOL) == BlankFrameConverter.class);
		Assert.assertTrue(convertersToFrameMap.get(FrameConstant.SPARE_FRAME_SYMBOL) == SpareFrameConverter.class);
		Assert.assertTrue(convertersToFrameMap.get(FrameConstant.STRIKE_FRAME_SYMBOL) == StrikeFrameConverter.class);
	}

}
