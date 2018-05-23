package prClaseComparadora;

import java.util.Comparator;

public class OPEdad implements Comparator< Persona>{
	public int compare(Persona p1, Persona p2) {
		return Integer.compare(p1.getEdad(), p2.getEdad());
	}
}
