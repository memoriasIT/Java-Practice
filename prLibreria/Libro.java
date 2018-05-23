package prLibreria;

public class Libro {
	private static double porcIva = 10;
	private String autor;
	private String titulo;
	private double PrecioBase;
	
	public Libro() {
		this("none", "none", 0);
	}
	
	public Libro(String a, String b, double p) {
		autor = a;
		titulo = b;
		PrecioBase = p;
	}
	
	public String getAuthor() {
		return autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public double getPrecioBase() {
		return PrecioBase;
	}
	
	public double getPrecioFinal() {
		return PrecioBase + PrecioBase * (porcIva/100);
	}
	
	@Override
	public String toString() {
		return autor + ", "+ titulo + ", "+ PrecioBase + ", "+ porcIva + "% , " + getPrecioFinal();
	}
	
	public double getIVA() {
		return porcIva;
	}
	
	public void setIVA (double num) {
		porcIva = num;
	}
	
	
}

