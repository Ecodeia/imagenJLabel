package imagenJlabel;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {
	public Ventana() {
		super("Ejemplo");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(1, 2));
		
		JLabel label= new JLabel("", JLabel.CENTER);
		label.setIcon(new ImageIcon("media/java.jpg"));
		this.add(label);
		
		this.add(new JLabel("IMAGEN DE PRUEBA"));  
		
	}

}
