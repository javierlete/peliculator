package com.ipartek.formacion.uf2218.crud.entidades;

public class EntidadesException extends RuntimeException {

	private static final long serialVersionUID = 2403287818233968121L;

	public EntidadesException() {
	}

	public EntidadesException(String message) {
		super(message);
	}

	public EntidadesException(Throwable cause) {
		super(cause);
	}

	public EntidadesException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
