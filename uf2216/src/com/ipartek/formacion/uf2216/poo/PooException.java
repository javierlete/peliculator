package com.ipartek.formacion.uf2216.poo;

public class PooException extends RuntimeException {

	private static final long serialVersionUID = 6714623585371044668L;
	
	public PooException() {
	}

	public PooException(String message) {
		super(message);
	}

	public PooException(Throwable cause) {
		super(cause);
	}

	public PooException(String message, Throwable cause) {
		super(message, cause);
	}

	public PooException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
