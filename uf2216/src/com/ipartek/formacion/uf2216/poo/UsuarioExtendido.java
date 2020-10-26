package com.ipartek.formacion.uf2216.poo;

public class UsuarioExtendido extends Usuario {

	private static final long serialVersionUID = -3376810124937936265L;

	private String direccion, telefono;
	
	public UsuarioExtendido(Long id, String email, String password, String direccion, String telefono) {
		super(id, email, password);
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public UsuarioExtendido(Long id, String email, String password) {
		//super(id, email, password);
		this(id, email, password, null, null);
	}

	public UsuarioExtendido(String email, String password) {
		//super(email, password);
		this(null, email, password, null, null);
	}

	public UsuarioExtendido() {
		super();
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String convertirATexto() {
		return super.convertirATexto() + String.format(", dirección: %s, teléfono: %s", direccion, telefono);
	}
}
