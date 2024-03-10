package principal;

import controlador.CCarrera;
import modelo.MCarrera;
import vista.ICarrera;
import vista.VCarrera;

public class Principal {

	public static void main(String[] args) {
		ICarrera vista= new VCarrera();
		MCarrera modelo= new MCarrera();
		
		CCarrera controlador= new CCarrera(vista, modelo);
		
		vista.setControlador(controlador);
		
		vista.arrancar();

	}

}
