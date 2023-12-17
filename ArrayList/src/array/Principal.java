package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Terrestre> terrestres= new ArrayList<Terrestre>();
		terrestres.add(new Terrestre("Tren", "terrestre", "rieles", 300000, 8));
		terrestres.add(new Terrestre("camion", "terrestre", "carretera", 7500, 8));
		terrestres.add(new Terrestre("automovil", "terrestre", "carretera", 600, 4));
		terrestres.add(new Terrestre("motocicleta", "terrestre", "carretera", 100, 2));
		
		System.out.println("************ TERRESTRES ************");
		System.out.println("====================================");
		
		for(Terrestre te: terrestres)
			System.out.println("nombre= "+te.getNombre()+" nro. de ruedas= "+te.getNroRuedas());
		
		ArrayList<Maritimo> maritimos= new ArrayList<Maritimo>();
		maritimos.add(new Maritimo("bote", "acuatico", 300, 5, 1));
		maritimos.add(new Maritimo("submarino", "acuatico", 6000, 200, 3));
		maritimos.add(new Maritimo("barco", "acuatico", 30000, 25, 4));
		maritimos.add(new Maritimo("remolcador", "acuatico", 10000, 15, 3));
		
		System.out.println("************ MARITIMO ************");
		System.out.println("====================================");
		
		for(Maritimo ma: maritimos)
			System.out.println("nombre= "+ma.getNombre()+" eslora= "+ma.getEslora());
		
		ArrayList<Aereo> aereos= new ArrayList<Aereo>();
		aereos.add(new Aereo("Globo", "aereo", 200, 10, 8000));
		aereos.add(new Aereo("avioneta", "aereo", 400, 120, 10000));
		aereos.add(new Aereo("Boing", "aereo", 20000, 30, 12000));
		aereos.add(new Aereo("Dirigible", "aereo", 5000, 20, 9000));
		
		System.out.println("************ AEREO ************");
		System.out.println("====================================");
		
		for(Aereo ae: aereos)
			System.out.println("nombre= "+ae.getNombre()+" envergadura= "+ae.getEnvergadura());
		
		maritimos.add(3, new Maritimo("Catamaran", "acuatico", 2000, 50, 2));
		
		System.out.println("************ MARITIMO ************");
		System.out.println("====================================");
		
		for(Maritimo ma: maritimos)
			System.out.println("nombre= "+ma.getNombre()+" eslora= "+ma.getEslora());
		
		System.out.println("Size del array terrestre= "+ terrestres.size());
		
		aereos.set(0, new Aereo("Globito", "aereo", 200, 10, 8000));
		
		System.out.println("************ AEREO ************");
		System.out.println("====================================");
		
		for(Aereo ae: aereos)
			System.out.println("nombre= "+ae.getNombre()+" envergadura= "+ae.getEnvergadura());		
		
		ArrayList<Transporte> transportes= new ArrayList<Transporte>();
		transportes.addAll(terrestres);
		transportes.addAll(maritimos);
		transportes.addAll(aereos);
		
		System.out.println("************ TRANSPORTES ************");
		System.out.println("====================================");
		
		Collections.sort(transportes);
		
		for(Transporte t: transportes)
			System.out.println("nombre= "+t.getNombre()+" Capacidad= "+t.getCapacidad());	
		
		//Terrestre objeto=(Terrestre)transportes.get(1);
		//System.out.println("nombre= "+objeto.getNombre()+" nro cauchos= "+objeto.getNroRuedas());
		if(transportes.contains(new Aereo("Globito", "aereo", 400, 10, 8000)))
			System.out.println("ENCONTRADO");
		else
			System.out.println("NO ENCONTRADO");	
	}

}
