package com.sg.kata.bowling.util;

import java.util.Objects;

public class StringUtil {

	public static int getIntByIndex(int charIndex, String string) {
		Objects.requireNonNull(string);
		int number = Character.getNumericValue(string.charAt(charIndex));
		return number;
	}

}
