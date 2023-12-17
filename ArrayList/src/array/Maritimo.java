package array;

public class Maritimo extends Transporte{
	private double eslora, calado;
		
	public Maritimo() {
		
	}
	public Maritimo(String nombre, String medio, int capacidad, int eslora, int calado) {
		super(nombre, medio, capacidad);
		this.eslora=eslora;
		this.calado=calado;
	}
	public double getEslora() {
		return eslora;
	}
	public void setEslora(double eslora) {
		this.eslora = eslora;
	}
	public double getCalado() {
		return calado;
	}
	public void setCalado(double calado) {
		this.calado = calado;
	}
	
}
