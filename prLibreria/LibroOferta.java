package prLibreria;

public class LibroOferta extends Libro{
	double porcDescuento;
	String autoresOferta;
	private static double porcIva = 10;
	private String autor;
	private String titulo;
	private double PrecioBase;
	
	public LibroOferta(String a, String b, double c, double d) {
		autor = a;
		titulo = b;
		PrecioBase = c;
		porcDescuento = d;
		
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	@Override
	public double getPrecioFinal() {
		double px;
		px = PrecioBase - PrecioBase * (porcDescuento/100);
		return px + px * (porcIva/100);  
	}
	
	@Override
	public String toString() {
		return autor + ", "+ titulo + ", "+ PrecioBase + ", "+ porcIva + "% , " + porcDescuento +"% , " + getPrecioFinal();
	}
	
}
 
