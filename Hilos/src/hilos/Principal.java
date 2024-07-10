package hilos;

public class Principal {

	public static void main(String[] args) {
		// Ejemplo 1. clase implementando Runnable
		Hilo saludo = new Hilo();
		Thread hiloSaludo= new Thread(saludo);
		hiloSaludo.start();
		
		//Ejemplo 2. Creando un objeto Thread e implementando Runnable
		//gITHUB
		Thread hilo1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int x=0;x<10;x++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("*HILO 1* <---");
					
				}
				
			}
		});
		hilo1.start();
		
		//Ejemplo 3. Clase que hereda de Thread
		Subproceso hilo2= new Subproceso();
		hilo2.start();
		
		//Temporizador usando GUI e implementado Runnable
		Temporizador temp= new Temporizador();
		temp.setVisible(true);
		Thread t= new Thread(temp);
		t.start();
		System.out.println("FIN DEL BLOQUE PRINCIPAL");
	}

}
