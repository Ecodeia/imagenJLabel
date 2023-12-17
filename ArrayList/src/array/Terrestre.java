package array;

public class Terrestre extends Transporte{
	private int nroRuedas;
	private String tipo;
	
	public Terrestre() {
		
	}
	public Terrestre(String nombre, String medio, String tipo, int capacidad, int nroRuedas) {
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
}
