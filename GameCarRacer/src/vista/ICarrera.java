package vista;

import controlador.CCarrera;

public interface ICarrera {
	public static final String INICIAR="iniciar";
	public static final String TERMINAR="terminar";
	public static final String ACTUALIZAR="actualizar";
	
	public void arrancar();
	public void setControlador(CCarrera c);
	public int getDistancia();
	public void setDistancia(int dis);
	public int getTiempo();
	public void terminar();
	public void iniciar();
	public void setPosicion(int car1, int car2, int car3, int car4, boolean noGanador);
	public void setGanador(double velocidad, String ganador);

}
