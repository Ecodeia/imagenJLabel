package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlador.CMat;

public class VMat extends JFrame implements IMat, ActionListener {
	
	private JTextField tNumA, tNumB, tResp;
	private JButton bCalcular, bLimpiar, bSalir;
	private JRadioButton rSuma, rResta, rMul, rDiv;
	
	public VMat() {
		super("MVC");
		this.setSize(370, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Norte
		JLabel lTitulo= new JLabel("OPERACIONES MATEMATICAS", JLabel.CENTER);
		lTitulo.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 16));
		this.add(lTitulo, BorderLayout.NORTH);
		
		//Sur
		JPanel pBot= new JPanel();
		bCalcular= new JButton("CALCULAR");
		bCalcular.setActionCommand(CALCULAR);
		pBot.add(bCalcular);
		
		bLimpiar= new JButton("LIMPIAR");
		bLimpiar.addActionListener(this);
		pBot.add(bLimpiar);
		
		bSalir= new JButton("SALIR");
		bSalir.addActionListener(this);
		pBot.add(bSalir);
		
		this.add(pBot, BorderLayout.SOUTH);
		
		//Centro
		JPanel pForm= new JPanel(new GridLayout(4, 1, 5, 5));
		
		JPanel pFila1= new JPanel();
		pFila1.add(new JLabel("NUMERO A:"));
		tNumA= new JTextField(20);
		pFila1.add(tNumA);
		pForm.add(pFila1);
		
		JPanel pFila2= new JPanel();
		pFila2.add(new JLabel("NUMERO B:"));
		tNumB= new JTextField(20);
		pFila2.add(tNumB);
		pForm.add(pFila2);
		
		JPanel pFila3= new JPanel();
		pFila3.setBorder(BorderFactory.createTitledBorder("OPERACIONES"));
		ButtonGroup bg= new ButtonGroup();
		rSuma= new JRadioButton("SUMA",true);
		rResta= new JRadioButton("RESTA");
		rMul= new JRadioButton("MULTIPLICACION");
		rDiv= new JRadioButton("DIVISION");
		bg.add(rSuma);
		bg.add(rResta);
		bg.add(rMul);
		bg.add(rDiv);
		pFila3.add(rSuma);
		pFila3.add(rResta);
		pFila3.add(rMul);
		pFila3.add(rDiv);
		pForm.add(pFila3);
		
		JPanel pFila4= new JPanel();
		pFila4.add(new JLabel("RESPUESTA:"));
		tResp= new JTextField(20);
		pFila4.add(tResp);
		pForm.add(pFila4);
		
		this.add(pForm, BorderLayout.CENTER);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object bt= e.getSource();
		
		if(bt== bSalir)
			System.exit(0);
		
		if(bt==bLimpiar) {
			tNumA.setText("");
			tNumB.setText("");
			tResp.setText("");
			rSuma.setSelected(true);
		}
		
	}

	@Override
	public double getA() {
		double a=0.0;
		try {
			a= Double.parseDouble(tNumA.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DEBE ESCRIBIR UN NUMERO.");
		}
		
		return a;
	}

	@Override
	public double getB() {
		double a=0.0;
		try {
			a= Double.parseDouble(tNumB.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DEBE ESCRIBIR UN NUMERO.");
		}
		
		return a;
	}

	@Override
	public char getOperacion() {
		char op=' ';
		if(rSuma.isSelected())
			op='+';
		else if(rResta.isSelected())
			op='-';
		else if(rMul.isSelected())
			op='*';
		else
			op='/';
		return op;
	}
	

	@Override
	public void setRespuesta(double resp) {
		tResp.setText(resp+"");
	}
	
	
	@Override
	public void arrancar() {
		this.setVisible(true);
		
	}

	@Override
	public void setControlador(CMat c) {
		bCalcular.addActionListener(c);
		
	}

}
