package valida;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Validacion {
	
	public static void validarLetras(JTextField tx) {
		tx.addKeyListener(new KeyAdapter() {
			public void	keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				
				if(!Character.isAlphabetic(car)) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
	}
	
	public static void validarEnteros(JTextField tx) {
		tx.addKeyListener(new KeyAdapter() {
			public void	keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				
				if(!Character.isDigit(car)) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
	}
	
	public static void validadTama(JTextField tx, int cantidad) {
		tx.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int tamanno=tx.getText().length();
				
				if(tamanno>=cantidad)
					e.consume();
			}
		});
	}

}
