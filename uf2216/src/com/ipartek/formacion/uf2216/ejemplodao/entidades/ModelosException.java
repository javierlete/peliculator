package com.ipartek.formacion.uf2216.ejemplodao.entidades;

public class ModelosException extends RuntimeException {

	private static final long serialVersionUID = 2403287818233968121L;

	public ModelosException() {
	}

	public ModelosException(String message) {
		super(message);
	}

	public ModelosException(Throwable cause) {
		super(cause);
	}

	public ModelosException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModelosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
