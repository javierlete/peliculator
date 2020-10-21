package com.ipartek.formacion.uf2216.genericos;

public class Punto<TX, TY> {
	private TX x;
	private TY y;
	
	public Punto(TX x, TY y) {
		super();
		this.x = x;
		this.y = y;
	}

	public TX getX() {
		return x;
	}

	public void setX(TX x) {
		this.x = x;
	}

	public TY getY() {
		return y;
	}

	public void setY(TY y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	
	
}
