package com.sg.kata.bowling.model;

public interface Frame {

	public int getScore();

	public int getNumberOfTheNextThrowsToAddToTheScore();

	public int getFirstThrowPinsNumber();

	public int getSecondThrowPinsNumber();

	public default boolean isOneCharacterFrame() {
		return false;
	}

}
