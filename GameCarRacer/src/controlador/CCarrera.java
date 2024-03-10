package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.MCarrera;
import vista.ICarrera;

public class CCarrera implements ActionListener {
	private ICarrera vista;
	private MCarrera modelo;
	
	public CCarrera(ICarrera vista, MCarrera modelo) {
		this.vista=vista;
		this.modelo=modelo;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int d=0;
		if( e.getActionCommand().equals(ICarrera.INICIAR)) {
			d=vista.getDistancia();
			if(d!=0) {
				modelo.iniciar();
				vista.iniciar();
			}
		}
		
		if(e.getActionCommand().equals(ICarrera.ACTUALIZAR)) {
			modelo.calPosicion();
			vista.setPosicion(modelo.getPos1(), modelo.getPos2(), modelo.getPos3(), modelo.getPos4(), modelo.isNoGanador());
		}
		
		if(e.getActionCommand().equals(ICarrera.TERMINAR)) {
			vista.terminar();
			vista.setGanador(modelo.getVelocidad(vista.getTiempo(), vista.getDistancia()), modelo.getGanador());
		}
		

	}

}
