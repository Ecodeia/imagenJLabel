package hilos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Temporizador  extends JFrame implements Runnable{
	
	private JTextField tPantalla;
	private boolean seguir, valida;
	public int tiempo;
	
	public Temporizador() {
		super("Temporizador");
		this.setSize(250, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		tPantalla= new JTextField();
		tPantalla.setHorizontalAlignment(JTextField.RIGHT);
		tPantalla.setEditable(false);
		tPantalla.setCaretColor(getBackground());
		tPantalla.setFont(new Font("DS-Digital", Font.PLAIN, 100));
		this.add(tPantalla, BorderLayout.CENTER);
		
		seguir=false;
		valida=true;
		
		while(valida) {
			try {
				tiempo=Integer.parseInt(JOptionPane.showInputDialog("Escriba un tiempo en segundos:"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Debe escribir un numero entero.");	
			}
			if(tiempo>0) {
				valida=false;
				seguir=true;
				tPantalla.setText(tiempo+"");
			}
		}
	}
	@Override
	public void run() {
		while(seguir && tiempo>0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tiempo--;
			tPantalla.setText(tiempo+"");
			if(tiempo<4)
				Toolkit.getDefaultToolkit().beep();
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}
