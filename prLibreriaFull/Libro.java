package prLibreriaFull;

public class Libro {
	private static double porcIVA = 10.0;
	private String autor;
	private String titulo;
	private double precioBase;
	
	public Libro(String a, String b, double c) {
		autor = a;
		titulo = b;
		precioBase = c;
	}
	public String getAutor() {
		return autor;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	
	public double getPrecioFinal() {
		return precioBase + precioBase*porcIVA/100;
	}
	
	
	@Override
	public String toString() {
		return "("+autor+"; "+titulo+"; "+precioBase+"; "+porcIVA+"; "+this.getPrecioFinal()+")";
	}
	
	public static double getIVA() {
		return porcIVA;
	}
	
	public static void setIVA(double a) {
		porcIVA = a;
	}
}
