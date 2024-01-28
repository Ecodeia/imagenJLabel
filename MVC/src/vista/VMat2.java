package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controlador.CMat;

public class VMat2 extends JFrame implements IMat, ActionListener {
	
	private JTextField tNumA, tNumB, tResp;
	private JComboBox<String> cOp;
	private JButton bCalcular, bLimpiar, bSalir;
	
	public VMat2() {
		super("MVC");
		this.setSize(370, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Norte
		JLabel ltitulo= new JLabel("OPERACONES MATEMATICAS",JLabel.CENTER);
		ltitulo.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
		this.add(ltitulo, BorderLayout.NORTH);
		
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
		
		//CENTRO
		JPanel pForm= new JPanel(new GridLayout(4, 2, 5, 5));
		
		pForm.add(new JLabel("NUMERO A:"));
		tNumA=new JTextField(20);
		pForm.add(tNumA);
		
		pForm.add(new JLabel("NUMERO B:"));
		tNumB=new JTextField(20);
		pForm.add(tNumB);
			
		pForm.add(new JLabel("OPERACION:"));
		String[] ops= {"SUMA","RESTA","MULTIPLICACION","DIVISION"};
		cOp= new JComboBox<>(ops);
		pForm.add(cOp);
		
		pForm.add(new JLabel("RESPUESTA:"));
		tResp=new JTextField(20);
		tResp.setEditable(false);
		pForm.add(tResp);
				
		this.add(pForm, BorderLayout.CENTER);
		
	}

	@Override
	public void arrancar() {
		this.setVisible(true);		
	}

	@Override
	public void setControlador(CMat c) {
		bCalcular.addActionListener(c);
		
	}

	@Override
	public double getA() {
		double a=0.0;
		try {
			a=Double.parseDouble(tNumA.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DEBE ESCRIBIR UN NUMERO.");
		}
		return a;
	}

	@Override
	public double getB() {
		double a=0.0;
		try {
			a=Double.parseDouble(tNumB.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DEBE ESCRIBIR UN NUMERO.");
		}
		return a;
	}

	@Override
	public char getOperacion() {
		char op=' ';
		if(cOp.getSelectedItem().toString().equals("SUMA"))
			op='+';
		else if(cOp.getSelectedItem().toString().equals("RESTA"))
			op='-';
		else if(cOp.getSelectedItem().toString().equals("MULTIPLICACION"))
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
	public void actionPerformed(ActionEvent e) {
		Object bt=e.getSource();
		
		if(bt==bSalir)
			System.exit(0);
		if(bt==bLimpiar) {
			tNumA.setText("");
			tNumB.setText("");
			tResp.setText("");
			cOp.setSelectedIndex(0);
		}
		
	}

}
