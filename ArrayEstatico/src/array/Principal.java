package array;

public class Principal {
	
	public static final int TAMA=6;
	
	public static void main(String[] args) {
		/*
		 * char[] letras= new char[TAMA]; letras[0]='a'; letras[1]='b'; letras[2]='c';
		 * letras[3]='d'; letras[4]='e'; letras[5]='f';
		 */
		
		char[] letras= {'a','b','c','d','e','f'};
		
		for(int x=0; x<TAMA; x++)
			System.out.println(letras[x]);
		
		String [] [] nombres= {{"Ana","Maria","Jose"},
				               {"Eva","Juan","Carlos"},
				               {"Victor","Ines","Pedro"}};
		nombres[1][0]="Evaristo";
		
		for(int filas=0; filas<3; filas++) {
			for(int columnas=0; columnas<3; columnas++) {
				System.out.print(nombres[filas][columnas]+" - ");
			}
			System.out.println();
		}
		
		Persona[] personas= new Persona[TAMA];
		personas[0]= new Persona("Jose", 20, 1200);
		personas[1]= new Persona();
		personas[1].setNombre("Maria");
		personas[1].setEdad(22);
		
		for( int x=0; x<TAMA; x++)
			if(personas[x]!=null)
			System.out.println("Nombre: "+personas[x].getNombre()+" edad: "+personas[x].getEdad());
		
		for(Persona per: personas)
			if(per!=null)
				System.out.println("Este Nombre: "+per.getNombre()+" Esta Edad: "+per.getEdad());
		
		for(String[] noms: nombres) {
			for(String nom: noms)
				System.out.print(nom+" * ");
			System.out.println();
		}
		
		
		
	}

}
