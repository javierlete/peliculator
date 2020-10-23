package com.ipartek.formacion.uf2216.ejemplodao.entidades;

public class Suscriptor {
	private Long id;
	private String nombre, apellidos;
	
	public Suscriptor(Long id, String nombre, String apellidos) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
	}
	
	public Suscriptor() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
//		String s = null;
//		
//		s.toUpperCase();
		
		if(id == null || id <= 0) {
			throw new EntidadesException("No se admiten ids menores o iguales a 0");
		}
		
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			throw new EntidadesException("El nombre no puede estar vacio");
		}
		
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Suscriptor other = (Suscriptor) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Suscriptor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
}
