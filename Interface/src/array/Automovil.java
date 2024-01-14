package array;

public class Automovil extends Transporte implements Conduce{
	private int nroRuedas;
	private String tipo;
	
	public Automovil() {
		
	}
	public Automovil(String nombre, String medio, String tipo, int capacidad, int nroRuedas) {
		super(nombre, medio, capacidad);
		this.nroRuedas=nroRuedas;
		this.tipo=tipo;
	}
	public int getNroRuedas() {
		return nroRuedas;
	}
	public void setNroRuedas(int nroRuedas) {
		this.nroRuedas = nroRuedas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public void usarVolante() {
		System.out.println("Gira izquierda= cruza a la izquierda. gira derecha= cruza a la derecha");
		
	}
	@Override
	public void usarPalanca() {
		System.out.println("Cambio de velocidades y retroceso");
		
	}
	@Override
	public void usarPedal() {
		System.out.println("pedal freno, pedal de embrague y pedal de aceleración");
		
	}
	
}
