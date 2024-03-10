package modelo;

public class MCarrera {
	private int pos1, pos2, pos3, pos4;
	private String ganador;
	private boolean noGanador;
	
	public void iniciar() {
		pos1=0;
		pos2=0;
		pos3=0;
		pos4=0;
		noGanador= true;
	}
	
	public int mover() {
		return (int) (Math.random()*18)+2;
	}
	
	public void calPosicion() {
		if(noGanador) {
			pos1= pos1+mover();
			pos2= pos2+mover();
			pos3= pos3+mover();
			pos4= pos4+mover();
		}
		int[] posi= {pos2,pos3,pos4};
		int mayor= pos1;
		int ngan=1;
		for(int i=0; i<posi.length; i++) {
			if(posi[i]>mayor) {
				mayor=posi[i];
				ngan=i+2;
			}
		}
		if(mayor>= 800 && noGanador) {
			noGanador= false;
			ganador= "Carro "+ngan;
		}
	}
	
	public double getVelocidad(int tiempo, int distancia) {
		return distancia/tiempo;
	}

	public int getPos1() {
		return pos1;
	}

	public int getPos2() {
		return pos2;
	}

	public int getPos3() {
		return pos3;
	}

	public int getPos4() {
		return pos4;
	}

	public String getGanador() {
		return ganador;
	}

	public boolean isNoGanador() {
		return noGanador;
	}
	
}
