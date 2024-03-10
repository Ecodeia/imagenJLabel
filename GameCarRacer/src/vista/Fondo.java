package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel{
	private ImageIcon imagen;
	private String ruta;
	
	public Fondo(String ruta) {
		this.ruta=ruta;
	}
	public void paint(Graphics g) {
		Dimension tama= this.getSize();
		imagen= new ImageIcon(ruta);
		g.drawImage(imagen.getImage(), 0, 0, tama.width, tama.height, null);
		this.setOpaque(false);
		super.paint(g);
	}
}
