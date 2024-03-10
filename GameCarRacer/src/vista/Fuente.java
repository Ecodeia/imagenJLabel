package vista;

import java.awt.Font;
import java.io.InputStream;

public class Fuente {
	private Font f= null;
	public Font FuenteCrono(int estilo, int tamanno) {
		InputStream is= getClass().getResourceAsStream("/fuente/INKFREE.TTF");
		try {
			f= Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (Exception e) {
			f= new Font("Arial", 0, 12);
		}
		f= f.deriveFont(estilo, tamanno);
		return f;
	}
}
