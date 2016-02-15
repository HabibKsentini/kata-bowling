package com.sg.kata.bowling.constant;

public class FrameConstant {
	
	private FrameConstant(){
	}
	
	public final static String BLANK_THROW_SYMBOL = "-";
	public final static String BLANK_FRAME_SYMBOL = "--";
	public final static String STRIKE_FRAME_SYMBOL = "X";
	public final static String SPARE_FRAME_SYMBOL = "/";
	
	public final static int STRIKE_FRAME_SCORE = 10;
	public final static int SPARE_FRAME_SCORE = 10;
	public final static int BLANK_FRAME_SCORE = 0;
	
	public final static int STRIKE_FRAME_NUMBER_OF_THE_NEXT_THROWS_TO_ADD_TO_THE_SCORE = 2; 
	public final static int SPARE_FRAME_NUMBER_OF_THE_NEXT_THROWS_TO_ADD_TO_THE_SCORE = 1; 
	public final static int NORMAL_FRAME_NUMBER_OF_THE_NEXT_THROWS_TO_ADD_TO_THE_SCORE = 0; 
	public final static int BLANK_FRAME_NUMBER_OF_THE_NEXT_THROWS_TO_ADD_TO_THE_SCORE = 0; 
	

}
