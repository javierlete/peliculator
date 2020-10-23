package com.ipartek.formacion.uf2216.ejemplodao.accesodatos;

public class BorrarException extends AccesoDatosException {

	private static final long serialVersionUID = 1073646973961960110L;

	public BorrarException() {
	}

	public BorrarException(String message) {
		super(message);
	}

	public BorrarException(Throwable cause) {
		super(cause);
	}

	public BorrarException(String message, Throwable cause) {
		super(message, cause);
	}

	public BorrarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
