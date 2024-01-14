package array;

public class Lancha extends Transporte implements Conduce{
	private double eslora, calado;
		
	public Lancha() {
		
	}
	public Lancha(String nombre, String medio, int capacidad, int eslora, int calado) {
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
	@Override
	public void usarVolante() {
		System.out.println("Gira izquierda= cruza a la izquierda. Gira derecha= cruza a la derecha.");
		
	}
	@Override
	public void usarPalanca() {
		System.out.println("Acelerar la lancha");
		
	}
	@Override
	public void usarPedal() {
		// TODO Auto-generated method stub
		
	}
	
}
