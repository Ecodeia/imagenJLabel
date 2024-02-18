package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{
	
	public Ventana() {
		super("GridBagLayout");
		this.setSize(380, 380);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Norte
		JPanel pTitulo= new JPanel();
		pTitulo.setBackground(Color.BLUE);
		JLabel lTitulo= new JLabel("REGISTRO DE MASCOTAS", JLabel.CENTER);
		lTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lTitulo.setForeground(Color.ORANGE);
		pTitulo.add(lTitulo);
		this.add(pTitulo, BorderLayout.NORTH);
		
		
		//Sur
		JPanel pBot= new JPanel(new GridLayout(1, 2, 30, 5	));
		pBot.setBackground(Color.BLUE);
		pBot.setBorder(new EmptyBorder(0,30,0,30));
		
		JButton bProcesar= new JButton("PROCESAR");
		pBot.add(bProcesar);
		
		JButton bSalir= new JButton("SALIR");
		pBot.add(bSalir);
		
		this.add(pBot, BorderLayout.SOUTH);
		
		//Centro
		JPanel pForm= new JPanel(new GridBagLayout());
		pForm.setBackground(Color.BLUE);
		pForm.setBorder(new EmptyBorder(5,10,5,10));
		
		GridBagConstraints reglas= new GridBagConstraints();
		
		reglas.gridx=0;
		reglas.gridy=0;
		reglas.gridwidth=1;
		reglas.gridheight=1;
		reglas.weightx=0.0;
		reglas.weighty=1.0;
		reglas.anchor= reglas.WEST;
		JLabel lNom= new JLabel("NOMBRE: ");
		lNom.setForeground(Color.WHITE);
		pForm.add(lNom, reglas);
		
		reglas.gridx=1;
		reglas.gridy=0;
		reglas.gridwidth=1;
		reglas.gridheight=1;
		reglas.weightx=0.0;
		pForm.add(new JTextField(10), reglas);
		
		reglas.gridx=2;
		reglas.gridy=0;
		reglas.gridwidth=1;
		reglas.gridheight=1;
		reglas.weightx=1.0;
		reglas.anchor=reglas.SOUTH;
		reglas.fill=reglas.HORIZONTAL;
		JButton bFoto= new JButton("Foto");
		pForm.add(bFoto, reglas);
		
		reglas.gridx=0;
		reglas.gridy=1;
		reglas.gridwidth=1;
		reglas.gridheight=1;
		reglas.weighty=1.0;
		reglas.anchor=reglas.WEST;
		reglas.fill=reglas.NONE;
		JLabel lRaza= new JLabel("RAZA: ");
		lRaza.setForeground(Color.WHITE);
		pForm.add(lRaza, reglas);
		
		reglas.gridx=1;
		reglas.gridy=1;
		reglas.gridwidth=1;
		reglas.gridheight=1;
		pForm.add(new JTextField(10), reglas); 
		
		reglas.gridx=2;
		reglas.gridy=1;
		reglas.gridwidth=1;
		reglas.gridheight=4;
		reglas.anchor=reglas.CENTER;
		ImageIcon img= new ImageIcon("media/perro.jpg");
		JLabel lImagen= new JLabel();
		lImagen.setSize(150, 140);
		lImagen.setBorder(BorderFactory.createBevelBorder(0));
		lImagen.setIcon(new ImageIcon(img.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT)));
		pForm.add(lImagen, reglas);

		reglas.gridx=0;
		reglas.gridy=2;
		reglas.gridwidth=1;
		reglas.gridheight=1;
		reglas.weighty=1.0;
		reglas.anchor=reglas.WEST;
		JLabel lEdad= new JLabel("EDAD: ");
		lEdad.setForeground(Color.WHITE);
		pForm.add(lEdad, reglas);
		
		reglas.gridx=1;
		reglas.gridy=2;
		reglas.gridwidth=1;
		reglas.gridheight=1;
		pForm.add(new JTextField(10), reglas); 
		
		reglas.gridx=0;
		reglas.gridy=3;
		reglas.gridwidth=2;
		reglas.gridheight=1;
		reglas.weighty=1.0;
		reglas.fill=reglas.HORIZONTAL;
		JPanel pSexo= new JPanel();
		pSexo.setBackground(Color.BLUE);
		pSexo.setBorder(BorderFactory.createTitledBorder(null, "SEXO", JLabel.CENTER, JLabel.CENTER, new Font("Arial", Font.BOLD, 11),
				Color.WHITE));
		ButtonGroup bg= new ButtonGroup();
		JRadioButton rM= new JRadioButton("MACHO",true);
		JRadioButton rh= new JRadioButton("HEMBRA");
		rM.setBackground(Color.BLUE);
		rM.setForeground(Color.WHITE);
		rh.setBackground(Color.BLUE);
		rh.setForeground(Color.WHITE);
		bg.add(rM);
		bg.add(rh);
		pSexo.add(rM);
		pSexo.add(rh);
		pForm.add(pSexo, reglas);
		
		reglas.gridx=0;
		reglas.gridy=4;
		reglas.gridwidth=2;
		reglas.gridheight=1;
		reglas.weighty=0.0;
		JLabel lCara= new JLabel("CARACTERISTICAS:", JLabel.LEFT);
		lCara.setForeground(Color.WHITE);;
		pForm.add(lCara, reglas);
		
		reglas.gridx=0;
		reglas.gridy=5;
		reglas.gridwidth=3;
		reglas.gridheight=1;
		reglas.weighty=1.0;
		reglas.fill=reglas.BOTH;
		JTextArea tArea= new JTextArea("Perro con alto grado de inteligencia");
		JScrollPane sp= new JScrollPane(tArea);
		pForm.add(sp, reglas); 
		
		this.add(pForm, BorderLayout.CENTER);
		
	}

}
