package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.MMat;
import vista.IMat;

public class CMat implements ActionListener {
	private MMat modelo;
	private IMat vista;
	
	public CMat(MMat modelo, IMat vista) {
		this.modelo=modelo;
		this.vista=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getActionCommand().equals(IMat.CALCULAR))
			vista.setRespuesta(modelo.calcular(vista.getA(), vista.getB(), vista.getOperacion()));

	}

}
