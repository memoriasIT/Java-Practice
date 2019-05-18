package prConcesionario;

import java.util.Arrays;

public class ConcesionarioSimple {
	private static final int CAPACIDAD_INICIAL = 8;
	private int nCoches;
	private Coche[] coches;
	
	public ConcesionarioSimple() {
		nCoches = 0;
		coches = new Coche[CAPACIDAD_INICIAL];
	}
	
	public void anyadir(Coche c) {
		if (nCoches == coches.length) {
			coches = Arrays.copyOf(coches, 2*coches.length);
		}
		coches[nCoches] = c;
		nCoches++;
	}
	
	private Coche BuscarCoche(String m) {
		Coche c = null;
		int i = 0;
		while ((i < nCoches) && !m.equals(coches[i].getModelo())) {
			i++;
		}
		if (i < nCoches) {
			c = coches[i];
		}
		return c;
	}
	
	public double getPrecio(String m) {
		double p = 0;
		Coche c = BuscarCoche(m);
		if (c != null) {
			p = c.getPrecio();
		}
		return p;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		if (nCoches > 0) {
			for (int x = 0; x < nCoches; x++) {
				str.append("[ ").append(coches[x].toString()).append(" ]");
			}
		}
		return str.toString();
	}
	
	
}
