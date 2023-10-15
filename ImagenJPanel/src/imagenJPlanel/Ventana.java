package imagenJPlanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	
	public Ventana() {
		// configuración del JFrame
		super("FORMULARIO"); 
		this.setSize(300,240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//JPanel con la imagen de fondo y se establece el gridlayout
		FondoJPanel fondo= new FondoJPanel("media/fondo.jpg");
		fondo.setLayout(new GridLayout(3,2,25,25));
		
		//se crea un objeto de tipo Font que sera usada en todos los componentes que usen texto
		Font fuente= new Font("Arial", Font.BOLD, 18);
		
		//Agregamos los compoenetes
		JLabel lTitulo= new JLabel("FORMULARIO:");
		lTitulo.setFont(fuente);
		lTitulo.setForeground(Color.WHITE);
		fondo.add(lTitulo);
		
		JLabel lImagen= new JLabel("",JLabel.CENTER);
		lImagen.setSize(50,37);
		ImageIcon imagen= new ImageIcon("media/hamburguesa.png");
		lImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT)));
		fondo.add(lImagen);
		
		JLabel lDato= new JLabel("DATO:");
		lDato.setFont(fuente);
		lDato.setForeground(Color.WHITE);
		fondo.add(lDato);
		
		JTextField tDato= new JTextField(8);
		fondo.add(tDato);
		
		JButton bBoton= new JButton("BOTON");
		bBoton.setFont(fuente);
		bBoton.setForeground(Color.white);
		bBoton.setBackground(Color.GRAY);
		fondo.add(bBoton);
		
		JButton bSalir= new JButton("SALIR");
		bSalir.setFont(fuente);
		bSalir.setForeground(Color.white);
		bSalir.setBackground(Color.GRAY);
		fondo.add(bSalir);
		
		//Se asigna el JPanel "fondo" al JFrame
		this.add(fondo, BorderLayout.CENTER);
	}

}
