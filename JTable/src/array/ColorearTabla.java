package array;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorearTabla extends DefaultTableCellRenderer{
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		
		
		this.setForeground(Color.WHITE);
		
		Color color=(row%2==0)? Color.BLACK: Color.DARK_GRAY;
		this.setBackground(color);
		
		if(value instanceof JLabel) {
			JLabel imagen=(JLabel) value;
			imagen.setOpaque(true);
			imagen.setBackground(color);
			return imagen;
		}
		
				
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
	}

}
