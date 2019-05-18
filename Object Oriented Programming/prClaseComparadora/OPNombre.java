package prClaseComparadora;

import java.util.Comparator;

// Como es orden alternativo debe de implementar a comparator
public class OPNombre implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}

}
