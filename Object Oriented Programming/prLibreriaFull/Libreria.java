package prLibreriaFull;

import java.util.Arrays;

public class Libreria {
	protected static final int CAP_INICIAL = 8;
	private int numLibs;
	private Libro[] libros;
	
	public Libreria() {
		libros = new Libro[CAP_INICIAL];
		numLibs = 0;
	}
	
	public Libreria(int a) {
		libros = new Libro[a];
		numLibs = 0;
	}
	
	public void addLibro(String a, String b, double c) {
		anyadirLibro(new Libro(a, b, c));
	}
	
	public void remLibro(String a, String b) {
		int busqueda = buscarLibro(a, b);
		if(busqueda != -1) {
			eliminarLibro(busqueda);
		} else {
			throw new LibraryException("Book not found!");
		}
	}
	
	public double getPrecioBase(String a, String b) {
		int busqueda = buscarLibro(a, b);
		if(busqueda != -1) {
			return libros[busqueda].getPrecioBase();
		}
		return 0;

	}
	
	public double getPrecioFinal(String a, String b) {
		int busqueda = buscarLibro(a, b);
		if(busqueda != -1) {
			return libros[busqueda].getPrecioFinal();
		}
		return 0;

	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("[");
		for (int i = 0; i < numLibs-1; i++) {
			str.append(libros[i].toString()).append(",\n");
		}
		str.append(libros[numLibs-1].toString());
		return str.append("]").toString();
	}
	
	protected void anyadirLibro(Libro a) {
		int busqueda = buscarLibro(a.getAutor(), a.getTitulo());
		if (busqueda != -1) {
			libros[busqueda] = a;
		} else {
			if ((numLibs) == libros.length) {
				libros = Arrays.copyOf(libros, 2*libros.length);
			}
			libros[numLibs] = a;
			numLibs++;
		}
	}
	
	private void eliminarLibro(int a) {
		if (a > numLibs-1) {
			throw new LibraryException("Index out of bounds!");
		} else {
			libros[a] = libros[numLibs-1];
			numLibs--;
		}
	}
	
	private int buscarLibro(String a, String b) {
		int i = 0;
		while ((i < numLibs) && !(libros[i].getAutor().equalsIgnoreCase(a) && libros[i].getTitulo().equalsIgnoreCase(b))) {
			i++;
		} 
		if (i < numLibs) {
			return i;
		}
		return -1;
	}
}
