package array;

import java.util.Comparator;

public class ComparaVelocidad implements Comparator<Nave>{

	@Override
	public int compare(Nave o1, Nave o2) {
		if(o1.getVelocidad()>o2.getVelocidad())
			return 1;
		else
			if(o1.getVelocidad()<o2.getVelocidad())
				return-1;
			else
				return 0;
	}
	

}
