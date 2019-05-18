package prClaseComparadora;

import java.util.Comparator;

public class Persona implements Comparable<Persona> {
	String nombre;
	int edad;
	
	public Persona(String nom, int ed) {
		nombre = nom;
		edad = ed;
	}
	
	String getNombre() {
		return nombre;
	}
	
	int getEdad() {
		return edad;
	}
	
	@Override
	public int compareTo(Persona p) {
		int cmp = nombre.compareTo(p.nombre);
		if(cmp == 0){
			cmp = Integer.compare(edad, p.edad);
		}
		return cmp;
	}
}
