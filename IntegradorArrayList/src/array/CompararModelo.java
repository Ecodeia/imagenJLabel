package array;

import java.util.Comparator;

public class CompararModelo implements Comparator<Nave> {

	@Override
	public int compare(Nave o1, Nave o2) {
		return o1.getModelo().compareToIgnoreCase(o2.getModelo());
	}
	

}
