package hilos;

public class Hilo implements Runnable{

	@Override
	public void run() {
		String texto="HOLA MUNDO";
		String acum="";
		for(int x=0; x<texto.length();x++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acum=acum+texto.charAt(x);
			System.out.println(acum+"-->");
			
		}
		
	}

}
