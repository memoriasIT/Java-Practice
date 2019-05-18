package prCuentaPalabrasSimpleFicheros;

public class PalabrasEnTexto {
	String palabra;
	int veces;
	
	public PalabrasEnTexto(String a) {
		palabra = a.toUpperCase();
		veces = 1;
	}
	
	public void incrementa() {
		veces++;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof PalabrasEnTexto) {
			PalabrasEnTexto newpalabra = (PalabrasEnTexto) o;
			if (newpalabra.equals(palabra)) {
				res = true;
			}
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return palabra.hashCode();
	}
	
	@Override
	public String toString() {
		return palabra+": "+veces;
	}
	
}
