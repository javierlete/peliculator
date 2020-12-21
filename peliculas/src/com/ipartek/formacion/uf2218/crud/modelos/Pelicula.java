package com.ipartek.formacion.uf2218.crud.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pelicula {
	private Long id;
	private String titulo;
	private LocalDate fechaEstreno;
	private Genero genero;
	private Genero subGenero;
	
	private boolean correcto = true;
	
	private String errorId, errorTitulo, errorGenero, errorFechaEstreno;
	
	public Pelicula(String id, String titulo, Genero genero, Genero subGenero, String fechaEstreno) {
		setId(id);
		setTitulo(titulo);
		setGenero(genero);
		setSubGenero(subGenero);
		setFechaEstreno(fechaEstreno);
	}
	
	public Pelicula(Long id, String titulo, Genero genero, Genero subGenero, LocalDate fechaEstreno) {
		setId(id);
		setTitulo(titulo);
		setGenero(genero);
		setSubGenero(subGenero);
		setFechaEstreno(fechaEstreno);
	}

	public Pelicula() {	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Sobrecarga de setId para String
	public void setId(String id) {
		Long peliculaId;
		try {
			peliculaId = id.length() == 0 ? null : Long.parseLong(id);
			setId(peliculaId);
		} catch (NumberFormatException e) {
			setErrorId("El id debe ser numérico");
		}
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		if(titulo == null || titulo.trim().length() < 3) {
			setErrorTitulo("No se admiten títulos de menos de 3 caracteres");
		}
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public void setFechaEstreno(LocalDate fechaEstreno) {
		if(fechaEstreno.isAfter(LocalDate.now())) {
			setErrorFechaEstreno("No se admiten estrenos futuros");
		}
		this.fechaEstreno = fechaEstreno;
	}
	
	// Sobrecarga de setFechaEstreno de String
	public void setFechaEstreno(String fechaEstreno) {
		LocalDate peliculaFechaEstreno;
		try {
			peliculaFechaEstreno = LocalDate.parse(fechaEstreno, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			setFechaEstreno(peliculaFechaEstreno);
		} catch (Exception e) {
			setErrorFechaEstreno("La fecha debe tener un formato 1234-12-12");
		}
	}
	
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public Genero getSubGenero() {
		return subGenero;
	}

	public void setSubGenero(Genero subGenero) {
		this.subGenero = subGenero;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		correcto = false;
		this.errorId = errorId;
	}

	public String getErrorTitulo() {
		return errorTitulo;
	}

	public void setErrorTitulo(String errorTitulo) {
		correcto = false;
		this.errorTitulo = errorTitulo;
	}

	public String getErrorGenero() {
		return errorGenero;
	}

	public void setErrorGenero(String errorGenero) {
		correcto = false;
		this.errorGenero = errorGenero;
	}

	public String getErrorFechaEstreno() {
		return errorFechaEstreno;
	}

	public void setErrorFechaEstreno(String errorFechaEstreno) {
		correcto = false;
		this.errorFechaEstreno = errorFechaEstreno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (correcto ? 1231 : 1237);
		result = prime * result + ((fechaEstreno == null) ? 0 : fechaEstreno.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subGenero == null) ? 0 : subGenero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Pelicula other = (Pelicula) obj;
		if (correcto != other.correcto)
			return false;
		if (fechaEstreno == null) {
			if (other.fechaEstreno != null)
				return false;
		} else if (!fechaEstreno.equals(other.fechaEstreno))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (subGenero == null) {
			if (other.subGenero != null)
				return false;
		} else if (!subGenero.equals(other.subGenero))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", fechaEstreno=" + fechaEstreno + ", genero=" + genero
				+ ", subGenero=" + subGenero + ", correcto=" + correcto + ", errorId=" + errorId + ", errorTitulo="
				+ errorTitulo + ", errorGenero=" + errorGenero + ", errorFechaEstreno=" + errorFechaEstreno + "]";
	}
}
