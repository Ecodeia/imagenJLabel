package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Premio extends JFrame implements MouseListener{
	
	private JPanel pCerrar;
	
	public Premio(double velocidad, int tiempo, String ganador) {
		super("");
		this.setUndecorated(true);
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Fondo pForm=  new Fondo("media/campo.jpg");
		pForm.setLayout(null);
		JLabel lTitulo= new JLabel("PREMIACION!!!");
		lTitulo.setBounds(200,0,600,120);
		lTitulo.setForeground(Color.WHITE);
		lTitulo.setFont(new Fuente().FuenteCrono(Font.BOLD+Font.ITALIC, 80));
		pForm.add(lTitulo);
		
		ImageIcon carro;
		if(ganador.equals("Carro 1"))
			carro= new ImageIcon("media/azul.png");
		else if(ganador.equals("Carro 2"))
			carro= new ImageIcon("media/verde.png");
		else if(ganador.equals("Carro 3"))
			carro= new ImageIcon("media/rojo.png");
		else
			carro= new ImageIcon("media/VIOLETA.png");
		
		JLabel lGanador= new JLabel("Gano el "+ ganador);
		lGanador.setBounds(50, 150, 430, 80);
		lGanador.setForeground(Color.WHITE);
		lGanador.setFont(new Fuente().FuenteCrono(Font.BOLD, 40));
		pForm.add(lGanador);
		
		JLabel lTiempo= new JLabel("Tiempo: "+ tiempo+ " seg.");
		lTiempo.setBounds(50, 220, 400, 80);
		lTiempo.setForeground(Color.WHITE);
		lTiempo.setFont(new Fuente().FuenteCrono(Font.BOLD, 40));
		pForm.add(lTiempo);
		
		JLabel lVelocidad= new JLabel("Velocidad "+ velocidad + " mts/seg");
		lVelocidad.setBounds(50, 290, 450, 80);
		lVelocidad.setForeground(Color.WHITE);
		lVelocidad.setFont(new Fuente().FuenteCrono(Font.BOLD, 40));
		pForm.add(lVelocidad);
		
		JLabel lCarro= new JLabel();
		lCarro.setIcon(carro);
		lCarro.setBounds(235,415,147,75);
		pForm.add(lCarro);
		
		pCerrar= new JPanel();
		pCerrar.setBorder(BorderFactory.createBevelBorder(0));
		pCerrar.setBackground(new Color(100, 100, 100));
		pCerrar.setBounds(800, 620, 170, 60);
		
		JLabel lCerrar= new JLabel("CERRAR", JLabel.CENTER);
		lCerrar.setForeground(Color.WHITE);
		lCerrar.setFont(new Fuente().FuenteCrono(Font.BOLD, 40));
		pCerrar.add(lCerrar);
		pCerrar.addMouseListener(this);
		pForm.add(pCerrar);
		
		this.add(pForm, BorderLayout.CENTER);
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		this.setVisible(false);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		pCerrar.setBackground(new Color(140, 140, 140));
		pCerrar.setBorder(BorderFactory.createBevelBorder(1));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		pCerrar.setBackground(new Color(100, 100, 100));
		pCerrar.setBorder(BorderFactory.createBevelBorder(0));
		
	}

	
}
