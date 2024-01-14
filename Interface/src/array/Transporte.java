package array;

import java.util.Objects;

public class Transporte implements Comparable<Transporte> {
	private String nombre, medio;
	private int capacidad;
	
	public Transporte() {
		
	}
	public Transporte(String nombre, String medio, int capacidad) {
		this.nombre=nombre;
		this.medio=medio;
		this.capacidad=capacidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	@Override
	public int compareTo(Transporte o) {
		if(o.getCapacidad()>this.capacidad)
			return -1;
		else if(o.getCapacidad()<this.capacidad)
			return 1;
		else
			return 0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(capacidad, medio, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transporte other = (Transporte) obj;
		return capacidad == other.capacidad && Objects.equals(medio, other.medio)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
	
}
