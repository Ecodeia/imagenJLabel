package valida;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Valida extends JFrame implements ActionListener {

	private JTextField tNombre, tEdad, tRespuesta;
	private JButton bProcesar;
	

	public Valida() {
		super("Valida");
		this.setSize(250, 250);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Desea salir?","Salir",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		this.setLocationRelativeTo(null);

		JPanel pFom = new JPanel();
		pFom.setLayout(new GridLayout(3, 2, 5, 5));
		pFom.add(new JLabel("NOMBRE:"));

		tNombre = new JTextField(15);
		Validacion.validarLetras(tNombre);
		pFom.add(tNombre);

		pFom.add(new JLabel("EDAD:"));

		tEdad = new JTextField(15);
		Validacion.validarEnteros(tEdad);
		Validacion.validadTama(tEdad, 3);
		pFom.add(tEdad);

		pFom.add(new JLabel("RESPUESTA:"));

		tRespuesta = new JTextField(15);
		tRespuesta.setEditable(false);
		pFom.add(tRespuesta);
		
		this.add(pFom, BorderLayout.CENTER);
		
		bProcesar= new JButton("PROCESAR");
		bProcesar.addActionListener(this);
		this.add(bProcesar, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int edad;
		try {
			edad=Integer.parseInt(tEdad.getText());
		}catch (Exception ex) {
			edad=0;
			
		}
		
		if(edad<18)
			tRespuesta.setText("ES MENOR DE EDAD");
		else
			tRespuesta.setText("ES MAYOR DE EDAD");
	}

}
