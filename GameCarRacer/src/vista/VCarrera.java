package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.CCarrera;

public class VCarrera extends JFrame implements ICarrera, MouseListener  {
	private JLabel lCrono, lC1, lC2, lC3, lC4;
	private JPanel pStart, pSalir;
	private JTextField tDistancia;
	private Icon c1, c2, c3, c4;
	private int x, pos1, pos2, pos3, pos4;
	private CCarrera controlador;
	private boolean noGanador;
	private Cronometro timer;
	private Premio premio;
	private Clip clip;
	
	public VCarrera() {
		super("");
		this.setUndecorated(true);
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Fondo pista= new Fondo("media/pistaFinal.jpg");
		pista.setLayout(null);
		
		JLabel lDis= new JLabel("Distancia (mts):");
		lDis.setForeground(Color.WHITE);
		Fuente fuente= new Fuente();
		lDis.setFont(fuente.FuenteCrono(Font.BOLD, 50));
		lDis.setBounds(20, 10, 380, 150);
		pista.add(lDis);
		
		tDistancia= new JTextField(4);
		tDistancia.setForeground(Color.WHITE);
		tDistancia.setFont(fuente.FuenteCrono(Font.BOLD, 50));
		tDistancia.setBounds(400,50,150,60);
		tDistancia.setBorder(null);
		tDistancia.setBackground(new Color(100,100,100));
		tDistancia.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pista.add(tDistancia);
		
		lCrono= new JLabel("Tiempo: 0");
		lCrono.setForeground(Color.WHITE);
		lCrono.setFont(fuente.FuenteCrono(Font.BOLD, 50));
		lCrono.setBounds(700,10,450,150);
		pista.add(lCrono);
		
		lC1= new JLabel();
		c1= new ImageIcon("media/azul.png");
		lC1.setIcon(c1);
		lC1.setBounds(0, 160, 150, 75);
		pista.add(lC1);
		
		lC2= new JLabel();
		c2= new ImageIcon("media/verde.png");
		lC2.setIcon(c2);
		lC2.setBounds(0,250,150,75);
		pista.add(lC2);
		
		lC3= new JLabel();
		c3= new ImageIcon("media/rojo.png");
		lC3.setIcon(c3);
		lC3.setBounds(0, 370, 150, 75);
		pista.add(lC3);
		
		lC4= new JLabel();
		c4= new ImageIcon("media/VIOLETA.png");
		lC4.setIcon(c4);
		lC4.setBounds(0, 465, 150, 75);
		pista.add(lC4);
		
		
		pStart= new JPanel();
		pStart.setBorder(BorderFactory.createBevelBorder(0));
		pStart.setBackground(new Color(100,100,100));
		pStart.setBounds(50,620,150,60);
		JLabel start= new JLabel("", JLabel.CENTER);
		ImageIcon im= new ImageIcon("media/go.png");
		start.setSize(120, 48);
		start.setIcon(new ImageIcon(im.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_DEFAULT)));
		pStart.add(start);
		pStart.addMouseListener(this);
		pista.add(pStart);
		
		pSalir= new JPanel();
		pSalir.setBorder(BorderFactory.createBevelBorder(0));
		pSalir.setBackground(new Color(100,100,100));
		pSalir.setBounds(800,620,150,60);
		JLabel salir= new JLabel("", JLabel.CENTER);
		im= new ImageIcon("media/exit.png");
		salir.setSize(120, 48);
		salir.setIcon(new ImageIcon(im.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_DEFAULT)));
		pSalir.add(salir);
		pSalir.addMouseListener(this);
		pista.add(pSalir);
		
		this.add(pista, BorderLayout.CENTER);
		
		noGanador=true;
		x=0;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object bt= e.getSource();
		if(bt==pStart)
			controlador.actionPerformed(new ActionEvent(this, 3, ICarrera.INICIAR));
		else if(JOptionPane.showConfirmDialog(null, "Desea Salir?","Salir", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
			System.exit(0);
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
		Object p= e.getSource();
		if(p== pStart) {
			pStart.setBackground(new Color(140, 140, 140));
			pStart.setBorder(BorderFactory.createBevelBorder(1));
		}else {
			pSalir.setBackground(new Color(140, 140, 140));
			pSalir.setBorder(BorderFactory.createBevelBorder(1));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object p= e.getSource();
		if(p== pStart) {
			pStart.setBackground(new Color(100, 100, 100));
			pStart.setBorder(BorderFactory.createBevelBorder(0));
		}else {
			pSalir.setBackground(new Color(100, 100, 100));
			pSalir.setBorder(BorderFactory.createBevelBorder(0));
		}
	}

	@Override
	public void arrancar() {
		this.setVisible(true);
		
	}

	@Override
	public void setControlador(CCarrera c) {
		controlador=c;
		
	}

	@Override
	public int getDistancia() {
		int num=0;
		try {
			num=Integer.parseInt(tDistancia.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe escribir un numero entero entre 600 y 1200");
		}
		if(num!=0) {
			if(num<600) {
				this.setDistancia(600);
				num=600;
			}else
				if(num>1200) {
					this.setDistancia(1200);
					num=1200;
				}
		}
		return num;
	}

	@Override
	public void setDistancia(int dis) {
		tDistancia.setText(dis+"");
		
	}

	@Override
	public int getTiempo() {
		return x;
	}
	
	public void reproducirSonido(String ruta) {
		try {
			AudioInputStream sonido= AudioSystem.getAudioInputStream(new File(ruta));
			clip= AudioSystem.getClip();
			clip.open(sonido);
			clip.start();
		} catch (Exception e) {
			System.out.println("ERROR EN ARCHIVO DE AUDIO");
		}
	}
	
	public void pararSonido() {
		clip.stop();
		clip.close();
	}

	@Override
	public void terminar() {
		this.pararSonido();
		pStart.setVisible(true);
		
	}

	@Override
	public void iniciar() {
		x=0;
		lCrono.setText("Tiempo: 0");
		pStart.setVisible(false);
		noGanador=true;
		lC1.setBounds(0, 160, 150, 75);
		lC2.setBounds(0, 250, 150, 75);
		lC3.setBounds(0, 370, 150, 75);
		lC4.setBounds(0, 465, 150, 75);
		this.reproducirSonido("media/DISPARO.wav");
		timer= new Cronometro();
		timer.start();
		
	}
	
	private class Cronometro extends Thread{
		public void run() {
			//reproducirSonido("media/DISPARO.wav");
			reproducirSonido("media/motor.wav");
			while(noGanador) {
				x++;
				lCrono.setText("Tiempo: "+ x);
				controlador.actionPerformed(new ActionEvent(this, 1, ICarrera.ACTUALIZAR));
				lC1.setBounds(pos1, 160, 150, 75);
				lC2.setBounds(pos2, 250, 150, 75);
				lC3.setBounds(pos3, 370, 150, 75);
				lC4.setBounds(pos4, 465, 150, 75);
				
				if(!noGanador) {
					controlador.actionPerformed(new ActionEvent(this, 2, ICarrera.TERMINAR));
				}
				
				try {
					Thread.sleep(40);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	@Override
	public void setPosicion(int car1, int car2, int car3, int car4, boolean noGanador) {
		this.noGanador=noGanador;
		pos1=car1;
		pos2=car2;
		pos3=car3;
		pos4=car4;
		
	}

	@Override
	public void setGanador(double velocidad, String ganador) {
		this.reproducirSonido("media/aplausos.wav");
		premio= new Premio(velocidad, x,ganador);
		premio.setVisible(true);
		
	}
	
	
}
