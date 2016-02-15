package com.sg.kata.bowling.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void getIntByIndex_should_return_the_second_int() {
		int result = StringUtil.getIntByIndex(1, "1233");
		int expected = 2; 
		Assert.assertTrue(result == expected);
	}
}
