package prConcesionario;

import java.util.Arrays;

public class ConcesionarioIva {
	private static final int CAPACIDAD_INICIAL = 8;
	private int nCoches;
	private Coche[] coches;
	private double porcIva;
	
	public ConcesionarioIva(double iva) {
		nCoches = 0;
		coches = new Coche[CAPACIDAD_INICIAL];
		porcIva = iva;
	}
	
	public void anyadir(Coche c) {
		if (nCoches == coches.length) {
			coches = Arrays.copyOf(coches, 2*coches.length);
		}
		coches[nCoches] = c;
		nCoches++;
	}
	
	public Coche buscarCoche(String m) {
		Coche c = null;
		int i = 0;
		while ((i < nCoches) && (!m.equals(coches[i].getModelo()))) {
			i++;
		}
		if (i < nCoches) {
			c = coches[i];
		}
		return c;
	}
	
	protected double calcPrecioIva(Coche c) {
		double p = c.getPrecio();
		return p + p*porcIva/100;
	}
	
	public double getPrecio(String m) {
		double p = 0;
		Coche c = buscarCoche(m);
		if (c != null) {
			p = calcPrecioIva(c);
			
		}
		return p;
	}
	
	private String cocheToString(Coche c) {
		StringBuilder str = new StringBuilder();
		return str.append("(").append(c.getModelo()).append(", ").append(calcPrecioIva(c)).append(")").toString();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("Iva("+porcIva +" %) " );
		if (nCoches > 0) {
			for (int i = 0; i < nCoches; i++) {
				str.append("[").append(cocheToString(coches[i])).append("]");
			}
		}
		return str.toString();
	}
	
}
