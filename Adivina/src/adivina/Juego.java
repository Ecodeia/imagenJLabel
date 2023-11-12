package adivina;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Juego extends JFrame implements ActionListener {
	private JTextField tNumero;
	private JButton bJugar, bSalir, bComenzar;
	private JLabel lIntentos, lImagen, lResp;
	private ImageIcon imagen;
	private int aleatorio, intentos;
	private Clip clip;
	
	public Juego() {
		super("ADIVINA");
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//Norte
		JPanel pTitulo= new JPanel();
		pTitulo.setBackground(Color.WHITE);
		JLabel titulo= new JLabel("ADIVINA EL NUMERO");
		titulo.setFont(new Font("Arial", Font.BOLD,23));
		titulo.setForeground(Color.BLUE);
		pTitulo.add(titulo);
		this.add(pTitulo, BorderLayout.NORTH);
		
		//Centro
		JPanel pForm= new JPanel(new BorderLayout());
		pForm.setBackground(Color.WHITE);
		
		JPanel pNorte= new JPanel(new GridLayout(2, 1, 15, 15));
		pNorte.setBackground(Color.WHITE);
		
		JPanel pNum= new JPanel();
		pNum.setBackground(Color.WHITE);
		JLabel texto= new JLabel("Ingrese un número del 1 al 100");
		texto.setFont(new Font("Arial", Font.BOLD, 16));
		texto.setForeground(Color.BLUE);
		pNum.add(texto);
		
		tNumero= new JTextField(4);
		tNumero.setEditable(false);
		tNumero.setBackground(Color.WHITE);
		tNumero.setFont(new Font("DS-Digital", Font.PLAIN, 26));
		pNum.add(tNumero);
		
		bJugar = new JButton("JUGAR!!");
		bJugar.addActionListener(this);
		bJugar.setVisible(false);
		pNum.add(bJugar);
		
		pNorte.add(pNum);
		
		lIntentos= new JLabel("TIENE 5 INTENTOS", JLabel.CENTER);
		lIntentos.setFont(new Font("Arial", Font.BOLD, 20));
		lIntentos.setForeground(Color.BLUE);
		lIntentos.setVisible(false);
		pNorte.add(lIntentos);
		
		pForm.add(pNorte, BorderLayout.NORTH);
		
		lImagen= new JLabel("", JLabel.CENTER);
		imagen= new ImageIcon("media/hola.png");
		lImagen.setSize(200,200);
		lImagen.setIcon(imagen);
		pForm.add(lImagen, BorderLayout.CENTER);
		
		lResp= new JLabel("", JLabel.CENTER);
		lResp.setFont(new Font("Arial", Font.BOLD, 23));
		pForm.add(lResp, BorderLayout.SOUTH);
		
		this.add(pForm, BorderLayout.CENTER);
		
		//Sur
		JPanel pBot= new JPanel();
		pBot.setBackground(Color.WHITE);
		
		bSalir= new JButton("SALIR");
		bSalir.setBackground(Color.BLUE);
		bSalir.setForeground(Color.WHITE);
		bSalir.addActionListener(this);
		bSalir.setFont(new Font("Arial", Font.BOLD, 20));
		pBot.add(bSalir);
		
		bComenzar= new JButton("COMENZAR");
		bComenzar.setBackground(Color.BLUE);
		bComenzar.setForeground(Color.WHITE);
		bComenzar.addActionListener(this);
		bComenzar.setFont(new Font("Arial", Font.BOLD, 20));
		pBot.add(bComenzar);
		
		this.add(pBot, BorderLayout.SOUTH);
		
		intentos= 5;
		clip=null;
	}
	
	public int getNum() {
		int num=0;
		try {
			num= Integer.parseInt(tNumero.getText());
			return num;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DEBE ESCRIBIR UN NUMERO");
			return num;
		}
	}
	
	public int jugar(int numero) {
		intentos--;
		
		if(intentos>0) {
			if(numero>aleatorio)
				return 1;
			else if(numero<aleatorio)
				return -1;
			else
				return 0;
		} else if(numero!= aleatorio)
			return -2;
		else
			return 0;
	}
	
	public void reproducirSonido(String ruta) {
		try {
			AudioInputStream sonido= AudioSystem.getAudioInputStream(new File(ruta));
			clip=AudioSystem.getClip();
			clip.open(sonido);
			clip.start();
		} catch (Exception e) {
			System.out.println("Error al leer el archivo de audio.");
		}
	}
	
	public void detenerSonido() {
		clip.stop();
		clip.close();
	}
	
	public void comenzar() {
		bJugar.setVisible(true);
		tNumero.setEditable(true);
		bComenzar.setVisible(false);
		lIntentos.setVisible(true);
		lIntentos.setText("TIENE 5 INTENTOS");
		lImagen.setIcon(null);
		lResp.setText("");
		tNumero.setText("");
		aleatorio= (int) ((Math.random()*99)+1);
		intentos=5;
		if(clip!=null)
			this.detenerSonido();
	}
	
	public void setResp(int opciones) {
		lIntentos.setText("TIENE "+intentos+" INTENTOS");
		
		if(opciones == 0) {
			lResp.setForeground(Color.GREEN);
			lResp.setText("GANASTE!!!");
			imagen= new ImageIcon("media/snoopyBailando.gif");
			lImagen.setIcon(imagen);
			this.reproducirSonido("media/gano.wav");
			bJugar.setVisible(false);
			bComenzar.setVisible(true);
		} else if(opciones==1) {
			lResp.setForeground(Color.BLUE);
			lResp.setText("EL NUMERO "+tNumero.getText()+" ES MAYOR");
			imagen= new ImageIcon("media/snoopy.gif");
			lImagen.setIcon(imagen);
			this.reproducirSonido("media/typing.wav");
		} else if(opciones== -1) {
			lResp.setForeground(Color.MAGENTA);
			lResp.setText("EL NUMERO "+tNumero.getText()+" ES MENOR");
			imagen = new ImageIcon("media/snoopy.gif");
			lImagen.setIcon(imagen);
			this.reproducirSonido("media/typing.wav");
		}else {
			lResp.setForeground(Color.RED);
			lResp.setText("PERDIO... EL NUMERO ERA "+ aleatorio);
			imagen= new ImageIcon("media/snoopyPerdio.gif");
			lImagen.setIcon(imagen);
			this.reproducirSonido("media/lose.wav");
			bJugar.setVisible(false);
			bComenzar.setVisible(true);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object bt= e.getSource();
		
		if(bt==bSalir)
			System.exit(0);
		if(bt==bComenzar)
			this.comenzar();
		if(bt==bJugar)
			this.setResp(this.jugar(this.getNum()));
	} 
}
