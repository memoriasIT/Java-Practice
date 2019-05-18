package prLibreria;

import java.util.Arrays;

public class Libreria {
	private static final int CAP_INICIAL = 16;
	private int numLibs = 0;
	private Libro[] listaLibros;

	public Libreria() {
		listaLibros = new Libro[CAP_INICIAL];
	}
	
	public Libreria(int tam) {
		listaLibros = new Libro[tam];
	}
	
	public void addLibro(String a, String b, double p) {
		Libro lib = new Libro (a, b, p);
		anyadirLibro(lib);
	}

	public void remLibro(String a, String t) {
		int pos = buscarLibro(a, t);
		if (pos != -1) {
			eliminarLibro(pos);
		}
		
	}

	public double getPrecioBase(String a, String t) {
		double precio = 0;
		int pos = buscarLibro(a, t);
		if (pos != -1) {
			precio = listaLibros[pos].getPrecioBase();
		}
		return precio;
	}
	
	public double getPrecioFinal(String a, String t) {
		double precio = 0;
		int pos = buscarLibro(a, t);
		if (pos != -1) {
			precio = listaLibros[pos].getPrecioFinal();
		}
	return precio;
	}
	
	@Override
	public String toString() {
		System.out.print("[");
		for (int i = 0; i < numLibs -1; i++) {
			System.out.print("("+ listaLibros[i].toString() + "),");
			System.out.println();
		}
		System.out.print("(" + listaLibros[numLibs -1].toString() + ")");
		return "";
	}
	
	
	protected void anyadirLibro(Libro lib) {
		int pos = buscarLibro(lib.getAuthor(), lib.getTitulo());
		if ( pos != -1) {
			listaLibros[pos] = lib;
		} else {
			if (numLibs == listaLibros.length) {
				Arrays.copyOf(listaLibros, 2);
			}
		listaLibros[numLibs] = lib;
		numLibs++;
		}
	}
	
	private void eliminarLibro(int pos) {
		listaLibros[pos] = listaLibros[numLibs -1];
		numLibs--;
	}
	
	private int buscarLibro(String a, String t) {
		int pos = -1;
		for (int i = 0; i < numLibs; i++) {
			if(listaLibros[i].getAuthor().equalsIgnoreCase(a) && listaLibros[i].getTitulo().equalsIgnoreCase(t)) {
				pos = i;
			}
		
		}
		return pos;
	}
	
}
