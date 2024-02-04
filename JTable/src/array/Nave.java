package array;

import java.util.Objects;

public class Nave {
	private String codigo, modelo, planeta, archivo;
	private int velocidad;
	
	public Nave(String codigo, String modelo, String planeta, int velocidad, String archivo) {
		this.codigo=codigo;
		this.modelo=modelo;
		this.planeta=planeta;
		this.velocidad=velocidad;
		this.archivo=archivo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nave other = (Nave) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	

}
