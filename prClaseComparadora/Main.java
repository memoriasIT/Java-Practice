package prClaseComparadora;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Comparator<Persona> c1 = new OPEdad();
		
		// Reversed se aplica a un objeto que ya existe, no puede crearse segun un tipo
		Comparator<Persona> c2 = c1.reversed(); 
		
		Comparator<Persona> c3 = c1.reversed().thenComparing(new OPNombre());		
		//Comparator<Persona> c3 = c2.thenComparing(new OPNombre());
	
		
		Comparator<Persona> c4 = Comparator<Persona>.naturalOrder();
		
	}

}
