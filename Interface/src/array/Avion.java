package array;

public class Avion extends Transporte implements Conduce{
	private double envergadura;
	private int alturaMax;
	
	public Avion() {
		
	}
	public Avion(String nombre, String medio, int capacidad, double envergadura, int alturaMax) {
		super(nombre, medio, capacidad);
		this.envergadura=envergadura;
		this.alturaMax=alturaMax;
	}
	public double getEnvergadura() {
		return envergadura;
	}
	public void setEnvergadura(double envergadura) {
		this.envergadura = envergadura;
	}
	public int getAlturaMax() {
		return alturaMax;
	}
	public void setAlturaMax(int alturaMax) {
		this.alturaMax = alturaMax;
	}
	@Override
	public void usarVolante() {
		System.out.println("Giro Izquierda = inclina a la izquierda, giro derecha= inclina a la derecha, si se empuja desciende y si se hala se eleva");
		
	}
	@Override
	public void usarPalanca() {
		System.out.println("Acelerar el avión");
		
	}
	@Override
	public void usarPedal() {
		System.out.println("Gira el avion a la derecha y a la izquierda");
		
	}
	
}
