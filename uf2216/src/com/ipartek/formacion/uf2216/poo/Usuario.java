package com.ipartek.formacion.uf2216.poo;

import java.io.Serializable;

import com.ipartek.formacion.uf2216.bibliotecas.ExpReg;

public class Usuario implements Serializable {

	private static final long serialVersionUID = -6033642070911568300L;
	
	// Variable "de clase"
	private static int contador;
	// Variables de instancia
	// Fields (campos)
	private Long id;
	private String email, password;
	
	// "Constructor estático" ("de clase") Bloque estático
	static {
		contador = 0;
	}
	
	// Constructor
	public Usuario(Long id, String email, String password) {
		setId(id);
		setEmail(email);
		setPassword(password);
		
		contador++;
	}
	
	public Usuario(String email, String password) {
		this(null, email, password);
	}
	
	public Usuario() {
		contador++;
	}

	// Destructor: No se suele utilizar
	protected void finalize() {
		System.out.println("DESTRUCTOR: " + id + "," + email + "," + password);
		contador--;
	}
	
	// Getters y Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Integer id) {
		setId(new Long(id));
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * Comprueba el email si es válido
	 * @param email
	 * @throws PooException en el caso de que el Email no sea válido
	 */
	public void setEmail(String email) {
		if(email == null) {
			throw new PooException("No se admiten emails nulos");
		}
		
		if(email.trim().length() == 0) {
			throw new PooException("No se admite un email vacío");
		}
		
		if(!email.matches("\\s*" + ExpReg.EMAIL + "\\s*")) {
			throw new PooException("No tiene el formato de un email");
		}
		
		this.email = email.trim();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	/**
	 * Muestra en lugar de la contraseña, el caracter sustituto
	 * @param sustituto Caracter que se va a utilizar para sustituir los caracteres de la contraseña
	 * @return Contraseña con caracter sustituto en lugar de sus caracteres originales
	 */
	
	public String getPassword(char sustituto) {
		return password.replaceAll(".", String.valueOf(sustituto));
	}
	
	// Método "de clase"
	public static int getContador() {
		return contador;
	}

	public String convertirATexto() {
		return String.format("ID: %s, email: %s, password: %s", id, email, password);
	}
}
