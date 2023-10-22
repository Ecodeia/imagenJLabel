package aleatorio;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Moneda extends JFrame implements ActionListener {
	private JLabel lImagen;
	private JTextField tResulatado;
	private ImageIcon imagen;
	private JButton bNuevo, bLanzar;
	private int cont, caso;
	private final int INTENTOS=5;
	private String moneda;
	private Random aleatorio;
	private Timer timer;
	private TimerTask tt;
	
	public Moneda() {
		super("Cara y sello");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JLabel lTitulo= new JLabel("Números Aleatorios: Cara y sello.", JLabel.CENTER);
		lTitulo.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
		this.add(lTitulo, BorderLayout.NORTH);
		
		JPanel pCentro= new JPanel(new BorderLayout());
		lImagen= new JLabel("", JLabel.CENTER);
		imagen= new ImageIcon("media/rinicio.jpg");
		lImagen.setIcon(imagen);
		pCentro.add(lImagen, BorderLayout.CENTER);
		
		tResulatado= new JTextField();
		tResulatado.setEditable(false);
		tResulatado.setFont(new Font("Arial", Font.BOLD, 18));
		tResulatado.setHorizontalAlignment(JTextField.CENTER);
		pCentro.add(tResulatado, BorderLayout.SOUTH);
		
		this.add(pCentro, BorderLayout.CENTER);
		
		JPanel pBotones= new JPanel();
		bNuevo= new JButton("NUEVO");
		bNuevo.addActionListener(this);
		pBotones.add(bNuevo);
		
		bLanzar= new JButton("LANZAR");
		bLanzar.addActionListener(this);
		bLanzar.setEnabled(false);
		pBotones.add(bLanzar);
		
		this.add(pBotones, BorderLayout.SOUTH); 
	}
	
	public void iniciar() {
		aleatorio= new Random(123);
		bNuevo.setEnabled(false);
		bLanzar.setEnabled(true);
		tResulatado.setText("");
		moneda="";
		caso=0;
		
	}
	
	
	public void terminar() {
		bNuevo.setEnabled(true);
		bLanzar.setEnabled(false);
		timer.cancel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object bt= e.getSource();
		
		if(bt==bNuevo) {
			cont=0;
			iniciar();
		}
		
		if(bt==bLanzar) {
			bLanzar.setEnabled(false);
			tt= new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(caso==0) {
						cont++;
						if(aleatorio.nextBoolean()) {
							imagen= new ImageIcon("media/rcara.jpg");
							moneda=moneda + " CARA";
						}else {
							imagen= new ImageIcon("media/rsello.jpg");
							moneda= moneda+" SELLO";
						}
						lImagen.setIcon(imagen);
						lImagen.repaint();
						tResulatado.setText(moneda);
						caso=1;
						
					}else if( caso==1) {
						imagen= new ImageIcon("media/rinicio.jpg");
						lImagen.setIcon(imagen);
						lImagen.repaint();
						caso=0;
						if(cont==INTENTOS)terminar();
						
					}
				}
			};
			timer= new Timer();
			timer.schedule(tt, 10,1500);
		}
		
	}

}
