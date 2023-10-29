package hilos;

public class Subproceso extends Thread{
	public void run() {
		for(int x=0; x<10;x++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("* HILO 2 *");
			
		}
	}

}
