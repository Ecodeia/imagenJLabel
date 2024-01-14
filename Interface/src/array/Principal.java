package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) {
		Automovil auto= new Automovil("Fiat Uno", "CARRETERA", "TERRESTRE", 5000, 4);
		Conduce conducir=(Conduce) auto;
		conducir.usarVolante();
		conducir.usarPedal();
		conducir.usarPalanca();
		
		Conduce conducirAvion= new Avion("Cessna", "Aereo", 6, 15, 30000);
		
		conducirAvion.usarVolante();
		conducirAvion.usarPedal();
		conducirAvion.usarPalanca();
		
		conducir= new Cohete();
		System.out.println();
		System.out.println("=================COHETE==============");
		conducir.usarVolante();
		conducir.usarPedal();
		conducir.usarPalanca();
		
		ArrayList<Conduce> conducen= new ArrayList<Conduce>();
		conducen.add(conducirAvion);
		conducen.add(auto);
		conducen.add(conducir);
		
		for(Conduce con : conducen)
			con.usarVolante();
	}

}
