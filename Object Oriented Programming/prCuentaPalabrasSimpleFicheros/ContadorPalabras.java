package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class ContadorPalabras {
	private int numPalabras;
	private static final int TAM_INICIAL = 10;
	private PalabrasEnTexto[] Palabras;
	
	public ContadorPalabras() {
		PalabrasEnTexto Palabras[] = new PalabrasEnTexto[TAM_INICIAL];
		numPalabras = 0;
	}
	
	public ContadorPalabras(int a) {
		PalabrasEnTexto Palabras[] = new PalabrasEnTexto[a];
		numPalabras = 0;
	}
	
	private int esta(String a) {
		PalabrasEnTexto p = new PalabrasEnTexto(a);
		int i = 0;
		while(i < numPalabras && !Palabras[i].equals(p)) {
			++i;
		} if (i == numPalabras) {
			i = -1;
		}
		return i;
	}
	
	protected void incluye(String a) {
		int i = esta(a);
		if (i >= 0) {
			Palabras[i].incrementa();
		} else {
			if (numPalabras == Palabras.length) {
				Palabras = Arrays.copyOf(Palabras, 2*Palabras.length);
			}
		}
	}
	
	private void incluyeTodas(String linea, String del) {
		try(Scanner sc = new Scanner(System.in)){
			sc.useDelimiter(del);
			while (sc.hasNext(del)) {
				incluye(sc.next());
			}
		}
		
//		for(String x : linea.split(del)) {
//			incluye(x);
//		}
	}
	
	public void incluyeTodas(String[] a, String b) {
		
	}
	
	public void incluyeTodasFichero(String a, String b) {
		try (Scanner sc = new Scanner(new File(a))) {
			leerFichero(sc, b);
		}
	}
	
	private void leerFichero(Scanner sc, String delim) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			incluyeTodas(linea, delim);
		}
	}
	
	public PalabraEnTexto encuentra(String a) {
		
	}
	
	@Override
	public String toString() {
		
	}
	
	public void presentaPalabras(String a) {
		
	}
	
	public void presentaPalabras(PrintWriter) {
		
	}
	
	
	
}
