package array;

public class Cohete implements Conduce{

	@Override
	public void usarVolante() {
		System.out.println("Controla el combustible");
		
	}

	@Override
	public void usarPalanca() {
		System.out.println("Controla la Aceleracion");
		
	}

	@Override
	public void usarPedal() {
		System.out.println("Inclinacion de la nave");
		
	}

}
