package principal;

import controlador.CMat;
import modelo.MMat;
import vista.IMat;
import vista.VMat;
import vista.VMat2;

public class Principal {

	public static void main(String[] args) {
		MMat modelo= new MMat();
		IMat vista= new VMat();
		IMat vista2= new VMat2();
		
		
		CMat controlador= new CMat(modelo, vista);
		CMat controlador2= new CMat(modelo, vista2);
		
		vista.setControlador(controlador);
		vista2.setControlador(controlador2);
		
		vista.arrancar();
		vista2.arrancar();
	}

}
