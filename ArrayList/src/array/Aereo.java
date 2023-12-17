package array;

public class Aereo extends Transporte {
	private double envergadura;
	private int alturaMax;
	
	public Aereo() {
		
	}
	public Aereo(String nombre, String medio, int capacidad, double envergadura, int alturaMax) {
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
}
