package imagenes;


import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Ventana extends JFrame {
	public Ventana() {
		super("Imágenes");
		this.setSize(1300, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(1, 3));
		
		ImageIcon imagen = new ImageIcon("media/Boston.jpg");
		
		JLabel lGrande= new JLabel("", JLabel.CENTER);
		lGrande.setSize(400, 600);
		
		JLabel lMediano= new JLabel("", JLabel.CENTER);
		lMediano.setSize(200, 300);
		
		JLabel lMinimo= new JLabel("", JLabel.CENTER);
		lMinimo.setSize(100, 150);
		
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lGrande.getWidth(), lGrande.getHeight(), Image.SCALE_DEFAULT));
		lGrande.setIcon(icono);
		this.add(lGrande);
		
		icono= new ImageIcon(imagen.getImage().getScaledInstance(lMediano.getWidth(), lMediano.getHeight(), Image.SCALE_DEFAULT));
		lMediano.setIcon(icono);
		this.add(lMediano);
		
		icono= new ImageIcon(imagen.getImage().getScaledInstance(lMinimo.getWidth(), lMinimo.getHeight(), Image.SCALE_DEFAULT));
		lMinimo.setIcon(icono);
		this.add(lMinimo);
		
		
		
		
		
		
		
		
		
		
		
	}

}
