package com.sg.kata.bowling.exception;

public class FrameConversionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FrameConversionException() {
		super();
	}

	public FrameConversionException(String message) {
		super(message);
	}

	public FrameConversionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FrameConversionException(Throwable cause) {
		super(cause);
	}

}
