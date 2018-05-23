package prConcesionario;

public class Coche {
	private String modelo;
	private double precio;
	
	public Coche(String m, double p) {
		modelo = m;
		precio = p;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	@Override
	public String toString() {
		return "("+modelo+", " + getPrecio()+");";
	}
	
}
