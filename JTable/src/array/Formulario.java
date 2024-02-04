package array;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Formulario extends JFrame implements ActionListener {

	private JTextField tCodigo, tModelo, tVelocidad;
	private JComboBox<String> cPlaneta;
	private JButton bLimpiar, bCrear, bOModelo, bOVelocidad, bImprimir,bImagen;
	private JTable tabla;
	private DefaultTableModel dtm;
	private ArrayList<Nave> naves;
	private Nave nave;
	private JFileChooser fc;
	private JLabel lImagen;
	private String archivo;


	public Formulario() {
		super("Registro de Naves");
		this.setSize(730, 1000);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Desea salir?", "Salir",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					System.exit(0);
			}

		});
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// Norte
		JPanel pTitulo = new JPanel();
		pTitulo.setBackground(Color.BLACK);

		JLabel lTitulo = new JLabel("control de naves", JLabel.CENTER);
		lTitulo.setBackground(Color.BLACK);
		lTitulo.setForeground(Color.YELLOW);
		lTitulo.setFont(new Font("Star Jedi", Font.PLAIN, 20));
		pTitulo.add(lTitulo);

		ImageIcon imagen = new ImageIcon("media/alianza.png");
		pTitulo.add(new JLabel(imagen));

		this.add(pTitulo, BorderLayout.NORTH);

		// Centro
		JPanel pCentro = new JPanel(new GridLayout(2, 1, 5, 5));
		pCentro.setBackground(Color.BLACK);

		// Panel Formulario
		JPanel pForm = new JPanel(new GridLayout(6, 2, 10, 10));
		Font fLabel = new Font("Roboto", Font.BOLD, 16);
		pForm.setOpaque(false);
		pForm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(NORMAL), "Datos Nave",
				JLabel.CENTER, JLabel.CENTER, fLabel, Color.GRAY));

		JLabel lCod = new JLabel("CODIGO: ");
		lCod.setFont(fLabel);
		lCod.setForeground(Color.BLUE);
		pForm.add(lCod);

		tCodigo = new JTextField(6);
		tCodigo.setBackground(Color.DARK_GRAY);
		tCodigo.setForeground(Color.WHITE);
		pForm.add(tCodigo);

		JLabel lModelo = new JLabel("MODELO: ");
		lModelo.setFont(fLabel);
		lModelo.setForeground(Color.BLUE);
		pForm.add(lModelo);

		tModelo = new JTextField(6);
		tModelo.setBackground(Color.DARK_GRAY);
		tModelo.setForeground(Color.WHITE);
		pForm.add(tModelo);

		JLabel lPlaneta = new JLabel("Planeta: ");
		lPlaneta.setFont(fLabel);
		lPlaneta.setForeground(Color.BLUE);
		pForm.add(lPlaneta);

		String[] planetas = { "HOT", "CURUSCAN", "CORELIA", "NABU", "ENDOR", "MUSTAFAR" };
		cPlaneta = new JComboBox<String>(planetas);
		cPlaneta.setBackground(Color.DARK_GRAY);
		cPlaneta.setForeground(Color.WHITE);
		pForm.add(cPlaneta);

		JLabel lVelocidad = new JLabel("VELOCIDAD: ");
		lVelocidad.setFont(fLabel);
		lVelocidad.setForeground(Color.BLUE);
		pForm.add(lVelocidad);

		tVelocidad = new JTextField(6);
		tVelocidad.setBackground(Color.DARK_GRAY);
		tVelocidad.setForeground(Color.WHITE);
		pForm.add(tVelocidad);
		
		bImagen = new JButton("IMAGEN");
		bImagen.setBackground(Color.BLUE);
		bImagen.setForeground(Color.WHITE);
		bImagen.setFont(fLabel);
		bImagen.addActionListener(this);
		pForm.add(bImagen);
		
		lImagen= new JLabel("",JLabel.CENTER);
		imagen= new ImageIcon("media/fondo.jpg");
		lImagen.setIcon(imagen);
		lImagen.setSize(200, 200);
		pForm.add(lImagen);

		bCrear = new JButton("CREAR");
		bCrear.setBackground(Color.BLUE);
		bCrear.setForeground(Color.WHITE);
		bCrear.setFont(fLabel);
		bCrear.addActionListener(this);
		pForm.add(bCrear);

		bLimpiar = new JButton("LIMPIAR");
		bLimpiar.setBackground(Color.BLUE);
		bLimpiar.setForeground(Color.WHITE);
		bLimpiar.setFont(fLabel);
		bLimpiar.addActionListener(this);
		pForm.add(bLimpiar);

		pCentro.add(pForm);

		// Panel Tabla
		JPanel pTabla = new JPanel(new BorderLayout());
		pTabla.setOpaque(false);
		pTabla.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(NORMAL), "Listado de Naves",
				JLabel.CENTER, JLabel.CENTER, fLabel, Color.GRAY));

		// Panel de Botones de la tabla
		JPanel pBot = new JPanel();
		pBot.setBackground(Color.BLACK);

		bOModelo = new JButton("ORDENAR MODELO");
		bOModelo.setBackground(Color.BLUE);
		bOModelo.setForeground(Color.WHITE);
		bOModelo.setFont(fLabel);
		bOModelo.addActionListener(this);
		pBot.add(bOModelo);

		bOVelocidad = new JButton("ORDENAR VELOCIDAD");
		bOVelocidad.setBackground(Color.BLUE);
		bOVelocidad.setForeground(Color.WHITE);
		bOVelocidad.setFont(fLabel);
		bOVelocidad.addActionListener(this);
		pBot.add(bOVelocidad);

		bImprimir = new JButton("IMPRIMIR");
		bImprimir.setBackground(Color.BLUE);
		bImprimir.setForeground(Color.WHITE);
		bImprimir.setFont(fLabel);
		bImprimir.addActionListener(this);
		pBot.add(bImprimir);

		pTabla.add(pBot, BorderLayout.NORTH);

		// Crear Tabla
		tabla = new JTable();
		dtm = new DefaultTableModel();
		tabla.setModel(dtm);
		tabla.setRowHeight(200);
		
		// encabezado de la tabla
		dtm.addColumn("CODIGO");
		dtm.addColumn("MODELO");
		dtm.addColumn("PLANETA");
		dtm.addColumn("VELOCIDAD");
		dtm.addColumn("IMAGEN");
		
		
		// color y estilo del encabezado
		tabla.getTableHeader().setBackground(Color.BLUE);
		tabla.getTableHeader().setForeground(Color.WHITE);
		tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

		// ancho de las columnas
		tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		// color de las celdas de la tabla
		tabla.setDefaultRenderer(Object.class, new ColorearTabla());
		tabla.setOpaque(false);

		// Un scroll para el desborde de la tabla
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(tabla);
		tabla.setFillsViewportHeight(true);
		sp.getViewport().setBackground(Color.BLACK);
		
		pTabla.add(sp, BorderLayout.CENTER);

		pCentro.add(pTabla);

		this.add(pCentro, BorderLayout.CENTER);

		naves = new ArrayList<Nave>();
		
		fc= new JFileChooser("media");
		FileNameExtensionFilter filtro1= new FileNameExtensionFilter("Archivo jpg", "jpg");
		FileNameExtensionFilter filtro2= new FileNameExtensionFilter("Archivo png", "png");
		fc.addChoosableFileFilter(filtro1);
		fc.addChoosableFileFilter(filtro2);
		
	}

	public int getVelocidad() {
		int vel = 0;
		try {
			vel = Integer.parseInt(tVelocidad.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debes escribir una cantidad");
		}
		return vel;
	}

	public void limpiar() {
		tCodigo.setText("");
		tModelo.setText("");
		cPlaneta.setSelectedIndex(0);
		tVelocidad.setText("");
		ImageIcon imagen= new ImageIcon("media/fondo.jpg");
		lImagen.setIcon(imagen);
		
	}

	public void llenarTabla(ArrayList<Nave> naves) {
		dtm.setRowCount(0);
		for (Nave n : naves) {
			Object[] filas = new Object[5];
			filas[0] = n.getCodigo();
			filas[1] = n.getModelo();
			filas[2] = n.getPlaneta();
			filas[3] = n.getVelocidad();
			JLabel lima= new JLabel(new ImageIcon("media/"+n.getArchivo()));
			filas[4]= lima;
			dtm.addRow(filas);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object bt = e.getSource();
		
		int op;
		if(bt==bImagen) {
			op=fc.showOpenDialog(null);
			if(op==JFileChooser.APPROVE_OPTION) {
				archivo=fc.getSelectedFile().getName();
				
				ImageIcon imagen= new ImageIcon("media/"+archivo);
				
				Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(lImagen.getHeight(), lImagen.getHeight(), Image.SCALE_DEFAULT));
				lImagen.setIcon(icono);
			}else {
				System.out.println("SE CANCELO LA APERTURA DEL ARCHIVO");
			}
			
		}
		
		if (bt == bCrear) {
			nave = new Nave(tCodigo.getText(), tModelo.getText(), cPlaneta.getSelectedItem().toString(),
					this.getVelocidad(), archivo);
			if (naves.contains(nave))
				JOptionPane.showMessageDialog(null, "Ya existe el código de la nave");
			else {
				naves.add(nave);
				this.limpiar();
				this.llenarTabla(naves);
			}
		}

		if (bt == bLimpiar)
			this.limpiar();

		if (bt == bImprimir)
			try {
				tabla.print();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		if (bt == bOModelo) {
			ArrayList<Nave> copia = new ArrayList<Nave>(naves);
			Collections.sort(copia, new CompararModelo());
			this.llenarTabla(copia);
		}

		if (bt == bOVelocidad) {
			ArrayList<Nave> copia = new ArrayList<Nave>(naves);
			Collections.sort(copia, new ComparaVelocidad());
			this.llenarTabla(copia);
		}

	}

}
