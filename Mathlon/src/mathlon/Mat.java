package mathlon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mat extends JFrame implements ActionListener {
	
	private JLabel LCrono, lsA, lsB, lrA, lrB, lmA, lmB;
	private JTextField tRespS, tRespR, tRespM;
	private JButton bListo, bComenzar, bSalir;
	private int sA, sB, rA, rB, mA, mB, tSuma, tResta, tMul;
	private boolean tiempo;
	private int x;
	
	public Mat() {
		super("MATHLON");
		this.setSize(320, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Norte
		JPanel pTitulo= new JPanel(new GridLayout(2, 2, 5, 5));
		pTitulo.setBackground(Color.white);
		
		JLabel lTitulo= new JLabel("MATHLON", JLabel.RIGHT);
		lTitulo.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
		lTitulo.setForeground(Color.BLUE);
		pTitulo.add(lTitulo);
		
		ImageIcon img= new ImageIcon("media/aritmetica.png");
		JLabel lImagen= new JLabel("",JLabel.CENTER);
		lImagen.setSize(40, 40);
		lImagen.setIcon(new ImageIcon(img.getImage().getScaledInstance(lImagen.getWidth(), lImagen.getHeight(), Image.SCALE_DEFAULT)));
		pTitulo.add(lImagen);
		
		JLabel lTiempo= new JLabel("TIEMPO: ", JLabel.RIGHT);
		lTiempo.setFont(new Font("DS-Digital", Font.BOLD, 25));
		pTitulo.add(lTiempo);
		
		LCrono = new JLabel("30");
		LCrono.setFont(new Font("DS-Digital", Font.BOLD, 25));
		pTitulo.add(LCrono);
		
		this.add(pTitulo, BorderLayout.NORTH);
		
		//Sur
		JPanel pBot= new JPanel(new GridLayout(1,3));
		pBot.setBackground(Color.WHITE);
		
		bListo = new JButton("LISTO!!!");
		bListo.setBackground(Color.BLUE);
		bListo.setForeground(Color.WHITE);
		bListo.addActionListener(this);
		bListo.setEnabled(false);
		pBot.add(bListo);
		
		bComenzar = new JButton("COMENZAR");
		bComenzar.setBackground(Color.BLUE);
		bComenzar.setForeground(Color.WHITE);
		bComenzar.addActionListener(this);
		pBot.add(bComenzar);
		
		bSalir = new JButton("SALIR");
		bSalir.setBackground(Color.BLUE);
		bSalir.setForeground(Color.WHITE);
		bSalir.addActionListener(this);
		pBot.add(bSalir);
		
		this.add(pBot, BorderLayout.SOUTH);
		
		//Centro
		JPanel pForm= new JPanel(new GridLayout(3, 5));
		pForm.setBackground(Color.WHITE);
		
		lsA= new JLabel("");
		pForm.add(lsA);
		pForm.add(new JLabel("+"));
		lsB= new JLabel("");
		pForm.add(lsB);
		pForm.add(new JLabel("="));
		tRespS= new JTextField(4);
		tRespS.setBackground(Color.WHITE);
		tRespS.setEditable(false);
		pForm.add(tRespS);
		
		lrA= new JLabel("");
		pForm.add(lrA);
		pForm.add(new JLabel("-"));
		lrB= new JLabel("");
		pForm.add(lrB);
		pForm.add(new JLabel("="));
		tRespR= new JTextField(4);
		tRespR.setBackground(Color.WHITE);
		tRespR.setEditable(false);
		pForm.add(tRespR);
		
		lmA= new JLabel("");
		pForm.add(lmA);
		pForm.add(new JLabel("x"));
		lmB= new JLabel("");
		pForm.add(lmB);
		pForm.add(new JLabel("="));
		tRespM= new JTextField(4);
		tRespM.setBackground(Color.WHITE);
		tRespM.setEditable(false);
		pForm.add(tRespM);
		
		this.add(pForm, BorderLayout.CENTER);		
	}
	
	public int getResp(JTextField tx) {
		int num=0;
		try {
			num= Integer.parseInt(tx.getText());
			return num;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe escribir un número entero");
			return num;
		}
	}
	
	public void generarNumeros() {
		sA=(int) (Math.random()*100)+1;
		sB=(int) (Math.random()*100)+1;
		rA=(int) (Math.random()*100)+1;
		rB=(int) (Math.random()*100)+1;
		mA=(int) (Math.random()*100)+1;
		mB=(int) (Math.random()*10)+1;
		
		tSuma=sA+sB;
		tResta=rA-rB;
		tMul= mA*mB;
		
		lsA.setText(""+sA);
		lsB.setText(""+sB);
		lrA.setText(""+rA);
		lrB.setText(""+rB);
		lmA.setText(""+mA);
		lmB.setText(""+mB);
	}
	
	public void comenzar() {
		tRespS.setBackground(Color.WHITE);
		tRespR.setBackground(Color.WHITE);
		tRespM.setBackground(Color.WHITE);
		
		tRespS.setText("");
		tRespR.setText("");
		tRespM.setText("");
		
		tRespS.setEditable(true);
		tRespR.setEditable(true);
		tRespM.setEditable(true);
		
		bComenzar.setEnabled(false);
		bListo.setEnabled(true);
		
		LCrono.setText("30");
		LCrono.setForeground(Color.BLACK);
		x=30;
		tiempo=true;
		Crono timer= new Crono();
		timer.start();
	}
	
	public void terminar() {
		tiempo=false;
		bComenzar.setEnabled(true);
		bListo.setEnabled(false);
		
		tRespS.setEditable(false);
		tRespR.setEditable(false);
		tRespM.setEditable(false);
		
		//Opcional
		System.out.println("Suma: "+tSuma);
		System.out.println("Resta: "+tResta);
		System.out.println("Mult: "+tMul);
	}
	
	public void corregir(int rS, int rR, int rM) {
		if(tSuma-rS==0)
			tRespS.setBackground(Color.GREEN);
		else
			tRespS.setBackground(Color.RED);
		
		if(tResta-rR==0)
			tRespR.setBackground(Color.GREEN);
		else
			tRespR.setBackground(Color.RED);
		
		if(tMul-rM==0)
			tRespM.setBackground(Color.GREEN);
		else
			tRespM.setBackground(Color.RED);
	}
	
	private class Crono extends Thread{
		public void run() {
			while(tiempo) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				x--;
				LCrono.setText(""+x);
				
				if(x==0) {
					tiempo=false;
					corregir(getResp(tRespS), getResp(tRespR), getResp(tRespM));
					terminar();
				}
				
				if(x<= 10) {
					LCrono.setForeground(Color.RED);
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object bt= e.getSource();
		if(bt==bSalir)
			System.exit(0);
		if(bt==bComenzar) {
			this.comenzar();
			this.generarNumeros();
		}
		if(bt==bListo) {
			this.terminar();
			this.corregir(getResp(tRespS), getResp(tRespR), getResp(tRespM));
			
		}
		
	}

}
